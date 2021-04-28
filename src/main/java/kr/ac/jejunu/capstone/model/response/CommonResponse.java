package kr.ac.jejunu.capstone.model.response;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.nio.charset.Charset;

@Data
public class CommonResponse<T> {
    // 클라이언트로 나가는 응답
    private Integer statusCode;
    private String message;
    private T data;

    public static ResponseEntity getResponseEntity(Object object) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setStatusCode(200);
        commonResponse.setMessage("success");
        commonResponse.setData(object);
        return new ResponseEntity(commonResponse, headers, HttpStatus.OK);
    }
}
