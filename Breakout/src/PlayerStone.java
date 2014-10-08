import org.newdawn.slick.opengl.Texture;

public class PlayerStone extends Stone {

	public final int LEFT = 0;
	public final int RIGHT = 1;
	public final int UP = 2;
	public final int DOWN = 3;
	private final String TEXTUREPATH = "res/Playerstone.png";

	public PlayerStone(int speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		positionX = 350;
		positionY = 500;
	}

	public void move(int direction, int delta) {
		// delta=1;

		if (positionX <= 0) {
			positionX = 0;
		}
		if (positionX >= 800 - texture.getImageWidth()) {
			positionX = 800 - texture.getImageWidth();
		}
		if (positionY <= 0) {
			positionY = 0;
		}
		if (positionY >= 600 - texture.getHeight()) {
			positionY = 600 - texture.getHeight();
		}

		if (direction == LEFT) {
			positionX -= speed * delta;
		}
		if (direction == RIGHT) {
			positionX += speed * delta;
		}
		if (direction == UP) {
			positionY += speed * delta;
		}
		if (direction == DOWN) {
			positionY -= speed * delta;
		}
	}
}
