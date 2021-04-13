package kr.ac.jejunu.capstone.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "camera")
@NoArgsConstructor
public class Camera {
    @Id
    @Column(name = "cid")
    private Integer cid;
    private Byte[] image;

    public Camera(Integer cid) {
        this.cid = cid;
    }
}
