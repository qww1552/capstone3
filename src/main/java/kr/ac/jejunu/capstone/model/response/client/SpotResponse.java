package kr.ac.jejunu.capstone.model.response.client;

import kr.ac.jejunu.capstone.model.station.space.Spot;
import lombok.Data;

import java.util.List;

@Data
public class SpotResponse {
    // 보드에 요청 시 들어오는 응답

    private String status;
    private Integer sid;
    private List<double[]> spot;
    private Boolean full;

    public Spot getSpot() {
        Spot spotObj = new Spot();
        spotObj.setSid(this.sid);
        spotObj.setSpot(this.spot);
        spotObj.setFull(this.full);
        return spotObj;
    }
}
