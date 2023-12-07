package placeholder;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

import java.util.ArrayList;

public class House {
    protected final ArrayList<Wall> walls;
    protected final ArrayList<Flooring> floors;
    private final String backgroundColor;

    public House(ArrayList<Wall> walls, ArrayList<Flooring> floors, String color) {
        this.walls = walls;
        this.floors = floors;
        this.backgroundColor = color;
    }

    public void render(GraphicsContext gc) {
        gc.setFill(Paint.valueOf(backgroundColor));
        gc.fillRect(0, 0, Main.x_size, Main.y_size);

        for (Flooring floor : floors) {
            floor.render(gc);
        }
        for (Wall wall : walls) {
            wall.render(gc);
        }

    }
}
