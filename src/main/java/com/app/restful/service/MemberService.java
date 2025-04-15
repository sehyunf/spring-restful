package com.app.restful.service;

import com.app.restful.domain.MemberVO;

import java.util.Optional;

public interface MemberService {

    public Optional<MemberVO> getMemberInfo(long id);
}
