package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.Repository.StationRepository;
import kr.ac.jejunu.capstone.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/stations")
public class StationController {
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
    public void deleteStataion(@PathVariable Integer stationId) {
        stationRepository.delete(stationRepository.findById(stationId).get());
    }
}
