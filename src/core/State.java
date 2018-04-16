package core;

public class State {
    int highscore = 0;
    Board board;

    public State(Board board)
    {
        this.board = board;
    }

    public void update(){

    }

    public FlattenedBoard flattenedBoard()
    {
        return board.getData();
    }
}
