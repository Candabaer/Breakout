import java.util.Vector;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

public class GameLoop {

	final float TESTSPEED = 0.5f;
	private int spawnDelta;
	// private int delta;
	private Vector<EnemyStone> enemys;
	private PlayerStone player;

	public GameLoop() {
		player = new PlayerStone(TESTSPEED * 1.5f);
		enemys = new Vector<EnemyStone>();

	}

	public void loop(int delta) {
		// timer
		spawnEnemys(delta);
		// objekte rendern
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		player.update(delta);

		for (int i = 0; i < enemys.size(); i++) {
			if (enemys.get(i).update(delta) == true) {
				enemys.remove(i);
				continue;
			}

		}

		if (!enemys.isEmpty()) {
			handleAllTheCollisions();
		}

	}

	private void spawnEnemys(int delta) {
		spawnDelta += delta;
		int timeToSpawn = 500;
		if (spawnDelta >= timeToSpawn) {
			EnemyStone tmp = new EnemyStone(TESTSPEED);
			enemys.add(tmp);
			spawnDelta = 0;
		}
	}

	private void handleAllTheCollisions() {// TODO Hurensohn funktioniert nicht
		for (int i = 0; i < enemys.size(); i++) {
			if (player.getRect().intersects(enemys.get(i).getRect())) {
				enemys.get(i).setToRender(false);
				enemys.remove(i);
			} else if (player.hit(enemys.get(i).getRect())) {
				enemys.get(i).setToRender(false);
				enemys.remove(i);
			}
		}
	}

}
