package placeholder;

import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;
import placeholder.houseParts.Window;

import java.util.ArrayList;

import static placeholder.scripts.distance;

public class Director {
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Flooring> floors = new ArrayList<>();
    private ArrayList<Window> windows = new ArrayList<>();

    private Builder builder;

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

    public void addWindow(double[] pointA, double[] pointB) {
        windows.add(new Window(pointA, pointB));
    }

    public void setBuilder(EditorBuilder builder) {
        this.builder = builder;
    }

    public House assemble() {
        walls.forEach(x -> builder.addWall(x.copy()));
        floors.forEach(x -> builder.addFloor(x.copy()));
        windows.forEach(x -> builder.addWindow(x.copy()));
        return builder.build();
    }


    public void reset() {
        walls = new ArrayList<>();
        floors = new ArrayList<>();
    }




}
