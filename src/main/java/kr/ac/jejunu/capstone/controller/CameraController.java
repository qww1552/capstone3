package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.Repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
