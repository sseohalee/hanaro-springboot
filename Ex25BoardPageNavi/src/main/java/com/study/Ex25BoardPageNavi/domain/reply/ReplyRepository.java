package com.study.Ex25BoardPageNavi.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findAllByReplyBoardIdxOrderByReplyDateDesc(Long replyBoradIdx);
}
