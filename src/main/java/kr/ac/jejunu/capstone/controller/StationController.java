package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.Repository.StationRepository;
import kr.ac.jejunu.capstone.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/stations")
public class StationController {
    @Autowired
    private StationRepository stationRepository;

    @GetMapping("/{stationId}")
    public Optional<Station> getStation(@PathVariable Integer stationId) {
        return stationRepository.findById(stationId);
    }

    @PostMapping("/")
    public Station addStation(@ModelAttribute Station station) {
        return stationRepository.save(station);
    }

    @PutMapping("/{stationId}")
    public Station modifyStation(@PathVariable Integer stationId, @ModelAttribute Station update) {
        Station station = stationRepository.findById(stationId).get();
        if (update.getName() != null) station.setName(update.getName());
        if (update.getX() != null) station.setX(update.getX());
        if (update.getY() != null) station.setY(update.getY());
        return stationRepository.save(station);
    }

    @DeleteMapping("/{stationId}")
    public void deleteStataion(@PathVariable Integer stationId) {
        stationRepository.delete(stationRepository.findById(stationId).get());
    }
}
