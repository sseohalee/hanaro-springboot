package com.study.Ex25BoardPageNavi.domain.board;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "board")
@Getter
// new Board() 작성이 불가하여, 객체의 일관성 유지에 좋다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_idx", nullable = false)
    private Long boardIdx;
    @Column(name = "board_name", nullable = false)
    private String boardName; //작성자
    @Column(name = "board_title", nullable = false)
    private String boardTitle; //제목
    @Column(name = "board_content", nullable = false)
    private String boardContent; //내용
    @Column(name = "board_hit", nullable = false)
    private Long boardHit; //조회수
    @Column(name = "board_date", nullable = false)
    private LocalDateTime boardDate = LocalDateTime.now(); //생성일시,수정일시


    // 매개변수가 있는 생성자
    @Builder
    public Board(String boardName, String boardTitle, String boardContent, Long boardHit) {
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
    }

    public void update(String boardName, String boardTitle, String boardContent, Long boardHit) {
        this.boardName = boardName;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardHit = boardHit;
        this.boardDate = LocalDateTime.now(); // 현재시간으로 업데이트
    }
}
