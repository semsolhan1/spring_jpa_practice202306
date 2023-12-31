package com.spring.jpa.chap05_practice.api;

import com.spring.jpa.chap05_practice.dto.PageDTO;
import com.spring.jpa.chap05_practice.dto.PostListResponseDTO;
import com.spring.jpa.chap05_practice.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostApiController {

  // 리소스: 게시물 (Post)
/*
게시물 목록 조회: /posts       - GET
게시물 개별 조회: /posts/{id}  - GET
게시물 등록:     /posts       - POST
게시물 수정:     /posts/{id}  - PATCH
게시물 삭제:     /posts/{id}  - DELETE
*/


  //@Autowired 역할을 한다.
  private final PostService postService;//@RequiredArgsConstructor때문에 간다.

  @GetMapping
  public ResponseEntity<?> list(PageDTO pageDTO) {
    log.info("/api/v1/posts?page={}&size{}", pageDTO.getPage(), pageDTO.getSize());

    PostListResponseDTO dto = postService.getPosts(pageDTO);

    return ResponseEntity
            .ok()
            .body(dto);
  }

}
