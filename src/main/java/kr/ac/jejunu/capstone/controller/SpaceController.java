package kr.ac.jejunu.capstone.controller;

import kr.ac.jejunu.capstone.Repository.SpotRepository;
import kr.ac.jejunu.capstone.model.entity.Spot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking/v1/spaces")
public class SpaceController {

    @Autowired
    private SpotRepository spotRepository;

    @GetMapping("/test")
    public List<Spot> test(){
        List<Spot> spot = spotRepository.findAll();
        return spot;
    }

}
