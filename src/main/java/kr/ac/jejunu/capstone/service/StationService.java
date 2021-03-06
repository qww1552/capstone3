package kr.ac.jejunu.capstone.service;

import kr.ac.jejunu.capstone.repository.StationRepository;
import kr.ac.jejunu.capstone.model.dto.receive.ReceivingSpotDto;
import kr.ac.jejunu.capstone.model.dto.send.StationDto;
import kr.ac.jejunu.capstone.model.entity.Station;
import kr.ac.jejunu.capstone.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;
    @Autowired
    public SpotService spotService;

    public List<StationDto> getAllStations() {
        List<Station> stations = stationRepository.findAll();
        List<StationDto> stationDtoList = new ArrayList<>();
        for (Station station : stations) {
            StationDto stationDto = new StationDto();
            stationDto.setId(station.getId());
            String imagePath = FileUtils.getImagePath("thumbnails", String.valueOf(station.getId()), "jpeg");
            stationDto.setThumbnail(imagePath);
            stationDto.setName(station.getName());
            stationDto.setLatitude(station.getLatitude());
            stationDto.setLongitude(station.getLongitude());

            Map<String, Integer> capacity = getCapacity(station.getId());
            stationDto.setOverallSpaces(capacity.get("overallSpaces"));
            stationDto.setVacancy(capacity.get("vacancy"));
            stationDtoList.add(stationDto);
        }
        return stationDtoList;
    }

    public Map<String, Integer> getCapacity(Integer stationId) {
        List<ReceivingSpotDto> spotsInStation = spotService.getSpotsInStation(stationId);
        int overallSpaces = 0;
        int vacancy = 0;
        for (ReceivingSpotDto receivingSpotDto : spotsInStation) {
            List<double[]> spot = receivingSpotDto.getSpot();
            overallSpaces += spot.size();
            if (!receivingSpotDto.getFull()) {
                vacancy++;
            }
        }
        Map result = new HashMap();
        result.put("overallSpaces", overallSpaces);
        result.put("vacancy", vacancy);

        return result;
    }

}
