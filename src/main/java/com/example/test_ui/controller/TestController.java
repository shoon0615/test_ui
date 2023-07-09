package com.example.test_ui.controller;

import com.example.test_ui.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/admin6")
    public String admin6(Model model) {
        return "/test_ui/admin/main";
    }

    @GetMapping("/adminlte")
    public String adminlte(Model model) {
        return "/test_ui/admin/adminlte";
    }

    @GetMapping("/adminlte/starter")
    public String adminlte_starter(Model model) {
        return "/test_ui/admin/starter";
    }

    @GetMapping("/adminlte/jsgrid")
    public String adminlte_jsgrid(Model model) {
        return "/test_ui/admin/jsgrid";
    }

    @GetMapping("/adminlte/jqxgrid/{num}")
    public String adminlte_jqxgrid(Model model, @PathVariable("num") String num) {
        return "/test_ui/admin/jqxgrid" + num;
    }

}
