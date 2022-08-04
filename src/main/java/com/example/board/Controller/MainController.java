package com.example.board.Controller;

import com.example.board.MyUserDetail;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class MainController {
    @GetMapping("/main")
    public String mainload() {
        return "main/mainpage";
    }
    @GetMapping("/mainnpt")
    public String mainnptload(){
        return "main/mainpageunlock";
    }
    @GetMapping("/managers")
    public String managers(){
        return "header/management";
    }
    @GetMapping("/info")
    public String userAccess(Model model, Authentication authentication) {
        //Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        MyUserDetail userDetail = (MyUserDetail)authentication.getPrincipal();  //userDetail 객체를 가져옴
        model.addAttribute("info", userDetail.getUsername());      //유저 이메일
        return "user_access";
    }
    @GetMapping("/dogam")
    public String dogam(){
        return "main/dogam";
    }
}
