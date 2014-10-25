public class EnemyStone extends Stone {

	final String TEXTUREPATH = "res/Bricket.png";

	protected EnemyStone(float speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		positionY = 600;
		positionX=-1;
		while (true) {
			positionX = (float) (Math.random() * 800);
			if (positionX >= 0 || positionX <= 800) {
				break;
			}
		}

	}

	public void move(int delta) {
		positionY -= speed * delta;
	}
}
