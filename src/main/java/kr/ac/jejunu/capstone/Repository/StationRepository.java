package kr.ac.jejunu.capstone.Repository;

import kr.ac.jejunu.capstone.model.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station,Integer> {
    Station findByName(String name);
}
