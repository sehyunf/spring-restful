package com.app.restful.member;

import com.app.restful.mapper.MemberMapper;
import com.app.restful.repository.MemberDAO;
import com.app.restful.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class ServiceTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void memberSelectTest() {
        log.info("{}", memberMapper.select(1L));
    }

}
