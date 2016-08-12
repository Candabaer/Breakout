
public class EndBoss extends Stone{
	final String TEXTUREPATH = "";

	protected EndBoss(float speed) {
		super(speed);
		loadTextures(TEXTUREPATH);
		position[1] = width;
		position[0] = -1;
		position[0] = (float) (Math.random() * width);
		position[0] %= (width - (texture.getImageWidth()));
	}

	public Boolean update(int delta) {

		this.updateRectangle();
		this.move(delta);
		this.render();
		return this.canYouDeletMe();
	}

	public void move(int delta) {
		position[1] -= speed * delta;
	}

	public boolean canYouDeletMe() {
		if (position[1] < -1 - texture.getImageHeight())
			return true;
		else
			return false;
	}
}
