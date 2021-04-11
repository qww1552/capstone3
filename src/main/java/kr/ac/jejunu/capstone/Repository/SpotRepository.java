package kr.ac.jejunu.capstone.Repository;

import kr.ac.jejunu.capstone.model.entity.space.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot,Integer> {
}
