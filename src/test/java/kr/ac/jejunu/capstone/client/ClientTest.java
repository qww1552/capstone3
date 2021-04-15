package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.capstone.model.dto.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.entity.Camera;
import kr.ac.jejunu.capstone.model.entity.Spot;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public class ClientTest {
    @Test
    public void cameraTest() throws IOException {
        BoardClient client = new BoardClient();
        Camera camera = client.getCamera();
        System.out.println(camera);
    }

    @Test
    public void spaceTest() throws JsonProcessingException {
        BoardClient client = new BoardClient();
        List<ReceivingSpotDto> space = client.getSpace();
        System.out.println("space : "+space);
    }

    @Test
    public void spotTest() throws JsonProcessingException {
        BoardClient client = new BoardClient();
        Spot spot = client.getSpot(430781);
        System.out.println(spot);
    }

    @Test
    public void setSpaceTest() throws JsonProcessingException {
        BoardClient client = new BoardClient();
        ResponseEntity<String> responseEntity = client.setSpace(430783);
        System.out.println(responseEntity.getBody());
    }

}
