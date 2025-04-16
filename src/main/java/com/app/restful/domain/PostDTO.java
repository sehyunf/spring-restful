package com.app.restful.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
@Schema(description = "게시물 정보")
public class PostDTO {
    @Schema(description = "게시글 번호", required = true, example = "41")
    private Long id;
    @Schema(description = "게시글 제목", required = true, example = "테스트제목")
    private String postTitle;
    @Schema(description = "게시글 내용", required = true, example = "테스트내용")
    private String postContent;
    @Schema(description = "게시자 번호", required = true, example = "41")
    private Long memberId;
    @Schema(description = "조회수", required = true, example = "200L")
    private Long postReadCount;
    @Schema(description = "게시자 이름", required = true, example = "홍길동")
    private String memberName;

}
