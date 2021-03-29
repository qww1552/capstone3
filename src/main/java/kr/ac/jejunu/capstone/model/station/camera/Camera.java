package kr.ac.jejunu.capstone.model.station.camera;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "camera")
public class Camera {
    @Id
    private Integer cid;
}
