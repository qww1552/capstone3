package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.Repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@RestController
@RequestMapping(value = "/parking/v1/cameras")
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

    @GetMapping(value = "/{cameraId}/image", produces = MediaType.IMAGE_JPEG_VALUE)
    public ByteArrayOutputStream getCameraImage() throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        String photoUrl = "https://images.unsplash.com/photo-1616663717839-2fea42e1a1f6?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=676&q=80";
        ByteArrayOutputStream cameraImage = restTemplate.getForObject(photoUrl, ByteArrayOutputStream.class);

        return cameraImage;
    }

}
