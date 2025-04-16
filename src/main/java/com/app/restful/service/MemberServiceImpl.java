package com.app.restful.service;

import com.app.restful.domain.MemberVO;
import com.app.restful.mapper.MemberMapper;
import com.app.restful.repository.MemberDAO;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;
    private final PostDAO postDAO;

    @Override
    public Optional<MemberVO> getMemberInfo(long id) {
        return memberDAO.findById(id);
    }

    @Override
    public Optional<MemberVO> login(MemberVO memberVO) {
        return memberDAO.findByEmailAndPassword(memberVO);
    }

    @Override
    public void join(MemberVO member) {
        memberDAO.save(member);
    }

    @Override
    public void update(MemberVO member) {
        memberDAO.update(member);
    }

    @Override
    public void delete(Long id) {
        postDAO.deleteAll(id);
        memberDAO.delete(id);
    }
}
