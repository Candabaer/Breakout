import org.newdawn.slick.opengl.Texture;

public class PlayerStone extends Stone {

	public static final int LEFT = 0;
	public static final int RIGHT = 1;
	public static final int UP = 2;
	public static final int DOWN = 3;
	public static final int PEW = 4;
	private final String TEXTUREPATH = "res/Playerstone.png";

	public PlayerStone(int speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		positionX = 350;
		positionY = 100;
	}

	public void move(int direction, int delta) {

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
		if(direction == PEW){
			pewPew();
		}
	}
	
	public void pewPew(){
		/*FIRE ALL THE WEAPONS
		 * for (weapon tmp:Weapons)
		 * weapon.fire();
		 */
		
	}
}
