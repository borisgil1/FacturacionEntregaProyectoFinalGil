package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@org.springframework.stereotype.Service
public class UserService {

    @Autowired
    private UserRestApi userRestApi;

    public List<String> getUsuarios() {
        return userRestApi.getUsuarios();
    }
}
