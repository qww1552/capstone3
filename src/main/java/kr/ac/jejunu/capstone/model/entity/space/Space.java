package kr.ac.jejunu.capstone.model.entity.space;

import kr.ac.jejunu.capstone.model.entity.Spot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "space")
@AllArgsConstructor
@NoArgsConstructor
public class Space {
    // 카메라에 보이는 영역, 주차공간 4칸
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spaceId;

    @OneToMany(targetEntity = Spot.class,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Spot> spots;
}

