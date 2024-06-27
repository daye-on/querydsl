package com.example.querydsl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findUserAll() {
        List<User> userList = userRepository.findAll();
        List<UserDto> dtoList = new ArrayList<>();
        UserDto dto = new UserDto();

        for (User u : userList) {
            BeanUtils.copyProperties(u, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }
}
