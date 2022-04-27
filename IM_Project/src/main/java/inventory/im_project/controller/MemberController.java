package inventory.im_project.controller;

import inventory.im_project.controller.form.MemberForm;
import inventory.im_project.controller.form.MemberLoginForm;
import inventory.im_project.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/members/new")
    public String createForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMemberForm";
    }

    /**
     * 회원저장
     */
    @PostMapping("/members/new")
    public String create(@Valid MemberForm form, BindingResult result) {

        if (result.hasErrors()) {
            return "members/createMemberForm";
        }
        memberService.join(form);//저장

        return "redirect:/";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("memberLoginForm", new MemberLoginForm());
        return "members/login";
    }

    /**
     * 로그인
     */
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute MemberLoginForm loginForm, BindingResult loginResult) {
        int loginNum = memberService.login(loginForm, loginForm.getUser_id());

        if (loginNum == 0) {
            loginResult.rejectValue("password", null, "비밀번호가 틀립니다.");
        }

        if (loginResult.hasErrors()) {
            return "members/login";
        }

        if (loginNum == 1) {
            return "redirect:/";
        } else {
            return "members/login";
        }
    }

}
