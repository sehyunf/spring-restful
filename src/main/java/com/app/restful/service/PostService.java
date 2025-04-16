package com.app.restful.service;

import com.app.restful.domain.PostDTO;
import com.app.restful.domain.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public List<PostDTO> getPosts();

    public Optional<PostDTO> getPost(Long postId);

    public void write(PostVO postVO);

    public void modify(PostVO postVO);

    public void remove(Long id);

    public void removeAll(Long memberId);
}
