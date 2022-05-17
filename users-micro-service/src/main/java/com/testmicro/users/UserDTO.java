package com.testmicro.users;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String roomAddress;

}
