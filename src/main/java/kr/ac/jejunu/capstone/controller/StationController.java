package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.dto.send.StationDto;
import kr.ac.jejunu.capstone.model.response.CommonResponse;
import kr.ac.jejunu.capstone.service.StationService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/stations")
public class StationController {
    @Autowired
    private StationService stationService;

    @GetMapping("")
    public ResponseEntity<CommonResponse> getStationList() {
        List<StationDto> stations = stationService.getAllNameAndId();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));

        CommonResponse<List<StationDto>> commonResponse =
                new CommonResponse<>();
        commonResponse.setStatusCode(200);
        commonResponse.setData(stations);
        commonResponse.setMessage("success");
        System.out.println(commonResponse);
        return new ResponseEntity<>(commonResponse,headers, HttpStatus.OK);
    }

    @GetMapping("/{stationId}")
    public ResponseEntity getSpots(@PathVariable Integer stationId) {
        List<ReceivingSpotDto> spotsInStation = stationService.getSpotsInStation(stationId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setMessage("success");
        commonResponse.setStatusCode(200);
        commonResponse.setData(spotsInStation);
        return new ResponseEntity(spotsInStation, headers, HttpStatus.OK);
    }
}
