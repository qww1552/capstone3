package kr.ac.jejunu.capstone.model.dto.camera;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
public class CameraDto {
    // 응답으로 받을 클래스

    private Integer cid;
    private Byte[] image;

    public CameraDto(Integer cid) {
        this.cid = cid;
    }
}
