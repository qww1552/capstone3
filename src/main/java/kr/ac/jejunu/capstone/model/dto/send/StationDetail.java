package kr.ac.jejunu.capstone.model.dto.send;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StationDetail {
    // 프론트엔드로 전송
    private String parkingLotName;
    private Integer vacancyNumber;
    private Integer stationColumnNumber;
    private Integer stationRowNumber;
    private String stationBG;
    private List slots;
}
