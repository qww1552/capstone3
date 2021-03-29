package kr.ac.jejunu.capstone.Repository;

import kr.ac.jejunu.capstone.model.station.camera.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera,Integer> {
}
