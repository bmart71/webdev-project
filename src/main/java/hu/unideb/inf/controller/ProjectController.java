package hu.unideb.inf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/src")
public class ProjectController {
    @GetMapping("/helloworld")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}
