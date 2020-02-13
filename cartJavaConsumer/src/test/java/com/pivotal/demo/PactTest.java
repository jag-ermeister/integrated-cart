package com.pivotal.demo;

import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class PactTest {
    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("provider_service", "localhost", 8090, this);

    //this defines the contract
    @Pact(consumer = "consumer_service", provider="provider_service")
    public RequestResponsePact createPact(PactDslWithProvider builder) {

        String request = "";
        String response = "";
        try{
            String path = "src";
            Path requestPath = Paths.get(path, "test", "resources", "shopify_order.json");
            Path responsePath = Paths.get(path, "test", "resources", "shopify_order_response.json");
            response = Files.readString(responsePath);
            request = Files.readString(requestPath);
        }catch(IOException e){
            throw new RuntimeException("Failed to read from File to initialize expected request and response values");
        }

        return builder
                .given("test POST")
                .uponReceiving("POST REQUEST")
                .path("/admin/api/2020-01/orders.json")
                .body(request)
                .method("POST")
                .willRespondWith()
                .status(201)
                .headers(ImmutableMap.of("Content-Type", "application/json"))
                .body(response)
                .toPact();
    }

    //this is a consumer test
    //I should create a service/client that makes a call to a remote system and returns a DTO - assert on that
    @Test
    @PactVerification //this annotation starts the mock http service
    public void submitOrder_shouldReturn201WithProperHeaderAndBody() {
        JsonParser parser = new JsonParser();

        String request = "";
        String expectedResponse = "";
        JsonElement expectedResponseJson = null;
        try{
            String path = "src";
            Path requestPath = Paths.get(path, "test", "resources", "shopify_order.json");
            Path responsePath = Paths.get(path, "test", "resources", "shopify_order_response.json");
            expectedResponse = Files.readString(responsePath);
            expectedResponseJson = parser.parse(expectedResponse);
            request = Files.readString(requestPath);
            JsonElement expectedRequestJson = parser.parse(request);
        } catch(IOException e){
            throw new RuntimeException("Failed to read from File to initialize expected request and response values;");
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(request, headers);
        // when
        ResponseEntity<String> response = new RestTemplate().postForEntity(
            mockProvider.getUrl() + "/admin/api/2020-01/orders.json",
            entity,
            String.class);

        // then
        assertThat(response.getStatusCode().value()).isEqualTo(201);
        assertThat(response.getHeaders().get("Content-Type").contains("application/json")).isTrue();
        assertEquals(expectedResponseJson, parser.parse(response.getBody()));
    }
}
