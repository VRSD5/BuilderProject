package placeholder;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Paint;
import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

import java.util.ArrayList;

import static placeholder.scripts.distance;

public class House {
    protected final ArrayList<Wall> walls;
    protected final ArrayList<Flooring> floors;
    private final String backgroundColor;

    public House(ArrayList<Wall> walls, ArrayList<Flooring> floors, String color) {
        this.walls = walls;
        this.floors = floors;
        this.backgroundColor = color;
    }

    public double[] findNearestWall(double[] point) {
        double[] min_pt = new double[2];
        double min_dist = 100000;
        for (Wall wall : walls) {
            double[] p = wall.nearestPoint(point);

            if (distance(p, point) < min_dist) {
                min_pt[0] = p[0];
                min_pt[1] = p[1];
                min_dist = distance(p, point);
            }
        }
        return min_pt;
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
