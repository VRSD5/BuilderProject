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
        if (closed) {
            points.set(points.size() - 1, points.get(0));
            floors.add(new Flooring(points));

        }
        walls.add(new Wall(points));
    }

    public void addFloor(ArrayList<double[]> points, boolean closed) {
        if (closed) {
            points.set(points.size() - 1, points.get(0));
        }
        floors.add(new Flooring(points));
    }

    public void setBuilder(HouseBuilder builder) {
        this.builder = builder;
    }

    public House assemble() {
        walls.forEach(x -> builder.addWall(x.copy()));
        floors.forEach(x -> builder.addFloor(x.copy()));
        return builder.build();
    }


    public void reset() {
        walls = new ArrayList<>();
        floors = new ArrayList<>();
    }




}
