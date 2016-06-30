import java.util.Vector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.opengl.Texture;

public class PlayerStone extends Stone {
	

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	public static final int PEW = 4;
	public float cooldown;
	private final String TEXTUREPATH = "res/Playerstone.png";
	private Vector<Weapon> weapon;

	public PlayerStone(float speed) {
		super(speed);
		weapon = new Vector<Weapon>();
		loadTextures(TEXTUREPATH);
		cooldown = 500f;
		position[0] = (width/2);
		position[1] = (height/4);
	}

	public void update(int delta) {
		int direction = 0;
		this.updateRectangle();
		this.render();
		cooldown -= delta;

		for (int i = 0; i < this.weapon.size(); i++) {
			this.weapon.get(i).update(direction, delta);
			if (this.weapon.get(i).canYouDeletMe()) {
				weapon.remove(i);
			}
		}
		// eingaben überprüfen und ausführen
		this.pollInput(delta);

	}

	private void pollInput(int inputDelta) {
		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			this.move(PlayerStone.UP, inputDelta);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			this.move(PlayerStone.LEFT, inputDelta);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			this.move(PlayerStone.RIGHT, inputDelta);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			this.move(PlayerStone.DOWN, inputDelta);
		}
		if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {
			this.move(PlayerStone.PEW, inputDelta);
		}
	}

	private void move(int direction, int delta) {

		if (position[0] <= 0) {
			position[0] = 0;
		}
		if (position[0] >= width - texture.getImageWidth()) {
			position[0] = width - texture.getImageWidth();
		}
		if (position[1] <= 0) {
			position[1] = 0;
		}
		if (position[1] >= height - (texture.getImageHeight())) {
			position[1] = height - (texture.getImageHeight());
		}

		if (direction == LEFT) {
			position[0] -= speed * delta;
		}
		if (direction == RIGHT) {
			position[0] += speed * delta;
		}
		if (direction == UP) {
			position[1] += speed * delta;
		}
		if (direction == DOWN) {
			position[1] -= speed * delta;
		}
		if (direction == PEW) {
			pewPew(delta);
		}
	}

	private void pewPew(int delta) {
		if (cooldown <= 0) {
			cooldown = 200f;
			float[] positionWithOffset = position.clone();
			positionWithOffset[0] += (texture.getTextureWidth() / 2);
			positionWithOffset[1] += (texture.getTextureHeight());
			weapon.addElement(new Weapon(positionWithOffset, speed, /* cooldown */5));
		}
	}

	public boolean hit(Rectangle enemy) {
		for(int i = 0;i<weapon.size();i++){
			if(weapon.get(i).getRect().intersects(enemy)){
				weapon.remove(i);
				return true;
			}
			
		}
		return false;
	}
}
