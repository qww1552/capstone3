package kr.ac.jejunu.capstone.model.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.nio.charset.Charset;

@Getter
@Setter
public class ApiResponse<T> {
    // 클라이언트로 나가는 응답
    private Integer statusCode;
    private String message;
    private T data;

    public static ResponseEntity getResponseEntity(Object object) {
        HttpHeaders headers = getHttpHeaders();
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setStatusCode(200);
        apiResponse.setMessage("success");
        apiResponse.setData(object);
        return new ResponseEntity(apiResponse, headers, HttpStatus.OK);
    }

    private static HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        return headers;
    }
}
