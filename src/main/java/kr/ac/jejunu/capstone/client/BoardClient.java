package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.capstone.client.utils.ClientUtils;
import kr.ac.jejunu.capstone.client.utils.FileUtils;
import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.dto.send.SendingSpotDto;
import kr.ac.jejunu.capstone.model.response.received.CameraResponse;
import kr.ac.jejunu.capstone.model.response.received.SpaceResponse;
import kr.ac.jejunu.capstone.model.response.received.SpotResponse;
import kr.ac.jejunu.capstone.model.entity.Camera;
import kr.ac.jejunu.capstone.model.entity.Spot;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static kr.ac.jejunu.capstone.client.utils.ClientUtils.getResponse;

@Component
public class BoardClient {

    //    private String baseUrl = "http://localhost:8082/parking/v1";
    private String baseUrl = "http://125.178.149.31:21152/parking/v1";

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

    // 카메라가 바라보는 영역

    public List<ReceivingSpotDto> getSpace() throws JsonProcessingException {
        String resUrl = baseUrl + "/spaces";

        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        SpaceResponse spaceResponse = objectMapper.readValue(responseEntity.getBody(), SpaceResponse.class);
        return spaceResponse.getSpace();
    }

    // 주차공간 하나 받아오기
    public Spot getSpot(Integer sid) throws JsonProcessingException {
        String resUrl = baseUrl + "/spaces/" + sid;

        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        SpotResponse response = objectMapper.readValue(responseEntity.getBody(), SpotResponse.class);
        return response.getSpot();
    }

    // 스페이스 추가 -수정필요
    public ResponseEntity<String> setSpace(Integer sid, SendingSpotDto sendingSpotDto) throws JsonProcessingException {
        String reqUrl = baseUrl + "/spaces/" + sid;

        ResponseEntity<String> responseEntity =
                ClientUtils.postResponseForSpace(reqUrl, "space", sendingSpotDto);
        return responseEntity;
    }

    public String getCameraImageUri(Integer cid) throws IOException {
        String reqUrl = baseUrl + "/camera/image";

        RestTemplate restTemplate = new RestTemplate();
        byte[] imageBytes = restTemplate.getForObject(reqUrl, byte[].class);

        File cameraImageFile = FileUtils.getFile("camera_img", String.valueOf(cid));
        FileUtils.writeImageToFile(imageBytes, cameraImageFile);
        return "/images/camera_img/" + cid + ".jpeg";
    }

}
