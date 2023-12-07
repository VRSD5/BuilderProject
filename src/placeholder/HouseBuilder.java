package placeholder;

import javafx.scene.paint.Color;
import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

import java.util.ArrayList;

public class HouseBuilder {
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Flooring> floors = new ArrayList<>();
    private int style;
    private String[] wallColors = new String[]{"#372404", "#585858", "#d6d7da", "#372404"};
    private String[] floorColors = new String[]{"#b29060", "#7c7c7c", "#1b72ff", "#b29060"};
    private String[] backgroundColor = new String[]{"#15ac0b", "#15ac0b", "#1b72ff", "#1b72ff"};
    private int[] wallWidths = new int[]{5, 5, 10, 5};

    public HouseBuilder(int style) {
        this.style = style;
    }

    public void addWall(Wall wall) {
        wall.setColor(Color.valueOf(wallColors[style]));
        wall.setWidth(wallWidths[style]);
        walls.add(wall);
    }



    public void addFloor(Flooring floor) {
        floor.setColor(Color.valueOf(floorColors[style]));

        floors.add(floor);
    }

    public House build() {
        return new House(walls, floors, backgroundColor[style]);
    }
}
