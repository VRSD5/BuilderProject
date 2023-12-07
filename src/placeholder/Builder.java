package placeholder;

import placeholder.houseParts.Flooring;
import placeholder.houseParts.Wall;

public interface Builder {
    void addFlooring(Flooring flooring);
    void addWall(Wall wall);
}
