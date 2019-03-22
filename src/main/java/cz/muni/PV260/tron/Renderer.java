package cz.muni.PV260.tron;

import java.awt.*;

public class Renderer {
    private final Graphics2D graphics;

    public Renderer(Graphics2D graphics) {
        this.graphics = graphics;
    }


    void renderBackground(GameBoard gameBoard) {
        graphics.setColor(gameBoard.getBackgroundColor());
        graphics.fillRect(0, 0, gameBoard.getDimension().x, gameBoard.getDimension().y);
    }

    public void renderPlayer(Player player) {
        graphics.setColor(player.getColor());
        player.getPath()
                .forEach(position ->
                        graphics.fillRect(position.x, position.y, 10, 10));
    }
}
