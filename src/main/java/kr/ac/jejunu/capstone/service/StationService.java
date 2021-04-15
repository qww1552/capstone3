package kr.ac.jejunu.capstone.service;

import kr.ac.jejunu.capstone.Repository.SpotRepository;
import kr.ac.jejunu.capstone.Repository.StationRepository;
import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.dto.send.StationDto;
import kr.ac.jejunu.capstone.model.entity.Spot;
import kr.ac.jejunu.capstone.model.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    private SpotRepository spotRepository;

    public List<StationDto> getAllNameAndId() {
        List<Station> stations = stationRepository.findAll();
        List<StationDto> nameAndIdList = new ArrayList<>();
        for (Station station : stations) {
            StationDto stationDto = new StationDto();
            stationDto.setId(station.getId());
            stationDto.setName(station.getName());
            stationDto.setLatitude(station.getLatitude());
            stationDto.setLongitude(station.getLongitude());

            nameAndIdList.add(stationDto);
        }
        return nameAndIdList;
    }

    public List<ReceivingSpotDto> getSpotsInStation(Integer stationId) {
        List<Spot> spots = spotRepository.findAllByStationId(stationId);
        List<ReceivingSpotDto> resultList = new ArrayList<>();
        for (Spot spot: spots) {
            ReceivingSpotDto spotDto = new ReceivingSpotDto();
            spotDto.setSid(spot.getSid());
            spotDto.setSpot(spot.getSpot());
            spotDto.setFull(spot.getFull());

            resultList.add(spotDto);
        }
        return resultList;
    }
}
