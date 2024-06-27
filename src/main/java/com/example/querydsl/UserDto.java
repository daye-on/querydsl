package com.example.querydsl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@Setter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class UserDto {

    @JsonProperty("UserSeq")
    private long userSeq;
    @JsonProperty("UserName")
    private String userName;
    @JsonProperty("UserAddress")
    private String userAddress;
    @JsonProperty("UserRegDt")
    private LocalDateTime userRegDt;

    @Override
    public String toString() {
        return new StringJoiner(", ", UserDto.class.getSimpleName() + "[", "]")
                .add("userSeq=" + userSeq)
                .add("userName='" + userName + "'")
                .add("userAddress='" + userAddress + "'")
                .add("userRegDt=" + userRegDt)
                .toString();
    }
}