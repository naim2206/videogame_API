
package physics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import game.Assets;
import game.GameState;
import game.Loader;

/**
 * Class for Brick objects (Rectangular and not movable)
 * 
 * @author Naim Towfighian and Alejandro Casillas
 */
public class Brick extends RectObj {

    private BufferedImage texture = Assets.WoodBrick;

    /**
     * 
     * @return texture
     */
    public BufferedImage getTexture() {
        return texture;
    }

    /**
     * 
     * @param texture
     */
    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    /**
     * Basic with all parameters
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param material  material of the object
     * @param width     width of the circle
     * @param height    height of the circle
     * @param gameState state of the game where object was created
     */
    public Brick(int x, int y, double weight, Material material, double width, double height, GameState gameState) {
        super(x, y, weight, material, width, height, gameState);
        if (material == Material.Stone)
            this.setTexture(Assets.StoneBrick);
    }

    /**
     * Basic constructor
     * defaults: material = Wood
     * 
     * @param x         X position of the object
     * @param y         Y position of the object
     * @param weight    weight of the object
     * @param width     width of the circle
     * @param height    height of the circle
     * @param gameState state of the game where object was created
     */
    public Brick(int x, int y, double weight, double width, double height, GameState gameState) {
        super(x, y, weight, width, height, gameState);
    }

    @Override
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
        texture = Loader.resize(texture, (int) getWidth(), (int) getHeight());
        g2d.drawImage(texture, at, null);
    }

}
