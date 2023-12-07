package placeholder.houseParts;


import java.awt.geom.Point2D;
import java.util.ArrayList;

public abstract class Wall {
    private ArrayList<Point2D> vertexes;
    private boolean closed;


    public Wall(ArrayList<Point2D> points, boolean closed) {
        this.vertexes = points;
        this.closed = closed;
    }

    public abstract void render();
}
