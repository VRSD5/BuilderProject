package placeholder;

import javafx.scene.canvas.GraphicsContext;
import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

import java.util.ArrayList;

public class House {
    protected final ArrayList<Wall> walls;
    protected final ArrayList<Flooring> floors;


    public House(ArrayList<Wall> walls, ArrayList<Flooring> floors) {
        this.walls = walls;
        this.floors = floors;
    }

    public void render(GraphicsContext gc) {
        for (Flooring floor : floors) {
            floor.render(gc);
        }
        for (Wall wall : walls) {
            wall.render(gc);
        }

    }
}
