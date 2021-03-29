package kr.ac.jejunu.capstone.model.response;

import kr.ac.jejunu.capstone.model.station.camera.Camera;
import lombok.Data;

import java.awt.*;

@Data
public class CameraResponse {
    private String status;
    private Camera camera;
    private Image image;
}
