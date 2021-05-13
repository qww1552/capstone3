package kr.ac.jejunu.capstone.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@Entity(name = "station")
public class Station {
    // url 필드가 있어야 할 듯
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private Double latitude;
    private Double longitude;
    private Double entranceX;
    private Double entranceY;
    private Integer width;
    private Integer height;

    private String boardAddress; //보드 주소
}
