package kr.ac.jejunu.capstone.repository;

import kr.ac.jejunu.capstone.model.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Camera,Integer> {
}
