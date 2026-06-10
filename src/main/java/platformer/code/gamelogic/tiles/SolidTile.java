package platformer.code.gamelogic.tiles;

import java.awt.image.BufferedImage;

import platformer.code.gameengine.hitbox.RectHitbox;
import platformer.code.gamelogic.level.Level;

public class SolidTile extends Tile{
	
	public SolidTile(float x, float y, int size, BufferedImage image, Level level) {
		super(x, y, size, image, true, level);
		int offset =(int)(level.getLevelData().getTileSize()*0.1); //hitbox is offset by 10% of the tile size
		this.hitbox = new RectHitbox(x *size, y*size, 0, offset, size, size);
	}
	public String toString() {
		return "I'm a solidTile at "+this.position.x+" "+this.position.y;
	}

	public float getX() {
		return this.position.x;
	}

	public float getY() {
		return this.position.y;
	}
}
