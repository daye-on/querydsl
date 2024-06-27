package com.example.querydsl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

        for (User u : userList) {
            UserDto dto = new UserDto();
            BeanUtils.copyProperties(u, dto);
            dtoList.add(dto);
        }

        return dtoList;
    }

    public void insertUser() {
        User user = User.builder()
                .userName(randomStr(5))
                .userAddress(randomStr(10))
                .userRegDt(LocalDateTime.now())
                .build();
        userRepository.save(user);
    }

    private static String randomStr(int range) {
        StringBuilder stringBuilder = new StringBuilder();
        char ch[] = new char[1];

        for (int i = 0; i < range; i++) {
            ch[0] = (char) ((Math.random() * 26) + 97);
            stringBuilder.append(ch);
        }

        return stringBuilder.toString();
    }
}
