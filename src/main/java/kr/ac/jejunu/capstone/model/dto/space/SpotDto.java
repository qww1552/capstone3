package kr.ac.jejunu.capstone.model.dto.space;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SpotDto {
    // 응답으로 받을 클래스
    // 주차공간 1칸

    private Integer sid;
    // 이차원 배열 표현해야함(좌표 4개)
    @ElementCollection
    private List<double[]> spot;

//    private Boolean full;
}
