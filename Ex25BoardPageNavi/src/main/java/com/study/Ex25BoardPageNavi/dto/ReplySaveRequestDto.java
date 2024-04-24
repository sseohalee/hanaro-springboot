package com.study.Ex25BoardPageNavi.dto;

import com.study.Ex25BoardPageNavi.domain.reply.Reply;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReplySaveRequestDto {
    private String replyContent;
    private String replyName;
    private Long replyBoardIdx; //외래키 - 게시글 인덱스

    @Builder
    public ReplySaveRequestDto(String replyContent, String replyName,
                               Long replyBoardIdx) {
        this.replyContent = replyContent;
        this.replyName = replyName;
        this.replyBoardIdx = replyBoardIdx;
    }
    public Reply toEntity(){
        return Reply.builder()
                .replyContent(this.replyContent)
                .replyName(this.replyName)
                .replyBoardIdx(this.replyBoardIdx)
                .build();
    }
}
