package com.example.test_ui.util;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.thymeleaf.util.StringUtils;

@Slf4j
@Service
@Qualifier("restTemplate")
public class RestTemplateAdapter {

    public ResponseEntity commonSend(Object body) {
        RestTemplate restTemplate = new RestTemplate();

        // config 셋팅
        String url = this.getUrl().getServletPath();        // getRequestURI()?
        HttpMethod method = HttpMethod.valueOf(this.getUrl().getMethod());

        // 헤더 셋팅
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 바디 셋팅
        HttpEntity<Object> reqEntity = new HttpEntity<>(body, headers);

        // 결과
        ResponseEntity resEntity = restTemplate.exchange(url, method, reqEntity, Object.class);
        return resEntity;
    }

    public ResponseEntity commonSend(String url, HttpMethod method, Object body) {
        RestTemplate restTemplate = new RestTemplate();

        // 헤더 셋팅
        HttpHeaders headers = new HttpHeaders();
        // headers.add("Content-Type", MediaType.APPLICATION_JSON_VALUE)
        headers.setContentType(MediaType.APPLICATION_JSON);

        // 바디 셋팅
        HttpEntity<Object> reqEntity = new HttpEntity<>(body, headers);

        // 결과
        ResponseEntity resEntity = restTemplate.exchange(url, method, reqEntity, Object.class);
        return resEntity;
    }

    private HttpServletRequest getUrl() {
        return (null == RequestContextHolder.getRequestAttributes()) ? null
                : ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

}
