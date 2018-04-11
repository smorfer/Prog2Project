package core;

import geom.XY;

public interface BoardView {

    public EntityType getEntityType(int x, int y);

    public XY getSize();
}
