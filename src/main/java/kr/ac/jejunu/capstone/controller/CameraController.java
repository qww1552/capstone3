package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.exception.CameraNotFoundException;
import kr.ac.jejunu.capstone.model.entity.Camera;
import kr.ac.jejunu.capstone.model.response.ApiResponse;
import kr.ac.jejunu.capstone.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.FileInputStream;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/cameras")
public class CameraController {
    @Autowired
    private final CameraRepository cameraRepository;

    @GetMapping("/{cameraId}")
    public ResponseEntity getCamera(@PathVariable Integer cameraId) {
        Camera camera = cameraRepository.findById(cameraId).orElseThrow(()->
                new CameraNotFoundException("카메라가 존재하지 않습니다."));
        return ApiResponse.getResponseEntity(camera);
    }

    @GetMapping(value = "/{cameraId}/image",produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getCameraImage(@PathVariable Integer cameraId) {
        Camera camera = cameraRepository.findById(cameraId).orElseThrow(()->
                new CameraNotFoundException("카메라가 존재하지 않습니다."));
        String imageUri = camera.getImageUri();
        byte[] bytes = null;
        try (FileInputStream fileInputStream = new FileInputStream(imageUri)){
            bytes = fileInputStream.readAllBytes();
        }catch (Exception e){}
        return bytes;
    }

}
