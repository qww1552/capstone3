package kr.ac.jejunu.capstone.model.response.received;

import kr.ac.jejunu.capstone.model.dto.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.entity.Spot;
import lombok.*;

import java.util.List;

@Data
public class SpaceResponse {
    // 보드에 요청 시 들어오는 응답

    private String status;
    private List<ReceivingSpotDto> space;

}
