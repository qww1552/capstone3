package kr.ac.jejunu.capstone.model.entity;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

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
    // 이미지 위에 표시 할 꼭짓점 4개
    @ElementCollection
    private List<double[]> spot;

    @OneToOne
    private Station station;
    @OneToOne
    private Camera camera;

    // 주차장 내 좌표
    private Integer posX;
    private Integer posY;

    private Boolean full;
}
