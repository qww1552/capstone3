package kr.ac.jejunu.capstone.model.station.camera;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "camera")
@NoArgsConstructor
public class Camera {
    @Id
    private Integer cid;
    private Byte[] image;
    public Camera(Integer cid) {
        this.cid = cid;
    }
}