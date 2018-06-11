package test;

import core.Board;
import core.FlattenedBoard;
import entities.Entity;
import entities.beasts.GoodBeast;
import entities.plants.BadPlant;
import entities.squirrels.MasterSquirrel.MasterSquirrel;
import geom.XY;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class FlattenedBoardTest
{
    @Mock
    private Board board;


    private FlattenedBoard flattenedBoard;

    @Before
    public void setUp(){

        MockitoAnnotations.initMocks(this);
        when(board.getSize()).thenReturn(10);
        flattenedBoard = new FlattenedBoard(board);

    }

    @Test
    public void testMasterSquirrelTryMove(){
        MasterSquirrel masterSquirrel = mock(MasterSquirrel.class);
        when(masterSquirrel.getPosition()).thenReturn(new XY(1,1));
        flattenedBoard.tryMove(masterSquirrel,XY.RIGHT);

        verify(masterSquirrel).move(XY.RIGHT);
    }

    @Test
    public void testMasterSquirrelBadPlantEncounter() {
        MasterSquirrel masterSquirrel = mock(MasterSquirrel.class);
        BadPlant badPlant = mock(BadPlant.class);

        when(board.getEntityAtPosition(new XY(2,1))).thenReturn(badPlant);
        when(masterSquirrel.getPosition()).thenReturn(new XY(1,1));
        when(board.getEntityAtPosition(new XY(2,1))).thenReturn(badPlant);
        when(badPlant.getEnergy()).thenReturn(-100);
        when(badPlant.getPosition()).thenReturn(new XY(2,1));

        flattenedBoard.tryMove(masterSquirrel,XY.RIGHT);

        verify(masterSquirrel).hit(flattenedBoard,badPlant);

    }

    @Test
    public void testMasterSquirrelGoodBeastEncounter() {
        MasterSquirrel masterSquirrel = mock(MasterSquirrel.class);
        GoodBeast goodBeast = mock(GoodBeast.class);

        when(board.getEntityAtPosition(new XY(2, 2))).thenReturn(goodBeast);
        when(goodBeast.getEnergy()).thenReturn(200);
        when(masterSquirrel.getPosition()).thenReturn(new XY(1, 1));
        when(goodBeast.getPosition()).thenReturn(new XY(2, 2));

        flattenedBoard.tryMove(masterSquirrel, XY.RIGHT_DOWN);


        verify(masterSquirrel).move(XY.RIGHT_DOWN);
        
    }

}
