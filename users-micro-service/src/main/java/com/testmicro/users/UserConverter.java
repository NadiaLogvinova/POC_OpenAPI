package com.testmicro.users;

import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    public UserDTO convert(User user) {
        return UserDTO.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .build();
    }

}
