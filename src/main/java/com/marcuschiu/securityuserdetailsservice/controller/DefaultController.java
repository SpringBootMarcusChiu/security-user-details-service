package com.marcuschiu.securityuserdetailsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/")
public class DefaultController {

    @GetMapping
    public Principal test(Principal principal) {
        return principal;
    }
}
