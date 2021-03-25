package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.Repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/parking/v1/camera")
public class CameraController {
    @Autowired
    private CameraRepository cameraRepository;

    @GetMapping("/{cameraId}")
    public String getCamera(@PathVariable Integer cameraId) {
        RestTemplate restTemplate = new RestTemplate();
        String body = restTemplate.getForObject("http://localhost:8081/api/v1/test/permit-all", String.class);
        System.out.println(body);
        return body;
    }

    @GetMapping("/cameraId")
    public String getCameraImage() {

        return null;
    }

}
