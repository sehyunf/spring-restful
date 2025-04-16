package com.app.restful.service;

import com.app.restful.domain.MemberVO;

import java.util.Optional;

public interface MemberService {

    public Optional<MemberVO> getMemberInfo(long id);
    public Optional<MemberVO> login(MemberVO memberVO);
    public void join(MemberVO member);
    public void update(MemberVO member);
    public void delete(Long id);
}
