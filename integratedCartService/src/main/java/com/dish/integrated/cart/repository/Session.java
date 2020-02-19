package com.dish.integrated.cart.repository;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Session")
public class Session implements Serializable {

    private String id;
    private String zipcode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
