package com.app.restful.member;


import com.app.restful.domain.MemberVO;
import com.app.restful.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class MapperTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void insertTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test");
        memberVO.setMemberName("장보고");
        memberVO.setMemberPassword("test");
        memberMapper.insert(memberVO);
    }

    @Test
    public void loginTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setMemberEmail("test0001@gmail.com");
        memberVO.setMemberPassword("1234");
        log.info("{}",memberMapper.selectOne(memberVO));

        memberVO.setMemberEmail("test0001@gmail.com");
        memberVO.setMemberPassword("1235");
        log.info("{}",memberMapper.selectOne(memberVO));
    }

    @Test
    public void updateTest() {
        MemberVO memberVO = new MemberVO();
        memberVO.setId(41L);
        memberVO.setMemberEmail("test");
        memberVO.setMemberName("test");
        memberVO.setMemberPassword("test");
        memberMapper.update(memberVO);
    }

    @Test
    public void deleteTest() {
        memberMapper.delete(41L);
    }


}
