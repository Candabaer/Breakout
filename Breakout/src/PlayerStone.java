

public class PlayerStone extends Stone {

	final String TEXTUREPATH="res/Playerstone.png";
	
	public PlayerStone(int speed, int gravity) {
		super(speed, gravity);
		loadTextures(TEXTUREPATH);
		positionX=350;
		positionY=500;
	}
	
	public void move(boolean left,int delta) {
		if(left){
			positionX -= 0.35f * delta;
		}else if(!left){
			positionX += 0.35f * delta;
		}
	}

}
