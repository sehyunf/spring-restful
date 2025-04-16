package com.app.restful.repository;

import com.app.restful.domain.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

    public Optional<MemberVO> findById(Long id){
        return memberMapper.select(id);
    }

    public Optional<MemberVO> findByEmailAndPassword(MemberVO memberVO){
        return memberMapper.selectOne(memberVO);
    }

    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

    public void update(MemberVO memberVO){
        memberMapper.update(memberVO);
    }

    public void delete(Long id){
        memberMapper.delete(id);
    }
}
