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
@RequestMapping("/api/v1/posts")
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping
    public Long save (@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    //전체게시판조회
    @GetMapping("/list")
    public List<PostsListResponseDto> findAllDesc(){
        return postsService.findAllDesc();
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }


}
