package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.capstone.Repository.CameraRepository;
import kr.ac.jejunu.capstone.Repository.SpaceRepository;
import kr.ac.jejunu.capstone.Repository.SpotRepository;
import kr.ac.jejunu.capstone.model.dto.space.SpaceDto;
import kr.ac.jejunu.capstone.model.entity.Camera;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private BoardClient client;

    @Autowired
    private CameraRepository cameraRepository;
    @Autowired
    private SpaceRepository spaceRepository;
    @Autowired
    private SpotRepository spotRepository;

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        Camera camera = null;
        try {
            camera = client.getCamera();
//            camera.setImage(client.getCameraImage());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        List<Spot> spots = space.getSpots();
//        spotRepository.saveAll(spots);
//        System.out.println(spots);
//        cameraRepository.save(camera);
        System.out.println(camera);
//        spaceRepository.save(space);
        log.info("The time is now {}",dateFormat.format(new Date()));
    }
}
