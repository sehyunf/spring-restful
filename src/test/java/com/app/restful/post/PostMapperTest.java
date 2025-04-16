package com.app.restful.post;

import com.app.restful.domain.PostVO;
import com.app.restful.mapper.PostMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    public void insertTest() {
        PostVO postVO = new PostVO();
        postVO.setPostTitle("테스트 게시글 제목 100");
        postVO.setPostContent("테스트 게시글 내용 100");
        postVO.setMemberId(23L);
        postMapper.insert(postVO);

    }

    @Test
    public void updateTest() {
        PostVO postVO = new PostVO();
        postVO.setId(81L);
        postVO.setPostTitle("테스트 게시글 제목 2");
        postVO.setPostContent("테스트 게시글 내용 2");
        postMapper.update(postVO);
    }

    @Test
    public void deleteTest() {
        postMapper.delete(81L);
    }

    @Test
    public void deleteAllTest() {
        postMapper.deleteAll(21L);
    }

}

