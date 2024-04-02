package com.study.Pr08LoginJoinAPI.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter // @Setter는 안넣는 것을 추천한다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String username;
    private String password;
    private String email;
    private LocalDate joindate;
}
