package com.kodilla.ecommercee;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @PostMapping(value = "user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok().build();
    }
    @PutMapping(value = "/{id}/block")
    public ResponseEntity<Void> blockUser(Long userId){
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "keygenerate")
    public ResponseEntity<UserKeyDto> generateKey() {
        return ResponseEntity.ok(null);
    }
}
