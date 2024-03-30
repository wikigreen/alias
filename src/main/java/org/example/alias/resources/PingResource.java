package org.example.alias.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class PingResource {


    @GetMapping(produces = "application/json", path = "ping")
    public String ping() {
        return "pong";
    }
}
