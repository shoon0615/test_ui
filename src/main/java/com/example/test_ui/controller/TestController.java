package com.example.test_ui.controller;

import com.example.test_ui.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final TestService testService;

    @GetMapping("/main")
    public String view(Model model) {
        ResponseEntity result = testService.sendGet("/api/v1/test/1");
        model.addAttribute("result", result.getBody());
        return "/test_ui/main";
    }

    // security 체크용
    @GetMapping("/main2")
    public String view2(Model model) {
        return "/test_ui/main";
    }

    @GetMapping("/admin")
    public String admin(Model model) {
        return "/test_ui/admin/main";
    }

    @GetMapping("/admin4")
    public String admin4(Model model) {
        return "/test_ui/admin/main";
    }

}
