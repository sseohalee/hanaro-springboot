package com.study.Ex15ReadDBCRUD.domain.reply;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    // 기본함수 findAll, existById, save(업데이트, 삽입), delete
    // 쿼리 메소드
    // 게시글 인덱스로 댓글 목록 찾기
    List<Reply> findAllByReplyBoardIdx(Long replyBoradIdx);
}
