package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.capstone.client.utils.ClientUtils;
import kr.ac.jejunu.capstone.model.response.client.CameraResponse;
import kr.ac.jejunu.capstone.model.response.client.SpaceResponse;
import kr.ac.jejunu.capstone.model.response.client.SpotResponse;
import kr.ac.jejunu.capstone.model.station.camera.Camera;
import kr.ac.jejunu.capstone.model.station.space.Space;
import kr.ac.jejunu.capstone.model.station.space.Spot;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static kr.ac.jejunu.capstone.client.utils.ClientUtils.getResponse;
@Component
public class BoardClient {

    private String baseUrl = "http://localhost:8082/parking/v1";

    public String getBaseUrl() {
        return baseUrl.toString();
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    // 이미지가 널인 카메라 반환
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

    // 카메라가 바라보는 영역
    public Space getSpace() throws JsonProcessingException {
        String resUrl = baseUrl + "/spaces";
        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        SpaceResponse response = objectMapper.readValue(responseEntity.getBody(), SpaceResponse.class);
        return response.getSpace();
    }

    // 스페이스 추가 -수정필요
    public ResponseEntity<String> setSpace() {
        return null;
    }

    // 주자공간 하나 받아오기
    public Spot getSpot(Integer sid) throws JsonProcessingException {
        String resUrl = baseUrl + "/spaces/" + sid;
        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        SpotResponse response = objectMapper.readValue(responseEntity.getBody(), SpotResponse.class);
        return response.getSpot();
    }
}
