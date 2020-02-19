package com.dish.integrated.cart.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SessionController {

    @RequestMapping("/session")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody String greeting() {
        return "{\"zipcode\": \"90210\"}";
    }

}
