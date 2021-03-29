package kr.ac.jejunu.capstone.model.station.space;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@SuppressWarnings("ALL")
@Data
@Entity
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;
    // 이차원 배열 표현해야함(좌표 4개)
    private List<double[]> spot;
    private Boolean full;


}
