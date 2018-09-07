package com.api.examples.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ResponseEntity<String> normalGet() {
        System.out.println("Just a normal GET on api/get request mapping");
        return new ResponseEntity<>("GET normal received", HttpStatus.OK);
    }

    @RequestMapping(value = "/get/id/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> withIdGet(@PathVariable Long id) {
        System.out.println(String.format("Modified GET mapping with path variable ID=%d, on /api/get/{id}",id));
        return new ResponseEntity<>("GET with path variable accepted, id:"+id, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/get/id/{id}/name/{name}", method = RequestMethod.PUT)
    public ResponseEntity<String> optionalFullName(@PathVariable("id") String id,
                                                   @PathVariable("name") String name,
                                                   @RequestParam(name = "lastName",
                                                           defaultValue = "Doe") String lastName,
                                                   @RequestParam(name = "nickname",
                                                           defaultValue = "Bolony") String nickname) {
        System.out.println("id = [" + id + "], name = [" + name + "], lastName = [" + lastName + "], nickname = [" + nickname + "]");
        return new ResponseEntity<>("GET with complex params and path variables", HttpStatus.OK);
    }
}
