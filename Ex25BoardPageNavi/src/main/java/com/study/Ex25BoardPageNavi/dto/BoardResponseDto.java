package com.study.Ex25BoardPageNavi.dto;

import com.study.Ex25BoardPageNavi.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardResponseDto {
    private Long boardIdx;
    private String boardTitle; // 제목
    private String boardContent; // 내용
    private String boardName; // 작성자
    private Long boardHit; // 조회수
    private LocalDateTime boardDate; // 생성일시, 수정일시

    // 필드가 있는 생성자: Entity to Dto
    public BoardResponseDto(Board entity){
        this.boardIdx = entity.getBoardIdx();
        this.boardTitle = entity.getBoardTitle();
        this.boardContent = entity.getBoardContent();
        this.boardName = entity.getBoardName();
        this.boardHit = entity.getBoardHit();
        this.boardDate = entity.getBoardDate();
    }
}
