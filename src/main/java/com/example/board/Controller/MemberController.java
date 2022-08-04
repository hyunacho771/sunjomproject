package com.example.board.Controller;

import com.example.board.dto.MemberDto;
import com.example.board.Service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@AllArgsConstructor
public class MemberController {
    private MemberService memberService;
    // 메인 페이지
    @GetMapping("/user/login")
    public String index() {
        return "login/login";
    }


    // 회원가입 페이지
    @GetMapping("/user/signup")
    public String dispSignup() {
        return "login/signup";
    }

    // 회원가입 처리
    @PostMapping("/user/signup")
    public String execSignup(MemberDto memberDto) {
        memberService.joinUser(memberDto);
        return "redirect:/user/login";
    }

    // 로그인 결과 페이지
    @GetMapping("/user/login/result")
    public String dispLoginResult() {
        return "/login/loginSuccess";
    }

    @PostMapping("/user/login")
    public String loginresult(){return "/login/loginSuccess";}

    // 로그아웃 결과 페이지
    @GetMapping("/user/logout/result")
    public String dispLogout() {
        return "/login/logout.html";
    }

    // 접근 거부 페이지
    @GetMapping("/user/denied")
    public String dispDenied() {
        return "/login/denied.html";
    }

    // 내 정보 페이지
    @GetMapping("/user/info")
    public String dispMyInfo() {
        return "/login/myinfo.html";
    }

    // 어드민 페이지
    @GetMapping("/admin")
    public String dispAdmin() {
        return "/login/admin.html";
    }
}
