package kr.ac.jejunu.capstone.model.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "station")
public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double latitude;
    private Double longitude;
    private String locationDesc;
    @Column(name = "\"row\"")
    private Integer row;
    @Column(name = "\"column\"")
    private Integer column;

    private String boardAddress; //보드 주소
}
