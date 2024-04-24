package com.study.Ex27Security01;

import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 웹 보안 활성화를 위한 어노테이션
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http // HTTP 요청에 대한 보안설정을 시작한다.
                .authorizeHttpRequests((auth)-> auth
                    // 루트 밑의 모든 경로에 대한 모든 요청을 허가한다.
                        .requestMatchers(new AntPathRequestMatcher("/**"))
                .permitAll())
                .formLogin((formLogin) -> formLogin
                        // 로그인 페이지를 /loginForm URI로 하겠다.
                        .loginPage("/loginForm")
                        // 로그인 성공시 넘어가 URI를 지정한다.
                        .defaultSuccessUrl("/"))
        ;
        return http.build();
    }
}
