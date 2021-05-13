package kr.ac.jejunu.capstone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.capstone.client.BoardClient;
import kr.ac.jejunu.capstone.model.dto.send.SendingSpotDto;
import kr.ac.jejunu.capstone.model.entity.Spot;
import kr.ac.jejunu.capstone.repository.StationRepository;
import kr.ac.jejunu.capstone.model.entity.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/admin")
public class AdminPageController {
    @Autowired
    private final StationRepository stationRepository;
    @Autowired
    private final BoardClient boardClient;

    // findAll
    @GetMapping("/")
    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    // findOne
    @GetMapping("/{stationId}")
    public Optional<Station> getStation(@PathVariable Integer stationId) {
        return stationRepository.findById(stationId);
    }

    // create
    @PostMapping("/")
    public Station addStation(@ModelAttribute Station newStation) {
        return stationRepository.save(newStation);
    }

    // update
    @PutMapping("/{stationId}")
    public Station modifyStation(@PathVariable Integer stationId, @ModelAttribute Station update) {
        Station station = stationRepository.findById(stationId).get();
        if (update.getName() != null) station.setName(update.getName());
        if (update.getLatitude() != null) station.setLatitude(update.getLatitude());
        if (update.getLongitude() != null) station.setLongitude(update.getLongitude());
        return stationRepository.save(station);
    }

    // delete
    @DeleteMapping("/{stationId}")
    public void deleteStation(@PathVariable Integer stationId) {
        stationRepository.delete(stationRepository.findById(stationId).get());
    }

    // 좌표값 세팅
    @PostMapping("/{stationId}/{sid}")
    public ResponseEntity<String> setSid(@PathVariable Integer stationId, @PathVariable Integer sid, SendingSpotDto sendingSpotDto) {
        ResponseEntity<String> responseEntity = null;
        System.out.println(sendingSpotDto);
        Station station = stationRepository.findById(stationId).get();
        boardClient.setBaseUrl(station.getBoardAddress());
        try {
            responseEntity = boardClient.setSpace(sid, sendingSpotDto); // 보드에 등록만 하고
        } catch (JsonProcessingException e) {                           // 나중에 순회하면서 db에 저장
            e.printStackTrace();
        }
        return responseEntity;
    }
}
