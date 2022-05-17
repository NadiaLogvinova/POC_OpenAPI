package com.testmicro.users;

import com.testmicro.rooms.api.RoomsApi;
import com.testmicro.rooms.model.Room;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDTOConverter userDTOConverter;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoomsApi roomsApi;

    public List<UserDTO> getUsers() {
        List<User> users = userRepository.getUsers();
        return users.stream().map(user -> userConverter.convert(user)).collect(Collectors.toList());
    }

    @SneakyThrows
    public UserDTO getUser(Long userId) {
        User user = userRepository.getUser(userId);
        UserDTO userDTO = userConverter.convert(user);

        // NOTE: Integration with Room-service
        Room room = roomsApi.getRoom(user.getRoomId().toString());
        userDTO.setRoomAddress(room.getAddress());

        return userDTO;
    }

    @SneakyThrows
    public UserDTO create(UserDTO userDTO) {
        Room room1 = new Room();
        room1.address(userDTO.getRoomAddress());
        // NOTE: Integration with Room-service
        Room room = roomsApi.createRoom(room1);

        User user = userDTOConverter.convert(userDTO);
        user.setRoomId(room.getId());
        User savedUser = userRepository.saveUser(user);
        return userConverter.convert(savedUser);
    }
}
