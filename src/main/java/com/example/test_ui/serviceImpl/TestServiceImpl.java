package com.example.test_ui.serviceImpl;

import com.example.test_ui.service.TestService;
import com.example.test_ui.util.RestTemplateAdapter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    // WebClient 로 변경 예정
    private final RestTemplateAdapter apiAdapter;

    @Value("${api-url}")
    private String apiUrl;

    @Override
    public ResponseEntity sendRequest(Map<String, Object> request) {
        return apiAdapter.commonSend(request);
    }

    @Override
    public ResponseEntity sendGet(String url) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.GET, null);
    }

    @Override
    public ResponseEntity sendPost(String url, Map<String, Object> request) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.POST, request);
    }

    @Override
    public ResponseEntity sendPut(String url, Map<String, Object> request) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.PUT, request);
    }

    @Override
    public ResponseEntity sendDelete(String url) {
        return apiAdapter.commonSend(apiUrl + url, HttpMethod.DELETE, null);
    }
}
