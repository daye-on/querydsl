package com.example.querydsl;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.StringJoiner;

@Entity
@Getter
@Table(name = "TBL_USER")
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_SEQ")
    private long userSeq;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_ADDRESS")
    private String userAddress;

    @Column(name = "USER_REG_DT", columnDefinition = "TIMESTAMP")
    private LocalDateTime userRegDt;

    @Builder
    public User(long userSeq, String userName, String userAddress, LocalDateTime userRegDt) {
        this.userSeq = userSeq;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userRegDt = userRegDt;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("userSeq=" + userSeq)
                .add("userName='" + userName + "'")
                .add("userAddress='" + userAddress + "'")
                .add("userRegDt=" + userRegDt)
                .toString();
    }
}
