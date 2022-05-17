package com.testmicro.users;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository {

    private HashMap<Long, User> storage = new HashMap<>();

    {
        storage.put(0L, User.builder().id(0L).name("User_#0").roomId(0L).build());
        storage.put(1L, User.builder().id(1L).name("User_#1").roomId(1L).build());
    }

    public List<User> getUsers() {
        return new ArrayList<>(storage.values());
    }

    public User getUser(Long userId) {
        return storage.get(userId);
    }

    public User saveUser(User user) {
        user.setId((long) storage.size());
        storage.put(user.getId(), user);
        return user;
    }
}
