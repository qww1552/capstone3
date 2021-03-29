package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.capstone.model.station.camera.Camera;
import kr.ac.jejunu.capstone.model.station.space.Space;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ClientTest {
    @Test
    public void camera() throws IOException {
        CameraClient client = new CameraClient();
        Camera camera = client.getCamera();
        System.out.println(camera);
    }

    @Test
    public void test() throws JsonProcessingException {
        SpaceClient client = new SpaceClient();
        Space space = client.getSpace();
        System.out.println(space);
    }
}
