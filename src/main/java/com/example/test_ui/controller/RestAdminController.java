package com.example.test_ui.controller;

import com.example.test_ui.service.TestService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/adminlte")
public class RestAdminController {

    private final TestService testService;

    @GetMapping("/{id}")
    public ResponseEntity getTest(HttpServletRequest request, @PathVariable final Long id) {
        String url = request.getRequestURI();
        return testService.sendGet(url);
    }

    @PostMapping
    public ResponseEntity getTestList(HttpServletRequest request, @RequestBody Map<String, Object> params) {
        String url = request.getRequestURI();
        return testService.sendPost(url, params);
    }

    @PutMapping
    public ResponseEntity saveTest(HttpServletRequest request, @RequestBody Map<String, Object> params) {
        String url = request.getRequestURI();
        return testService.sendPut(url, params);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTest(HttpServletRequest request, @PathVariable final Long id) {
        String url = request.getRequestURI();
        return testService.sendDelete(url);
    }

    @RequestMapping("/test")
    public ResponseEntity getTest() {
        return testService.sendRequest(null);
    }
}
