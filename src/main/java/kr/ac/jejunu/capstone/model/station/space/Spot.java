package kr.ac.jejunu.capstone.model.station.space;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Data
@Entity
public class Spot {

    private double x;
    private double y;

    public Spot(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double[] getSpot() {
        return new double[]{x, y};
    }

}
