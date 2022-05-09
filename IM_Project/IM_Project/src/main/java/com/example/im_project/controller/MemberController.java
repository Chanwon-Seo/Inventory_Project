package com.example.im_project.controller;

import com.example.im_project.controller.form.MemberForm;
import com.example.im_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
//@Slf4j
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/joinForm")
    public String joinForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "/auth/joinForm";
    }

    @PostMapping("/join")
    public String join(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "/auth/loginForm";
        }
        memberService.join(form);
        return "/auth/loginForm";
    }

    @GetMapping("/loginForm")
    public String loginForm() {
        return "/auth/loginForm";
    }

//    @GetMapping("")
//    public void asdf(@AuthenticationPrincipal PrincipalDetails principalDetails) {
//        log.info(principalDetails.getUsername());
//    }

}
