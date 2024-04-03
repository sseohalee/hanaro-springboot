package com.study.Pr10MemberAdminAPI.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Getter // @Setter는 안넣는 것을 추천한다.
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private String username;
    private String password;
    private String email;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate joindate;
}
