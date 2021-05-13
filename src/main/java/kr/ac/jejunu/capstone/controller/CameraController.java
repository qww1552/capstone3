package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.model.entity.Camera;
import kr.ac.jejunu.capstone.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.io.FileInputStream;

@RestController
@RequestMapping(value = "/cameras")
public class CameraController {
    @Autowired
    private CameraRepository cameraRepository;

    @GetMapping("/{cameraId}")
    public String getCamera(@PathVariable Integer cameraId) {

        return null;
    }

    @GetMapping(value = "/{cameraId}/image",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getCameraImage(@PathVariable Integer cameraId) {
        Camera camera = cameraRepository.findById(cameraId).get();
        String imageUri = camera.getImageUri();
        byte[] bytes = null;
        try (FileInputStream fileInputStream = new FileInputStream(imageUri)){
            bytes = fileInputStream.readAllBytes();
        }catch (Exception e){}
        return bytes;
    }

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }
}
