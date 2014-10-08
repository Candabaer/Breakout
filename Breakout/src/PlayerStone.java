import org.newdawn.slick.opengl.Texture;



public class PlayerStone extends Stone {

	final String TEXTUREPATH="res/Playerstone.png";
	
	public PlayerStone(int speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		positionX=350;
		positionY=500;
	}

	public void move(boolean left, int delta) {
		if (positionX >= 0) {
			if (left) {
				positionX -= speed * delta;
			}
		}
		if (positionX <= 800-texture.getImageWidth()) {
			if (!left) {
				positionX += speed * delta;
			}
		}
	}
}
