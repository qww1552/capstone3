package kr.ac.jejunu.capstone.model.dto.send;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
public class StationDto {

    private Integer id;
    private String thumbnail;
    private String name;
    private String locationDesc;
    private Double latitude;
    private Double longitude;
    private Integer overallSpaces;
    private Integer vacancy;
}
