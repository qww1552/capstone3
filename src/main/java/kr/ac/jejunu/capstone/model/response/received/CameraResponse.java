package kr.ac.jejunu.capstone.model.response.received;

import kr.ac.jejunu.capstone.model.entity.Camera;
import lombok.Data;

import java.awt.*;
@Data
public class CameraResponse {
    // 보드에 요청 시 들어오는 응답

    private String status;
    private Camera camera;
    private Image image;
}
