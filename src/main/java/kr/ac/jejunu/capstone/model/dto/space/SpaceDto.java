package kr.ac.jejunu.capstone.model.dto.space;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SpaceDto {
    // 응답으로 받을 클래스
    // 카메라에 보이는 영역, 주차공간 4칸

    private List<SpotDto> spots;
}

