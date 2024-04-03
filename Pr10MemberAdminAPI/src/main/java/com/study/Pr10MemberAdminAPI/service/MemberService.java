package com.study.Pr10MemberAdminAPI.service;

import com.study.Pr10MemberAdminAPI.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.study.Pr10MemberAdminAPI.domain.Member;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final List<Member> memberList = new ArrayList<Member>();

    public void init(){
        Member member = Member.builder()
                .username("admin")
                .email("admin@gmail.com")
                .password("1234")
                .joindate(LocalDate.now())
                .build();
        memberList.add(member);
    }

    public List<Member> findAll(){
        return memberList;
    }

    // 멤버 삭제
    public MemberResDto delete(int index){
        memberList.remove(index);
        return new MemberResDto("ok","삭제되었습니다");
    }

    // 멤버 정보 반환
    public Member get(int index){
        return memberList.get(index);
    }

    // 멤버 정보 수정
    public MemberResDto edit(EditReqDto reqDto){
        Member member = reqDto.toEntity();
        memberList.set(reqDto.getIndex(),member);

        return new MemberResDto("ok","수정되었습니다.");
    }

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
                if(reqDto.getInputName().equals("admin")){
                    return new MemberResDto("ok", "로그인 성공!",1);
                }
                return new MemberResDto("ok", "로그인 성공!");
            }
        }
        return new MemberResDto("false", "로그인 실패");
    }
}
