package com.app.restful.mapper;

import com.app.restful.domain.PostVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {
//    게시글 목록
    public List<PostVO> selectAll();
//    게시글 한개
    public Optional<PostVO> selectById(Long id);


}
