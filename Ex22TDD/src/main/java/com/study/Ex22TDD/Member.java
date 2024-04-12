package com.study.Ex22TDD;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    private String loginId;
    private String loginPw;
}
