package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/cameras")
public class CameraController {
    @Autowired
    private CameraRepository cameraRepository;

    @GetMapping("/{cameraId}")
    public String getCamera(@PathVariable Integer cameraId) {

        return null;
    }

    @GetMapping("/cameraId")
    public String getCameraImage() {

        return null;
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
