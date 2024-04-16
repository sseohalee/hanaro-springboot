package com.study.Ex15ReadDBCRUD.service;

import com.study.Ex15ReadDBCRUD.domain.board.Board;
import com.study.Ex15ReadDBCRUD.domain.reply.Reply;
import com.study.Ex15ReadDBCRUD.domain.reply.ReplyRepository;
import com.study.Ex15ReadDBCRUD.dto.BoardResponseDto;
import com.study.Ex15ReadDBCRUD.dto.ReplyResponseDto;
import com.study.Ex15ReadDBCRUD.dto.ReplySaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {
    final private ReplyRepository replyRepository;

    // 중간에 예외(오류)발생 시 rollup을 수행하여, 데이터 일관성을 유지해줌.
    @Transactional
    public Long save(final ReplySaveRequestDto dto){
        Reply entity = replyRepository.save(dto.toEntity());
        return entity.getReplyIdx();
    }

    @Transactional(readOnly = true)
    public boolean existsById(Long replyIdx){
        boolean isFound = replyRepository.existsById(replyIdx);
        return isFound;

    }

    @Transactional(readOnly = true)
    public List<ReplyResponseDto> findAllByReplyBoardIdx(Long boardIdx){
        List<Reply> list = replyRepository.findAllByReplyBoardIdx( boardIdx );
        return list.stream().map(ReplyResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long replyIdx){
        replyRepository.delete(
                replyRepository.findById(replyIdx).orElseThrow(() -> new IllegalArgumentException("없는 댓글 인덱스입니다.replyIdx:"+replyIdx))
        );
    }
}
