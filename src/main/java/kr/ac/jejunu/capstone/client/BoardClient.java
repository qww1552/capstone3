package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.capstone.client.utils.ClientUtils;
import kr.ac.jejunu.capstone.model.dto.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.dto.SendingSpotDto;
import kr.ac.jejunu.capstone.model.response.received.CameraResponse;
import kr.ac.jejunu.capstone.model.response.received.SpaceResponse;
import kr.ac.jejunu.capstone.model.response.received.SpotResponse;
import kr.ac.jejunu.capstone.model.entity.Camera;
import kr.ac.jejunu.capstone.model.entity.Spot;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static kr.ac.jejunu.capstone.client.utils.ClientUtils.getResponse;
@Component
public class BoardClient {

//    private String baseUrl;
    private String baseUrl = "http://localhost:8082/parking/v1";
//    private String baseUrl = "http://125.178.149.31:21152/parking/v1";

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
    public List<ReceivingSpotDto> getSpace() throws JsonProcessingException {
        String resUrl = baseUrl + "/spaces";
        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);

        String body = responseEntity.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        SpaceResponse spaceResponse = objectMapper.readValue(body, SpaceResponse.class);
        return spaceResponse.getSpace();
    }


    // 스페이스 추가 -수정필요
    public ResponseEntity<String> setSpace(Integer sid) throws JsonProcessingException {
        String reqUrl = baseUrl + "/spaces/" + sid;
        SendingSpotDto sendingSpotDto = new SendingSpotDto();
        sendingSpotDto.setSid(sid);

        ArrayList list = new ArrayList<double[]>();
        list.add(new double[] {0.21253672869735563,-0.15404699738903394});
        list.add(new double[] {0.28697355533790403,0.39164490861618795});
        list.add(new double[] {0.7688540646425073,0.39947780678851186});
        list.add(new double[] {0.5651322233104799,-0.13315926892950392});

        sendingSpotDto.setSpot(list);

        List spots = new ArrayList<SendingSpotDto>();
        spots.add(sendingSpotDto);

        ResponseEntity<String> responseEntity =
                ClientUtils.postResponseForSpace(reqUrl,"space", sendingSpotDto);
        return responseEntity;
    }

    // 주차공간 하나 받아오기
    public Spot getSpot(Integer sid) throws JsonProcessingException {
        String resUrl = baseUrl + "/spaces/" + sid;
        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        SpotResponse response = objectMapper.readValue(responseEntity.getBody(), SpotResponse.class);
        return response.getSpot();
    }
}
