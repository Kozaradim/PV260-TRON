package cz.muni.PV260.tron.engine;

public interface GameBoard {
    Position getDimension();

    Position move(Position position, Direction direction);
}
