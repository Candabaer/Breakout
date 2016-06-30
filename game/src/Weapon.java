

public class Weapon extends Stone {
	private final String TEXTUREPATH = "res/projectile.png";
	private static float cooldown;
	private Boolean toggleShot;
	
	

	protected Weapon(float[] position,float speed, float cooldown) {
		super(speed * 1.75f);
		loadTextures(TEXTUREPATH);
		this.position = position.clone();
	}
	
	public void move(int direction, int delta) {
		if (direction == 0) {
			position[1] += speed * delta;
			cooldown -= delta;
		}
	}
	
	public void update(int direction,int delta){
		this.updateRectangle();
		this.render();
		move(direction, delta);
	}
	public boolean canYouDeletMe() {
		if (position[1] > width)
			return true;
		else
			return false;
	}
	
	public float getCooldown() {
		return cooldown;
	}	
}
