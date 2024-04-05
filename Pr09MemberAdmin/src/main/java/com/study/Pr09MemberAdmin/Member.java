package com.study.Pr09MemberAdmin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
}