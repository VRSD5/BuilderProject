package placeholder;

import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

import java.util.ArrayList;

public class HouseBuilder {
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Flooring> floors = new ArrayList<>();

    public void addWall(Wall wall) {
        wall.setStyle(1);
        walls.add(wall);
    }

    public void addFloor(Flooring floor) {
        System.out.println("addFLoor");
        floor.setStyle(1);
        floors.add(floor);
    }

    public House build() {
        return new House(walls, floors);
    }
}
