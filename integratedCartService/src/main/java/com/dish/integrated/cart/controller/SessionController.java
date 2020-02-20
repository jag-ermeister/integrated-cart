package com.dish.integrated.cart.controller;

import com.dish.integrated.cart.repository.Session;
import com.dish.integrated.cart.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SessionController {

    @Autowired SessionRepository sessionRepository;

    @RequestMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody String hello() {
        return "Hello World!";
    }

    @RequestMapping("/session")
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody Session greeting(@RequestBody Session request) {
        Session session = new Session();
        session.setZipcode(request.getZipcode());
        sessionRepository.save(session);
        return session;
    }
}

