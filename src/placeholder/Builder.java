package placeholder;

import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;
import placeholder.houseParts.Window;

public interface Builder {
    void addFloor(Flooring flooring);
    void addWall(Wall wall);
    void addWindow(Window window);
    House build();
}
