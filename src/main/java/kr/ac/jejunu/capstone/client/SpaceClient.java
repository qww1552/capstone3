package kr.ac.jejunu.capstone.client;

import kr.ac.jejunu.capstone.client.utils.ClientUtils;
import org.springframework.http.ResponseEntity;

public class SpaceClient {
    private String baseUrl = "http://localhost:8081/api/v1/test";
    public ResponseEntity<String> getSpace() {
        String resUrl = baseUrl + "/spaces";
        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);
        return responseEntity;
    }
//수정필요
    public ResponseEntity<String> setSpace() {
        return null;
    }
//
    public ResponseEntity<String> getSpot(Integer sid) {
        String resUrl = baseUrl + "/spaces/"+sid;
        return ClientUtils.getResponse(resUrl);
    }
}
