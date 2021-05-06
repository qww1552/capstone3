package kr.ac.jejunu.capstone.client;

import kr.ac.jejunu.capstone.repository.SpotRepository;
import kr.ac.jejunu.capstone.model.entity.Spot;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestComponent;

import java.util.List;
@TestComponent
public class SpotRepositoryTest {
    @Autowired
    private SpotRepository spotRepository;

    @Test
    public void get() {

        List<Spot> all = spotRepository.findAll();
        System.out.println(all);
    }
}
