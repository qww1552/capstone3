package kr.ac.jejunu.capstone.Repository;

import kr.ac.jejunu.capstone.model.station.camera.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends JpaRepository<Camera,Integer> {
}
