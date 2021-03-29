package kr.ac.jejunu.capstone.client.utils;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

public class ClientUtils {
    public static ResponseEntity<String> getResponse(String reqUrl) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.GET, new HttpEntity<String>(headers), String.class);
        return responseEntity;
    }

    public static ResponseEntity<String> postResponse(String reqUrl) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.POST, new HttpEntity<String>(headers), String.class);
        return responseEntity;
    }
}
