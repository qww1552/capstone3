package kr.ac.jejunu.capstone.model.response.client;

import kr.ac.jejunu.capstone.model.dto.space.SpaceDto;
import lombok.*;

@Data
public class SpaceResponse {
    // 보드에 요청 시 들어오는 응답

    private String status;
    private SpaceDto space;

}
