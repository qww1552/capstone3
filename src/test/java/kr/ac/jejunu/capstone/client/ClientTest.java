package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.capstone.model.station.camera.Camera;
import kr.ac.jejunu.capstone.model.station.space.Space;
import kr.ac.jejunu.capstone.model.station.space.Spot;
import org.junit.jupiter.api.Test;

import java.io.IOException;

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
        Space space = client.getSpace();
        System.out.println("space : "+space);
    }

    @Test
    public void spotTest() throws JsonProcessingException {
        BoardClient client = new BoardClient();
        Spot spot = client.getSpot(430787);
        System.out.println(spot);
    }

}
