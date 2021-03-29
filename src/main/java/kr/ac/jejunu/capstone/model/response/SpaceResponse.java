package kr.ac.jejunu.capstone.model.response;

import kr.ac.jejunu.capstone.model.station.space.Space;
import lombok.Data;

@Data
public class SpaceResponse {
    private String status;
    private Space space;
}
