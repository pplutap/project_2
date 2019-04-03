package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/group")
public class GroupController {
    @GetMapping
    public List<String> getGroups(){
        return new ArrayList<>();
    }

    @GetMapping("{id}")
    public String getGroup(@PathVariable("id") Long productId) {
        return "get group";
    }

    @PutMapping()
    public String updateGroup(@RequestBody String string){
        return "update product";
    }

    @PostMapping(consumes = "application/json")
    public void createGroup(@RequestBody String string){

    }
}
