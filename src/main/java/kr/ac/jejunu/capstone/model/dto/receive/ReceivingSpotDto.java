package kr.ac.jejunu.capstone.model.dto.receive;

import lombok.Data;
import java.util.List;

@Data
public class ReceivingSpotDto {
    private Integer sid;
    // 이차원 배열 표현해야함(좌표 4개)

    private List<double[]> spot;

    private Boolean full;
}
