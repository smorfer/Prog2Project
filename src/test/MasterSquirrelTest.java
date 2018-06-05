package test;

import core.EntityContext;
import entities.squirrelBots.MasterSquirrelBot;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import entities.squirrels.MiniSquirrel.MiniSquirrel;
import exceptions.NotEnoughEnergyException;
import geom.XY;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MasterSquirrelTest
{
    @Mock
    private EntityContext entityContext;
    @Mock
    private MiniSquirrel miniSquirrel;

    private MasterSquirrel masterSquirrel;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        masterSquirrel = new MasterSquirrel(new XY(0, 0));
    }

    @Test(expected = NotEnoughEnergyException.class)
    public void testMiniSquirrelSpawning() throws NotEnoughEnergyException{
        masterSquirrel.spawnMiniSquirrel(new XY(0,1),masterSquirrel.getEnergy()+1);
    }

    @Test
    public void testMinisquirrelHit(){
        when(miniSquirrel.getMasterID()).thenReturn(-1);
        masterSquirrel.hit(entityContext,miniSquirrel);
        assertEquals(2150,masterSquirrel.getEnergy());
    }


}
