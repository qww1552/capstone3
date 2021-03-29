package kr.ac.jejunu.capstone.model.station.space;

import lombok.AllArgsConstructor;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity(name = "space")
@AllArgsConstructor
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer spaceId;
    private List<Spot> spots;
    private Integer full;
}

