
public class EnemyStone extends Stone{

	final String TEXTUREPATH="res/Bricket.png";
	
	protected EnemyStone(int speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		//if(positionX <= 800-texture.getImageWidth()||positionX >= 0)
		positionX=400;//(float) (Math.random()*800);
		positionY=300;
	}

	public void move(int delta){
		positionY-=speed*delta;
	}
}
