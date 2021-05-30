package kr.ac.jejunu.capstone.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@SuppressWarnings("ALL")
@RequiredArgsConstructor
@Data
@Entity(name = "spot")
public class Spot {
    // 주차공간 1칸
    @Id
    private Integer sid;
    // 이차원 배열 표현해야함(좌표 4개)
    @ElementCollection
    private List<double[]> spot;

    @OneToOne
    private Station station;
    @OneToOne
    private Camera camera;

    private Boolean full;
}
