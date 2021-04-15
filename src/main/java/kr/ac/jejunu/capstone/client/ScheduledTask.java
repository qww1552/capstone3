package kr.ac.jejunu.capstone.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.capstone.Repository.CameraRepository;
import kr.ac.jejunu.capstone.Repository.SpotRepository;
import kr.ac.jejunu.capstone.Repository.StationRepository;
import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.entity.Camera;
import kr.ac.jejunu.capstone.model.entity.Spot;
import kr.ac.jejunu.capstone.model.entity.Station;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class ScheduledTask {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTask.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private BoardClient client;

    @Autowired
    private CameraRepository cameraRepository;
//    @Autowired
//    private SpaceRepository spaceRepository;
    @Autowired
    private SpotRepository spotRepository;
    @Autowired
    private StationRepository stationRepository;


    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        List<Station> stations = stationRepository.findAll();
        for (Station station: stations) {

            client.setBaseUrl(station.getUrl());
            Camera camera = null;
            try {
                camera = client.getCamera();
//            camera.setImage(client.getCameraImage()); // 이미지는 아직 구현 안함
            } catch (IOException e) {
                e.printStackTrace();
            }
            List<ReceivingSpotDto> receivedSpots = null;
            try {
                receivedSpots = client.getSpace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            cameraRepository.save(camera);

            for (ReceivingSpotDto received: receivedSpots) { // 보드에서 받아온 spot들을 entity에 매핑 후 db에 저장
                Spot spot = new Spot();
                spot.setSid(received.getSid());
                spot.setSpot(received.getSpot());
                spot.setFull(received.getFull());

                spot.setCamera(camera);
                spot.setStation(station);
                spotRepository.save(spot);
            }
        }

        log.info("Time : {}",dateFormat.format(new Date()));
    }
}
