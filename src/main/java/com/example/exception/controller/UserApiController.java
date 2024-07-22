package com.example.exception.controller;

import com.example.exception.model.Api;
import com.example.exception.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private static List<UserResponse> userList = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("Hee")
                    .build()
            ,
            UserResponse.builder()
                    .id("2")
                    .age(10)
                    .name("Esther")
                    .build()
    );

    @GetMapping("id/{userId}")
    public Api<UserResponse> getUser(@PathVariable String userId
    ){
        //throw error on purpose for testing
        if(true){
            throw new RuntimeException("message");
        }

        var user = userList.stream().filter(
                it -> it.getId().equals(userId)
        )
        .findFirst()
        .get(); // get() allows user to be null

        Api<UserResponse> response = Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();
        return response;
    }
}
