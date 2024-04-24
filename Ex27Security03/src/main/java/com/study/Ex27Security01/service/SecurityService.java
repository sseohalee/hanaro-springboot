package com.study.Ex27Security01.service;

import com.study.Ex27Security01.enumeration.UserRole;
import com.study.Ex27Security01.entity.MemberEntity;
import com.study.Ex27Security01.entity.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {
    MemberRepository memberRepository;

    // 사용자 아이디를 통해, 사용자 정보와 권하는 스프링 시큐리티에 전달해준다.
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<MemberEntity> optional = this.memberRepository.findByUserId(username);
        if(optional.isEmpty()){
            throw new UsernameNotFoundException("사용자를 찾을 수 없습니다.");
        }

        MemberEntity memberEntity = optional.get();

        List<GrantedAuthority> authorities = new ArrayList<>();
        if("admin".equals(username)){
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        // username(아이디) : "hong"
        // password : "1234" 문자열 평문으로 x -> 문자열을 Bcrypt 사이트(bcrypt-generator.com)에서 암호 생성해서 넣는다.

        return new User(memberEntity.getUsername(), memberEntity.getPassword(), authorities);
    }
}
