package kr.ac.jejunu.capstone.model.dto;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class StationDto {
    // 응답으로 받을 클래스

    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
}
