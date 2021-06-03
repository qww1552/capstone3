package kr.ac.jejunu.capstone.repository;

import kr.ac.jejunu.capstone.model.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SpotRepository extends JpaRepository<Spot,Integer> {
    List<Spot> findAllByStationId(Integer stationId);


}
