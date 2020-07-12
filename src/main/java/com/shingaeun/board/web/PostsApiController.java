package com.shingaeun.board.web;

import com.shingaeun.board.service.posts.PostsService;
import com.shingaeun.board.web.dto.PostsListResponseDto;
import com.shingaeun.board.web.dto.PostsResponseDto;
import com.shingaeun.board.web.dto.PostsSaveRequestDto;
import com.shingaeun.board.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/boardweb/posts")
    public Long save (@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/boardweb/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/boardweb/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    //전체게시판조회
    @GetMapping("/boardweb/")
    public List<PostsListResponseDto> findAllDesc(){
        return postsService.findAllDesc();
    }

    @DeleteMapping("/boardweb/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }


}
