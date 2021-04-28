package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.dto.send.StationDto;
import kr.ac.jejunu.capstone.model.response.CommonResponse;
import kr.ac.jejunu.capstone.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("")
    public ResponseEntity<CommonResponse> getStationList() {
        List<StationDto> stations = stationService.getAllNameAndId();
        return CommonResponse.getResponseEntity(stations);
    }

    @GetMapping("/{stationId}")
    public ResponseEntity getSpots(@PathVariable Integer stationId) {
        List<ReceivingSpotDto> spotsInStation = stationService.getSpotsInStation(stationId);
        return CommonResponse.getResponseEntity(spotsInStation);
    }
}
