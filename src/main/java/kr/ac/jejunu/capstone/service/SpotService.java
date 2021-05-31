package kr.ac.jejunu.capstone.service;

import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.entity.Spot;
import kr.ac.jejunu.capstone.repository.SpotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SpotService {
    @Autowired
    private final SpotRepository spotRepository;
    public List<ReceivingSpotDto> getSpotsInStation(Integer stationId) {
        List<Spot> spots = spotRepository.findAllByStationId(stationId);
        List<ReceivingSpotDto> spotDtoList = new ArrayList<>();
        for (Spot spot: spots) {
            ReceivingSpotDto spotDto = new ReceivingSpotDto();
            spotDto.setSid(spot.getSid());
            spotDto.setSpot(spot.getSpot());
            spotDto.setFull(spot.getFull());

            spotDtoList.add(spotDto);
        }
        return spotDtoList;
    }
}
