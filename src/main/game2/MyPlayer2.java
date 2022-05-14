package main.game2;

import java.awt.image.BufferedImage;

import javax.swing.JOptionPane;

import game.GameState;
import game.Keyboard;
import physics.Player;

public class MyPlayer2 extends Player {

    public MyPlayer2(int x, int y, double weight, double velX, double velY, double accX, double accY, double radius,
            BufferedImage texture, GameState gameState) {
        super(x, y, weight, velX, velY, accX, accY, radius, texture, gameState);
    }

    public MyPlayer2(int x, int y, double weight, double radius, BufferedImage texture, GameState gameState) {
        super(x, y, weight, radius, texture, gameState);

        setVelX(0);
        setVelY(0);
    }

    @Override
    public void moveByPlayer() {

        if (getX() > GameStates2.width) {
            setX(0);
        }
        if (getY() > GameStates2.heigth) {
            setY(0);
        }

        if (getX() < 0) {
            setX(GameStates2.width);
        }

        if (Keyboard.RIGHT && (MAX_SPEED_X > getVelX())) {
            this.setVelX(getVelX() + 0.2);
            // move();

            this.setX((int) (getX() + 2));
            return;
        }

        if (Keyboard.LEFT && (-MAX_SPEED_X < getVelX())) {
            this.setVelX(getVelX() - 0.2);
            // move();

            this.setX((int) (getX() - 2));
            return;
        }

        if (Keyboard.UP && (-MAX_SPEED_Y < getVelY())) {
            // this.setVelX(0);
            this.setVelY(getVelY() - 1.5);

            this.setY((int) (getY() - 2));
            return;
        }

        else {
            this.setAccX(0);
            this.setAccY(0);
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        JOptionPane.showMessageDialog(null, "You died", "Game end", JOptionPane.ERROR_MESSAGE);
    }

}