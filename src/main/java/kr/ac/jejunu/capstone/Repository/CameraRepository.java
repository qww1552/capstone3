package kr.ac.jejunu.capstone.Repository;

import kr.ac.jejunu.capstone.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera,Integer> {
}
