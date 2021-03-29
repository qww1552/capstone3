package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kr.ac.jejunu.capstone.client.utils.ClientUtils;
import kr.ac.jejunu.capstone.model.response.SpaceResponse;
import kr.ac.jejunu.capstone.model.station.space.Space;
import org.springframework.http.ResponseEntity;

public class SpaceClient {
    private String baseUrl = "http://localhost:8082/parking/v1/";

    public Space getSpace() throws JsonProcessingException {
        String resUrl = baseUrl + "/spaces";
        ResponseEntity<String> responseEntity = ClientUtils.getResponse(resUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(responseEntity);
        SpaceResponse response = objectMapper.readValue(responseEntity.getBody(), SpaceResponse.class);

        return response.getSpace();
    }

    //수정필요
    public ResponseEntity<String> setSpace() {
        return null;
    }

    //
    public ResponseEntity<String> getSpot(Integer sid) {
        String resUrl = baseUrl + "/spaces/" + sid;
        return ClientUtils.getResponse(resUrl);
    }
}
