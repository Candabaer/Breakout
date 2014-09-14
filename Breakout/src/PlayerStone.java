

public class PlayerStone extends Stone {

	final String TEXTUREPATH="res/Playerstone.png";
	
	public PlayerStone(int speed, int gravity) {
		super(speed, gravity);
		loadTextures(TEXTUREPATH);
		initQuad();
	}

}
