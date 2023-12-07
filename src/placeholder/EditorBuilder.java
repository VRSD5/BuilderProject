package placeholder;

import javafx.scene.paint.Color;
import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;
import placeholder.houseParts.Window;

import java.util.ArrayList;

import static placeholder.scripts.distance;

public class EditorBuilder implements Builder {
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Flooring> floors = new ArrayList<>();
    private ArrayList<Window> windows = new ArrayList<>();

    private int style;
    private String[] wallColors = new String[]{"#372404", "#585858", "#d6d7da", "#372404"};
    private String[] floorColors = new String[]{"#b29060", "#7c7c7c", "#1b72ff", "#b29060"};
    private String[] backgroundColor = new String[]{"#15ac0b", "#15ac0b", "#1b72ff", "#1b72ff"};

    private String[] windowColors = new String[]{"#1b72ff", "#1b72ff", "#d6d7da", "#1b72ff"};
    private String[] sillColors = new String[]  {"#372404", "#585858", "#1b72ff", "#372404"};
    private int[] sillWidths = new int[]{6, 7, 11, 5};
    private int[] windowWidths = new int[]{5, 7, 1, 4};
    private int[] wallWidths = new int[]{5, 5, 10, 5};

    public EditorBuilder(int style) {
        this.style = style;
    }

    public void addWall(Wall wall) {
        wall.setWallColor(Color.valueOf(wallColors[style]));
        wall.setWidth(wallWidths[style]);
        walls.add(wall);
    }



    public void addFloor(Flooring floor) {
        floor.setColor(Color.valueOf(floorColors[style]));

        floors.add(floor);
    }

    public void addWindow(Window window) {
        window.setWindowColor(Color.valueOf(windowColors[style]));
        window.setSillColor(Color.valueOf(sillColors[style]));
        window.setWindowWidth(windowWidths[style]);
        window.setSillWidth(sillWidths[style]);
        double[] pointA = window.getPointA();
        Wall closestWall = walls.get(0);
        double min_dist = 100000;
        for (Wall wall : walls) {
            double[] p = wall.nearestPoint(pointA);

            if (distance(p, pointA) < min_dist) {
                closestWall = wall;
                min_dist = distance(p, pointA);
            }
        }

        closestWall.addWindow(window);

    }

    public House build() {
        return new House(walls, floors, backgroundColor[style]);
    }
}
