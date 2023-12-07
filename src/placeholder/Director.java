package placeholder;

import java.awt.geom.Point2D;
import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

import java.util.ArrayList;

public class Director {
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Flooring> floors = new ArrayList<>();

    private HouseBuilder builder;

    public void addWall(ArrayList<double[]> points, boolean exterior, boolean closed) {
        walls.add(new Wall(points, exterior, closed));
        if (exterior && closed) {
            floors.add(new Flooring(points));
        }
    }

    public void setBuilder(HouseBuilder builder) {
        this.builder = builder;
    }

    public House assemble() {
        walls.forEach(x -> builder.addWall(x));
        floors.forEach(x -> builder.addFloor(x));
        return builder.build();
    }







}
