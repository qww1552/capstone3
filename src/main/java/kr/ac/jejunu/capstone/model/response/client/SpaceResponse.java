package kr.ac.jejunu.capstone.model.response.client;

import kr.ac.jejunu.capstone.model.dto.space.SpaceDto;
import kr.ac.jejunu.capstone.model.entity.Spot;
import lombok.*;

import java.util.List;

@Data
public class SpaceResponse {
    // 보드에 요청 시 들어오는 응답

    private String status;
    private List<Spot> space;

}
