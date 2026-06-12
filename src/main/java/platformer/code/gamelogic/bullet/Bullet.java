package platformer.code.gamelogic.bullet;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import platformer.code.gameengine.PhysicsObject;
import platformer.code.gameengine.hitbox.RectHitbox;
import platformer.code.gamelogic.GameResources;
import platformer.code.gamelogic.level.Level;

public class Bullet extends PhysicsObject{

	private float walkSpeed = 80;
	private BufferedImage image;
	
	public Bullet(float x, float y, Level level, int direction) {
		super(x, y,(int)(level.getLevelData().getTileSize()*1.5), (int)(level.getLevelData().getTileSize()*1.5), level);
		movementVector.x = walkSpeed * direction;
		this.hitbox = new RectHitbox(this, 10, 10, width - 30, height - 30);
		this.image = GameResources.enemy;
	}
	
	@Override
	public void update(float tslf) {
		float currentXSpeed = movementVector.x;
		super.update(tslf);
		movementVector.y = 0;
		movementVector.x = currentSpeed;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, (int)position.x, (int)position.y, width, height, null);
		
		hitbox.draw(g);
	}
	
}

