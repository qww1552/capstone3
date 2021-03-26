package kr.ac.jejunu.capstone.client;

import kr.ac.jejunu.capstone.Repository.CameraRepository;
import kr.ac.jejunu.capstone.model.Camera;
import org.springframework.beans.factory.annotation.Autowired;

public class CameraClient {
    @Autowired
    private CameraRepository cameraRepository;
    private String baseUrl;
    public String getCamera() {
        String reqUrl = baseUrl + "/parking/v1/camera";
        Camera camera = cameraRepository.getOne()
        return null;
    }

    public String getCameraImage() {
        return null;
    }
}
