package com.app.restful.controller;

import com.app.restful.domain.MemberVO;
import com.app.restful.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RestController
@RequestMapping("members/api/*")
@RequiredArgsConstructor
public class MemberAPI {

    private final MemberService memberService;

//    url 파라미터 : 모든 컨트롤러에서 사용이 가능하지만 보통 rest에서 사용된다.
    @GetMapping("member/{id}")
    public MemberVO getMember(@PathVariable long id) {
        Optional<MemberVO> foundMember = memberService.getMemberInfo(id);
        if(foundMember.isPresent()) {
            return foundMember.get();
        }
//        잘못 전달하면 빈 객체를 전달한다.
//        exception 보다는 null을 보내서 값을 잘못 전달하게 처리한다.
//        그래서 대부분 Optional로 안보낼때가 많지만 상세하게 전달할 때에는 Optional로 전달한다.
        return new MemberVO();
    }

    @Operation(summary = "로그인", description = "로그인할 수 있는 API")
    @PostMapping("login")
    public boolean login(MemberVO memberVO) {
        Optional<MemberVO> foundMember = memberService.login(memberVO);
        if(foundMember.isPresent()) {
            return true;
        }
        return false;
    }

    @Operation(summary = "회원가입", description = "회원가입할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "회원가입 성공")
    @PostMapping("join")
    public MemberVO join(@RequestBody MemberVO memberVO) {
        memberService.join(memberVO);
        Optional<MemberVO> foundMember = memberService.getMemberInfo(memberVO.getId());
        if(foundMember.isPresent()) {
            return foundMember.get();
        }
        return new MemberVO();
    }

    @Operation(summary = "회원정보 수정", description = "회원정보를 수정할 수 있는 API")
    @Parameter(
            name= "id",
            description = "회원 번호",
            schema = @Schema(type="number"),
            in = ParameterIn.PATH,
            required = true
    )
    @PutMapping("update/{id}")
    public MemberVO update(@PathVariable Long id, @RequestBody MemberVO memberVO) {
        memberVO.setId(id);
        memberService.update(memberVO);
        Optional<MemberVO> foundMember = memberService.getMemberInfo(memberVO.getId());
        if(foundMember.isPresent()) {
            return foundMember.get();
        }
        return new MemberVO();
    }

    @Operation(summary = "회원 탈퇴", description = "회원 탈퇴할 수 있는 API")
    @ApiResponse(responseCode = "200", description = "회원 탈퇴 성공")
    @Parameter(
            name = "id",
            description = "회원번호",
            schema = @Schema(type = "number"),
            in = ParameterIn.PATH,
            required = true
    )
    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        memberService.delete(id);
    }





}
