package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.Assets;
import game.GameState;
import game.Loader;

public class Brick extends RectObj {

    private BufferedImage texture = Assets.WoodBrick;

    /**
     * @param x
     * @param y
     * @param weight
     * @param material
     * @param velX
     * @param velY
     * @param accX
     * @param accY
     * @param width
     * @param height
     */
    public Brick(int x, int y, double weight, Material material, double velX, double velY, double accX, double accY,
            double width, double height, GameState gamestate) {
        super(x, y, weight, material, velX, velY, accX, accY, width, height, gamestate);
        this.gameState = gamestate;
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBrick);
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    /**
     * @param x
     * @param y
     * @param weight
     * @param material
     * @param width
     * @param height
     */
    public Brick(int x, int y, double weight, Material material, double width, double height, GameState gameState) {
        super(x, y, weight, material, width, height, gameState);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBrick);
    }

    /**
     * @param x
     * @param y
     * @param weight
     * @param width
     * @param height
     */
    public Brick(int x, int y, double weight, double width, double height, GameState gameState) {
        super(x, y, weight, width, height, gameState);
    }

    // public void destroy(ArrayList<Collisionable> colObjects) {
    // colObjects.remove(this);
    // }

    public void destroy() {
        gameState.getColObjects().remove(this);
    }

    @Override
    public void update() {
        for (int i = 0; i < gameState.getColObjects().size(); i++) {
            Collisionable c = gameState.getColObjects().get(i);
            if (c.equals(this)) {
                continue;
            }

            if (this.checkCollision(c)) {
                if (this.breakObject(c)) {
                    destroy();
                }
                // } else {
                // impact(this, c);
                // if (c instanceof Movable) {
                // Movable cM = (Movable) c;
                // cM.move();
                // cM.move();
                // cM.move();
                // }
                // }
                if (c.breakObject(this)) {
                    c.destroy();
                    continue;
                }
            }

        }

    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        AffineTransform at = AffineTransform.getTranslateInstance((double) getX(),
                (double) getY());
        // AffineTransform at = AffineTransform.getTranslateInstance((double) getX() +
        // getWidth() / 2,
        // (double) getY() + getHeight() / 2);

        texture = Loader.resize(texture, (int) getWidth(), (int) getHeight());

        g2d.drawImage(texture, at, null);
    }

}
