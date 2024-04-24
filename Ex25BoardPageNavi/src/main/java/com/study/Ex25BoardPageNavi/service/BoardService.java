package com.study.Ex25BoardPageNavi.service;

import com.study.Ex25BoardPageNavi.domain.board.Board;
import com.study.Ex25BoardPageNavi.domain.board.BoardRepository;
import com.study.Ex25BoardPageNavi.dto.BoardResponseDto;
import com.study.Ex25BoardPageNavi.dto.BoardSaveRequestDto;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    // 전체목록 조회 - 페이징
    @Transactional(readOnly = true)
    public Page<Board> getList(int page){
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("boardDate")); //최신글을 먼저보여준다.

        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return boardRepository.findAll( pageable );
    }

    // 전체목록 조회
    @Transactional(readOnly = true)
    public List<BoardResponseDto> findAll(){
        // 정렬기능 추가
        Sort sort = Sort.by(Sort.Direction.DESC, "boardDate", "boardIdx");
        List<Board> list = boardRepository.findAll(sort);

        // List<Board>를 List<BoardResponseDto>로 변환: stream() 메소드 사용
        return list.stream().map(BoardResponseDto::new).collect(Collectors.toList());
    }

    //JPA를 사용한다면, 서비스(Service) 클래스에서 필수적으로 사용되어야 하는 어노테이션입니다.
    //일반적으로 메서드 레벨에 선언하게 되며, 메서드의 실행, 종료, 예외를 기준으로
    //각각 실행(begin), 종료(commit), 예외(rollback)를 자동으로 처리해 줍니다.
    // Transaction : 일련의 작업의 단위(단일작업의 모음-Select, Update, Insert, Delete, Drop, Alter)
    // 트랜잭션 시작 : 일련의 작업의 시작
    // 트랜잭션 종료 : 일련의 작업의 종료(커밋 발생 - 물리DB에 적용)
    // 트랜잭션 예외 : 일련의 작업중 예외발생(로백 발생 - 처음 작업시작전 상태로 되돌림)
    // 예) 은행 송금 처리(하나의 트랜잭션)
    //    1. A계좌 : 1000원 감소  -> 성공
    //    2. B계좌 : 1000원 증가  -> 통신오류!
    //    3. 송금 내역 저장
    // @Transactional: 일련의 배치작업 중 예외가 발생시 Rollback 작동시킴
    @Transactional
    public Long save(final BoardSaveRequestDto dto){
        Board entity = boardRepository.save(dto.toEntity());
        return entity.getBoardIdx();
    }

    @Transactional
    public BoardResponseDto saveToDto(final BoardSaveRequestDto dto){
        Board entity = boardRepository.save( dto.toEntity() );
        return new BoardResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public boolean existsById(Long boardIdx){
        boolean isFound = boardRepository.existsById( boardIdx );
        return isFound;
    }

    @Transactional(readOnly = true)
    public BoardResponseDto findById(Long boardIdx){
        Board entity
                = boardRepository.findById( boardIdx )
                .orElseThrow( () -> new IllegalArgumentException(
                        "없는 글인덱스입니다.boardIdx:"+boardIdx));
        return new BoardResponseDto(entity);
    }
    @Transactional
    public Board updateHit(final Long boardIdx, final Long hit){
        Board entity = boardRepository.findById(boardIdx)
                .orElseThrow( () -> new IllegalArgumentException(
                        "없는 글인덱스입니다.boardIdx:"+boardIdx));
//        entity.updateHit( hit );
        return entity;
    }
    @Transactional
    public Board update(final Long boardIdx, final BoardSaveRequestDto dto){
        Board entity = boardRepository.findById(boardIdx)
                .orElseThrow( () -> new IllegalArgumentException(
                        "없는 글인덱스입니다.boardIdx:"+boardIdx));
        entity.update(dto.getBoardName(), dto.getBoardTitle(),
                dto.getBoardContent(), dto.getBoardHit());
        //save()함수를 쓰지 않아도 update가 된다.
        //엔티티의 영속성 컨텍스트 속성으로 인해, update가 이루어짐.
        //@Transactional을 사용해야 됨.
        //예전의 방식) Board newEntity = boardRepository.save( entity );
        return entity;
    }
    @Transactional
    public BoardResponseDto updateToDto(final Long boardIdx, final BoardSaveRequestDto dto) {
        Board entity = boardRepository.findById(boardIdx)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. board_idx="+boardIdx) );

        entity.update(dto.getBoardTitle(), dto.getBoardContent(),
                dto.getBoardName(), dto.getBoardHit());
        //엔티티의 영속성 컨텍스트 속성으로 인해 update를 위한 save함수 호출이 필요없다.@Transactional안에서.
        //Board new_entity = boardRepository.save( entity );

        return new BoardResponseDto(entity);
    }
    @Transactional
    public void delete(final Long boardIdx){
        Board entity = boardRepository.findById( boardIdx )
                .orElseThrow( () -> new IllegalArgumentException("해당 글 인덱스가 없습니다. boardIdx:"+boardIdx));

        boardRepository.delete( entity );

    }
    @Transactional
    public Long deleteToLong(final Long boardIdx) {
        Board entity = boardRepository.findById(boardIdx)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. boardIdx="+boardIdx) );
        boardRepository.delete( entity );

        return boardIdx;
    }
}
