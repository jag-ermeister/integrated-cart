package com.dish.integrated.cart.contract;

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

import static com.dish.integrated.cart.util.FileUtils.readFromFile;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

public class ShopifyConsumerContractTest {

    static final String SHOPIFY_ORDERS_API = "/admin/api/2020-01/orders.json";
    static final String SHOPIFY_ORDER_REQUEST_FILE = "shopify_order_request.json";
    static final String SHOPIFY_ORDER_RESPONSE_FILE = "shopify_order_response.json";

    JsonParser parser = new JsonParser();

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("shopify_orders_provider", "localhost", 8090, this);

    @Pact(consumer = "shopify_orders_consumer", provider="shopify_orders_provider")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        return builder
                .given("test POST")
                .uponReceiving("POST REQUEST")
                .path(SHOPIFY_ORDERS_API)
                .body(getResourceContents(SHOPIFY_ORDER_REQUEST_FILE))
                .method("POST")
                .willRespondWith()
                .status(201)
                .headers(ImmutableMap.of(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .body(getResourceContents(SHOPIFY_ORDER_RESPONSE_FILE))
                .toPact();
    }

    @Test
    @PactVerification
    public void submitOrder_shouldReturn201WithProperHeaderAndBody() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> response = new RestTemplate().postForEntity(
            mockProvider.getUrl() + SHOPIFY_ORDERS_API,
                new HttpEntity<>(getResourceContents(SHOPIFY_ORDER_REQUEST_FILE), headers),
                String.class
        );

        assertThat(response.getStatusCode().value()).isEqualTo(201);
        assertThat(response.getHeaders().get(CONTENT_TYPE).contains(MediaType.APPLICATION_JSON_VALUE)).isTrue();
        assertEquals(getJsonFromFile(SHOPIFY_ORDER_RESPONSE_FILE), parser.parse(response.getBody()));
    }

    private JsonElement getJsonFromFile(String filename) {
        return parser.parse(getResourceContents(filename));
    }

    private String getResourceContents(String resourceFilename) {
        Path resourceFilePath = Paths.get("src", "test", "resources", resourceFilename);
        return readFromFile(resourceFilePath.toString());
    }
}
