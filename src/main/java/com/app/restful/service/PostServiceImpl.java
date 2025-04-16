package com.app.restful.service;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;
import com.app.restful.mapper.PostMapper;
import com.app.restful.repository.PostDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostDAO postDAO;

    @Override
    public List<PostDTO> getPosts() {
        return postDAO.findAll();
    }

    @Override
    public Optional<PostDTO> getPost(Long postId) {
        return postDAO.findById(postId);
    }

    @Override
    public void write(PostVO postVO) {
        postDAO.save(postVO);
    }

    @Override
    public void modify(PostVO postVO) {
        postDAO.update(postVO);
    }

    @Override
    public void remove(Long id) {
        postDAO.delete(id);
    }

    @Override
    public void removeAll(Long memberId) {
        postDAO.deleteAll(memberId);
    }
}
