package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.exception.StationNotFoundException;
import kr.ac.jejunu.capstone.model.dto.send.StationDetail;
import kr.ac.jejunu.capstone.model.dto.send.StationDto;
import kr.ac.jejunu.capstone.model.entity.Station;
import kr.ac.jejunu.capstone.model.response.ApiResponse;
import kr.ac.jejunu.capstone.repository.StationRepository;
import kr.ac.jejunu.capstone.service.SpotService;
import kr.ac.jejunu.capstone.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static kr.ac.jejunu.capstone.utils.FileUtils.getImagePath;

@RequiredArgsConstructor
@RestController
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private final StationService stationService;

    @Autowired
    private final StationRepository stationRepository;

    @Autowired
    private final SpotService spotService;

    @GetMapping("")
    public ResponseEntity getStationList() {

        List<StationDto> stations = stationService.getAllStations();
        return ApiResponse.getResponseEntity(stations);
    }

    @GetMapping("/{stationId}")
    public ResponseEntity getStation(@PathVariable Integer stationId) {
        Station station = stationRepository.findById(stationId)
                .orElseThrow(() -> new StationNotFoundException("주차장을 찾을 수 없습니다."));
        List spotsInStation = spotService.getSpotDetails(stationId);

        String backgroundImage = getImagePath("background", String.valueOf(stationId),"jpeg");

        StationDetail stationDetail = StationDetail.builder()
                .parkingLotName(station.getName())
                .vacancyNumber(stationService.getCapacity(stationId).get("vacancy"))
                .stationColumnNumber(station.getColumn())
                .stationRowNumber(station.getRow())
                .stationBG(backgroundImage)
                .slots(spotsInStation)
                .build();

        return ApiResponse.getResponseEntity(stationDetail);
    }

}
