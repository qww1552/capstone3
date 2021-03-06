package kr.ac.jejunu.capstone.model.dto.send;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class SendingSpotDto {
    // 보드에 보내는 객
    // 주차공간 1칸

    private Integer sid;
    // 이차원 배열 표현해야함(좌표 4개)
    private List<double[]> spot;
}
