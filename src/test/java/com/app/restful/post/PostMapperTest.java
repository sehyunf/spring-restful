package com.app.restful.post;

import com.app.restful.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class PostMapperTest {

    @Autowired
    private PostMapper postMapper;

    @Test
    public void SelectAllTest() {
        log.info("{}", postMapper.selectAll());
    }

    @Test
    public void SelectTest() {
        log.info("{}", postMapper.selectById(2L));
    }

}

