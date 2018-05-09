package botapi;

import core.EntityType;
import geom.XY;

public interface ControllerContext {
    public XY getViewLowerLeft();
    public XY getViewUpperRight();
    public EntityType getEntityAt(XY xy);
    public void move(XY direction);
    public void spawnMiniBot(XY direction, int energy); //TODO: MiniSpawning!
    public int getEnergy();
}
