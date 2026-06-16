package platformer.code.gamelogic.bullet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import platformer.code.gameengine.PhysicsObject;
import platformer.code.gameengine.hitbox.RectHitbox;
import platformer.code.gameengine.loaders.ImageLoader;
import platformer.code.gamelogic.level.Level;

public class Bullet extends PhysicsObject{

	private float walkSpeed = 50;
	private BufferedImage image;
	private float originalX;
	private int direct;
	
	public Bullet(float x, float y, Level level, int direction) {
		super(x, y,(int)(level.getLevelData().getTileSize()*1.5), (int)(level.getLevelData().getTileSize()*1.5), level);
		movementVector.x = walkSpeed * direction;
		this.hitbox = new RectHitbox(this, 12, 26, width - 27, height - 43);
		originalX = x;
		direct = direction;
		try {
			this.image = ImageLoader.loadImage("src/main/java/platformer/gfx/Bullet.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update(float tslf) {
		float positionY = position.y;
		super.update(tslf);
		movementVector.y = 0;
		position.y = positionY;
		if (movementVector.x == 0) {
            movementVector.x = walkSpeed * direct;
        }
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, (int)position.x, (int)position.y, width, height, null);
		hitbox.draw(g);
	}

	public float getOriginalX() {
		return originalX;
	}
	public void setCurrX(float x) {
		this.position.x = x;
	}
	public int getDirect() {
		return direct;
	}
}

