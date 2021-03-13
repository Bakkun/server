package com.danila.server.controller;

import com.danila.server.model.UserDetails;
import com.danila.server.service.UserDetailsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserDetailsController {

    private final UserDetailsService userDetailsService;

    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDetails>> getAll() {
        return new ResponseEntity<>(userDetailsService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDetails> findById(@PathVariable Long id) {
        return new ResponseEntity<>(userDetailsService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserDetails> insert(@ModelAttribute UserDetails userDetails) {
        return new ResponseEntity<>(userDetailsService.insert(userDetails), HttpStatus.OK);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<UserDetails> update(@PathVariable Long id, @ModelAttribute UserDetails userDetails) {
        return new ResponseEntity<>(userDetailsService.update(id, userDetails), HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return new ResponseEntity<>(userDetailsService.delete(id), HttpStatus.OK);
    }
}
