package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.capstone.model.response.CameraResponse;
import kr.ac.jejunu.capstone.model.station.camera.Camera;
import org.apache.commons.io.IOUtils;
import org.springframework.http.*;

import java.io.IOException;

import static kr.ac.jejunu.capstone.client.utils.ClientUtils.getResponse;

public class CameraClient {
    private String baseUrl = "http://localhost:8082/parking/v1";

    // 이미지가 널인 카메라 반
    public Camera getCamera() throws IOException {
        String reqUrl = baseUrl + "/camera";
        ResponseEntity<String> responseEntity = getResponse(reqUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        CameraResponse response = objectMapper.readValue(responseEntity.getBody(), CameraResponse.class);
        return response.getCamera();
    }

    // 이미지를 바이트배열로 반환
    public byte[] getCameraImage() throws IOException {
        String reqUrl = baseUrl + "/image";
        ResponseEntity<String> responseEntity = getResponse(reqUrl);

        return IOUtils.toByteArray(String.valueOf(responseEntity));
    }

}
