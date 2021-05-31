package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.dto.send.StationDto;
import kr.ac.jejunu.capstone.model.response.ApiResponse;
import kr.ac.jejunu.capstone.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(value = "*",methods = {RequestMethod.GET,RequestMethod.POST})
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("")
    public ResponseEntity<ApiResponse> getStationList() throws IOException {
        List<StationDto> stations = stationService.getAllStations();
        return ApiResponse.getResponseEntity(stations);
    }

    @GetMapping("/{stationId}")
    public ResponseEntity getSpots(@PathVariable Integer stationId) {
        List<ReceivingSpotDto> spotsInStation = stationService.spotService.getSpotsInStation(stationId);
        return ApiResponse.getResponseEntity(spotsInStation);
    }
}
