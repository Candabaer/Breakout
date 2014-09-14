
public class EnemyStone extends Stone{

	final String TEXTUREPATH="res/Bricket.png";
	
	protected EnemyStone(int speed, int gravity) {
		super(speed, gravity);
		loadTextures(TEXTUREPATH);
		initQuad();
	}

}
