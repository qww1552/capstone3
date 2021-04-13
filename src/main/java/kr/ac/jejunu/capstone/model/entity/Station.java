package kr.ac.jejunu.capstone.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
    private Double entranceX;
    private Double entranceY;
    private Integer width;
    private Integer height;
}
