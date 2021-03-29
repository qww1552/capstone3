package kr.ac.jejunu.capstone.model.response;

import lombok.Data;

@Data
public class CommonResponse<T> {
//    private Integer statusCode;
    private String status;
    private T result;
}
