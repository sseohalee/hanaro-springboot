package com.study.Ex15ReadDBCRUD.dto;

import com.study.Ex15ReadDBCRUD.entity.MemberEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

// html 입력폼 <-> DTO <-> DAO(Entity) <-> Repo 클래스 <-> DB
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberJoinDto {
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private Long id;

    @Size(min=4, max=20, message = "아이디는 4자이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userId;

    @Size(min=4, max=20, message = "암호는 4자이상 20자 이하입니다.")
    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userPw;

    private String userName;

    @NotBlank(message = "null, 빈문자열, 스페이스문자열만 넣을 수 없습니다.")
    private String userRole;

    private String userAddress;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate joinDate;

    //DTO를 save용 Entity로 변환해주는 메소드
    public MemberEntity toSaveEntity(){
        return MemberEntity.builder()
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
    //DTO를 update용 Entity로 변환해주는 메소드
    public MemberEntity toUpdateEntity(){
        return MemberEntity.builder()
                .id(id)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
}
