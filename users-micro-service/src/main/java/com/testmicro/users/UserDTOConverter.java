package com.testmicro.users;

import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

    public User convert(UserDTO userDTO) {
        return User.builder()
                    .id(userDTO.getId())
                    .name(userDTO.getName())
                    .build();
    }

}
