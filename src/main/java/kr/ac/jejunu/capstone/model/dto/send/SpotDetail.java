package kr.ac.jejunu.capstone.model.dto.send;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpotDetail {
    private Integer slotID;
    private String photo;
    private Integer posX;
    private Integer posY;
    private Boolean isEmpty;
    private String slotType;
}
