package kr.ac.jejunu.capstone.client;

import org.springframework.http.*;

import static kr.ac.jejunu.capstone.client.utils.ClientUtils.getResponse;

public class CameraClient {

    private String baseUrl="http://localhost:8081/api/v1/test";

    public ResponseEntity<String> getCamera() {
        String reqUrl = baseUrl + "/camera";
        return getResponse(reqUrl);
    }

    public ResponseEntity<String> getTest() {
        String reqUrl = baseUrl + "/permit-all";
        return getResponse(reqUrl);
    }

    public ResponseEntity<String> getCameraImage() {
        String reqUrl = baseUrl + "/image";
        ResponseEntity<String> responseEntity = getResponse(reqUrl);
        return responseEntity;
    }

}
