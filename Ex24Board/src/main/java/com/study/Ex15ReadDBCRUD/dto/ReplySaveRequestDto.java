package com.study.Ex15ReadDBCRUD.dto;

import com.study.Ex15ReadDBCRUD.domain.reply.Reply;
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
    private Long replyBoardIdx; // 외래키 - 게시글 인덱스

    @Builder
    public ReplySaveRequestDto(String replyContent, String replyName, Long replyBordIdx) {
        this.replyContent = replyContent;
        this.replyName = replyName;
        this.replyBoardIdx = replyBordIdx;
    }

    public Reply toEntity(){
        return Reply.builder()
                .replyContent(this.replyContent)
                .replyName(this.replyName)
                .replyBoardIdx(this.replyBoardIdx)
                .build();
    }

    @Override
    public String toString() {
        return "ReplySaveRequestDto{" +
                "replyContent='" + replyContent + '\'' +
                ", replyName='" + replyName + '\'' +
                ", replyBoardIdx=" + replyBoardIdx +
                '}';
    }
}
