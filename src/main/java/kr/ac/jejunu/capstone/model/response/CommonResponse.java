package kr.ac.jejunu.capstone.model.response;

import lombok.Data;
@Data
public class CommonResponse<T> {
    // 클라이언트로 나가는 응답
    private Integer statusCode;
    private String message;
    private T data;

}
