package kr.ac.jejunu.capstone.model.dto.receive;

import kr.ac.jejunu.capstone.model.dto.send.SendingSpotDto;
import lombok.Data;

@Data
public class ReceivingSpace {
    private SendingSpotDto space;
    private Integer posX;
    private Integer posY;
}
