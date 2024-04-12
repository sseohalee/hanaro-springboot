package com.study.Ex15ReadDBCRUD.dao;

import com.study.Ex15ReadDBCRUD.dto.MemberDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import java.util.Optional;

// @Mapper : 인터페이스 DAO와 MyBatis mapper XML과 연결하는 용도
@Mapper
public interface IMemberDao {
    // select * list
    public List<MemberDto> list();

    // count(*)
    public int count();

    // insert
    public int insert(MemberDto dto);

    public int insertMap(Map map);

    // findById (select where id=0)
    public Optional<MemberDto> findById(int id);

    // update
    public int update(MemberDto dtd);

    // delete
    public int delete(int id);
    public int deleteMap(int id, String userId);
    public int deleteMap(Map map);

}
