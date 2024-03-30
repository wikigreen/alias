package org.example.alias.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/rand")
public class RandNumberResource {

    @GetMapping(produces = "application/json")
    public Double ping() {
        return Math.random();
    }
}
