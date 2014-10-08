
public class EnemyStone extends Stone{

	final String TEXTUREPATH="res/Bricket.png";
	
	protected EnemyStone(int speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		initQuad();
		positionX=-1;
		if(positionX <= 800-texture.getImageWidth()||positionX >= 0)
		positionX=(float) (Math.random()*800);
		positionY=0;
	}
	
	public void move(int delta){
		positionY+=speed*delta;
	}
}
