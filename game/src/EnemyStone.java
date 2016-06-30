public class EnemyStone extends Stone {

	final String TEXTUREPATH = "res/Bricket.png";

	protected EnemyStone(float speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		position[1] = width;
		position[0] = -1;
		while (true) {
			position[0] = (float) (Math.random() * width);
			if (position[0] >= 0 || position[0] <= width - (texture.getImageHeight())) {
				break;
			}
		}
	}
	
	public Boolean update(int delta){
		
		this.updateRectangle();
		this.move(delta);
		this.render();
		return this.canYouDeletMe();
	}

	public void move(int delta) {
		position[1] -= speed * delta;
	}

	public boolean canYouDeletMe() {
		if (position[1] < 0)
			return true;
		else
			return false;
	}
}
