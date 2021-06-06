package kr.ac.jejunu.capstone.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kr.ac.jejunu.capstone.client.BoardClient;
import kr.ac.jejunu.capstone.exception.SpotNotFoundException;
import kr.ac.jejunu.capstone.exception.StationNotFoundException;
import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpace;
import kr.ac.jejunu.capstone.model.dto.send.SendingSpotDto;
import kr.ac.jejunu.capstone.model.entity.Spot;
import kr.ac.jejunu.capstone.model.response.ApiResponse;
import kr.ac.jejunu.capstone.repository.SpotRepository;
import kr.ac.jejunu.capstone.repository.StationRepository;
import kr.ac.jejunu.capstone.model.entity.Station;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    private final SpotRepository spotRepository;
    @Autowired
    private final BoardClient boardClient;

    // findAll
    @GetMapping("")
    public ResponseEntity getAllStations() {
        List<Station> stations = stationRepository.findAll();
        return ApiResponse.getResponseEntity(stations);
    }

    // findOne
    @GetMapping("/{stationId}")
    public ResponseEntity getStation(@PathVariable Integer stationId) {
        Station station = stationRepository.findById(stationId).orElseThrow(()->
                new StationNotFoundException("주차장이 존재하지 않습니다."));
        return ApiResponse.getResponseEntity(station);
    }

    // create
    @PostMapping("")
    public Station addStation(@RequestBody Map<String,String> newStation) {
        System.out.println(newStation);
        Station station = Station.builder()
                .name(newStation.get("name"))
                .latitude(Double.valueOf(newStation.get("latitude")))
                .longitude(Double.valueOf(newStation.get("longitude")))
                .locationDesc(newStation.get("locationDesc"))
                .row(Integer.valueOf(newStation.get("row")))
                .column(Integer.valueOf(newStation.get("column")))
                .boardAddress(newStation.get("boardAddress"))
                .build();
        System.out.println(station);
        return stationRepository.save(station);
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
    public ResponseEntity<String> setSid(@PathVariable Integer stationId,
                                         @PathVariable Integer sid,
                                         @RequestBody ReceivingSpace receivingSpace) {
        System.out.println(receivingSpace);
        SendingSpotDto sendingSpotDto = receivingSpace.getSpace();
        Station station = stationRepository.findById(stationId).orElseThrow(()->
                new StationNotFoundException("주차장을 찾을 수 없습니다."));
        Spot spot = spotRepository.findById(sid).orElseThrow(()->new SpotNotFoundException("주차공간이 없습니다."));
        spot.setPosX(receivingSpace.getPosX());
        spot.setPosY(receivingSpace.getPosY());
        spotRepository.save(spot);
        boardClient.setBaseUrl(station.getBoardAddress());
        try {
            boardClient.setSpace(sid, sendingSpotDto); // 보드에 등록만 하고 나중에 순회하면서 db에 저장
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return ApiResponse.getResponseEntity(sendingSpotDto);
    }

}
