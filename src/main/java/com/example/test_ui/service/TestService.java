package com.example.test_ui.service;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface TestService {

    ResponseEntity sendRequest(Map<String, Object> request);
    ResponseEntity sendGet(String url);
    ResponseEntity sendPost(String url, Map<String, Object> request);
    ResponseEntity sendPut(String url, Map<String, Object> request);
    ResponseEntity sendDelete(String url);

}
