package kr.ac.jejunu.capstone.Repository;

import kr.ac.jejunu.capstone.model.entity.space.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceRepository extends JpaRepository<Space, Integer> {
}
