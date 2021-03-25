package kr.ac.jejunu.capstone.model.response;

import kr.ac.jejunu.capstone.model.Camera;
import lombok.Data;

import java.awt.*;

@Data
public class CameraResponse {
    private boolean status;
    private Camera camera;
    private Image image;
}
