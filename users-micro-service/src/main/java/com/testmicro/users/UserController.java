package com.testmicro.users;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @SneakyThrows
    @GetMapping(value = "/users")
    public List<UserDTO> getAll() {
        return userService.getUsers();
    }

    @SneakyThrows
    @GetMapping(value = "/users/{id}")
    public UserDTO get(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @SneakyThrows
    @PostMapping(value = "/users")
    public UserDTO create(@RequestBody UserDTO userDTO) {
        return userService.create(userDTO);
    }

}
