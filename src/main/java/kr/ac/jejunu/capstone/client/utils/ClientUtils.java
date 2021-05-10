package kr.ac.jejunu.capstone.client.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class ClientUtils {
    public static ResponseEntity<String> getResponse(String reqUrl) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json",
                Charset.forName("UTF-8")));
        ResponseEntity<String> responseEntity =
                restTemplate.exchange(reqUrl, HttpMethod.GET,
                        new HttpEntity<String>(headers), String.class);
        return responseEntity;
    }

    public static ResponseEntity<String> postResponseForSpace(String reqUrl, String attributeName, Object object) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        HttpEntity<String> request;
        ResponseEntity<String> responseEntity;
        headers.setContentType(
                new MediaType("application","json", Charset.forName("UTF-8"))
        );

        map.put(attributeName,object);
        String json = mapper.writeValueAsString(map);

        request = new HttpEntity<>(json,headers);

        responseEntity = restTemplate.exchange(reqUrl, HttpMethod.POST, request, String.class);
        return responseEntity;
    }
}
