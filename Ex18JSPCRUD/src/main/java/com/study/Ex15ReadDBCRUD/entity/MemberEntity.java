package com.study.Ex15ReadDBCRUD.entity;

import com.study.Ex15ReadDBCRUD.dto.MemberSaveDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name="member")
@Getter // @Setter는 사용 지양 / 엔티티 수정 지양
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="user_id")
    private String userId;
    @Column(name="user_pw")
    private String userPw;
    @Column(name="user_name")
    private String userName;
    @Column(name="user_role")
    private String userRole;
    @Column(name="join_date")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate joinDate;

    public MemberSaveDto toSaveDto(){
        return MemberSaveDto.builder()
                .id(id)
                .userId(userId)
                .userPw(userPw)
                .userName(userName)
                .userRole(userRole)
                .joinDate(joinDate)
                .build();
    }
}
