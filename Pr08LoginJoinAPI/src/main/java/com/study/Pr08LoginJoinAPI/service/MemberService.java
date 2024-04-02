package com.study.Pr08LoginJoinAPI.service;

import com.study.Pr08LoginJoinAPI.domain.Member;
import com.study.Pr08LoginJoinAPI.web.dto.DuplReqDto;
import com.study.Pr08LoginJoinAPI.web.dto.JoinReqDto;
import com.study.Pr08LoginJoinAPI.web.dto.LoginReqDto;
import com.study.Pr08LoginJoinAPI.web.dto.MemberResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final List<Member> memberList = new ArrayList<Member>();

    // 회원가입 (저장)
    public MemberResDto save(JoinReqDto reqDto){
        System.out.println(reqDto.getInputName());
        memberList.add(reqDto.toEntity());
        return new MemberResDto("ok", "회원 가입이 완료되었습니다.");
    }

    public Optional<Member> findByName(String name) {
        return memberList.stream().filter(m -> m.getUsername().equals(name))
                .findAny();
    }

    // 아이디 중복 확인
    public MemberResDto dupl(DuplReqDto reqDto){
        boolean isDupl = false;
        MemberResDto resDto = new MemberResDto();

        for( Member m : memberList ){
            if(m.getUsername().equals( reqDto.getInputName() ) ){
                //중복됨
                isDupl = true;
                break;
            }
        }

        if( isDupl ){
            resDto.setStatus("ok");
            resDto.setMessage("중복된 아이디가 있습니다.");
        }else {//중복된 이름이 없으면
            resDto.setStatus("ok");
            resDto.setMessage("중복된 아이디가 없습니다.");
        }
        return resDto;
    }

    // 로그인
    public MemberResDto login(LoginReqDto reqDto){
        for(Member m : memberList){
            if(m.getUsername().equals(reqDto.getInputName())
                    && m.getPassword().equals(reqDto.getInputPw())){
                return new MemberResDto("ok", "로그인 성공!");
            }
        }
        return new MemberResDto("false", "로그인 실패");
    }
}
