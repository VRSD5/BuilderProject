package placeholder;

import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

import java.util.ArrayList;

public abstract class House {
    private ArrayList<Wall> walls = new ArrayList<>();
    private ArrayList<Flooring> floorings = new ArrayList<>();



    public abstract void render();
}
