package kr.ac.jejunu.capstone.client.utils;

import kr.ac.jejunu.capstone.model.dto.space.SpaceDto;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
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

    public static ResponseEntity<String> postResponseForSpace(String reqUrl, SpaceDto spaceDto) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", Charset.forName("UTF-8")));
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("space", String.valueOf(spaceDto));
        HttpEntity<MultiValueMap<String,String>> request = new HttpEntity<>(params,headers);

        ResponseEntity<String> responseEntity = restTemplate.exchange(reqUrl, HttpMethod.POST, request, String.class);
        return responseEntity;
    }
}
