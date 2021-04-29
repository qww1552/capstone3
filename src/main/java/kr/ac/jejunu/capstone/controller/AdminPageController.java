package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.Repository.StationRepository;
import kr.ac.jejunu.capstone.model.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// rest 말고 페이지 만들어서 리턴
@RestController
@RequestMapping(value = "/admin")
public class AdminPageController {
    @Autowired
    private StationRepository stationRepository;

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
    public Station addStation(@ModelAttribute Station station) {
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
}
