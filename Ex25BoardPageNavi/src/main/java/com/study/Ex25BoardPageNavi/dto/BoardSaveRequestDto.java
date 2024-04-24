package com.study.Ex25BoardPageNavi.dto;

import com.study.Ex25BoardPageNavi.domain.board.Board;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardSaveRequestDto {
    private String boardTitle;
    private String boardContent;
    private String boardName;
    private Long boardHit;

    @Builder
    public BoardSaveRequestDto(String boardTitle, String boardContent, String boardName, Long boardHit) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardName = boardName;
        this.boardHit = boardHit;
    }

    public Board toEntity(){
        return Board.builder()
                .boardTitle(this.boardTitle)
                .boardContent(this.boardContent)
                .boardName(this.boardName)
                .boardHit(this.boardHit)
                .build();
    }
}
