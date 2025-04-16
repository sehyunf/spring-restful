package com.app.restful.post;

import com.app.restful.domain.PostDTO;
import com.app.restful.repository.PostDAO;
import com.app.restful.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class PostServiceTest {

    @Autowired
    private PostService postService;

    @Autowired
    private PostDAO postDAO;

    @Test
    public void getPostTest() {
        log.info("{}", postService.getPost(2L));
        log.info("{}", postDAO.findById(2L));
    }

}
