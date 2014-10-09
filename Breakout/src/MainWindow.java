import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class MainWindow {
	final int TESTSPEED=1;
	
	private PlayerStone player;
	private int width = 800;
	private int height = 600;
	private Timer timer;
	private int spawnDelta;
	private int delta;
	private Vector<EnemyStone> enemys;
	
	public MainWindow() {
		spawnDelta=0;
		enemys = new Vector<EnemyStone>();
		timer=new Timer();
		try {
			initGL();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		player=new PlayerStone(TESTSPEED);
	}
	
	public void start() {
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		timer.getDelta();
		while (!Display.isCloseRequested()) {
			//timer
			delta=timer.getDelta();
			spawnEnemys(delta);
			// objekte rendern
			for (EnemyStone tmp : enemys) {
				tmp.render();
				tmp.move(delta);
			}
			player.render();
			//eingaben überprüfen und ausführen
			pollInput(delta);
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	private void pollInput(int inputDelta) {
		if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			player.move(PlayerStone.UP, inputDelta);
		}if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.move(PlayerStone.LEFT, inputDelta);
		}if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.move(PlayerStone.RIGHT, inputDelta);
		}if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			player.move(PlayerStone.DOWN, inputDelta);
		}if(Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
			player.move(PlayerStone.PEW, inputDelta);
		}
	}
	
	private void spawnEnemys(int delta){
		spawnDelta+=delta;
		int timeToSpawn=2500;
		System.out.println(spawnDelta+"  "+delta+"  "+enemys.size());
		if(spawnDelta>=timeToSpawn){
			EnemyStone tmp=new EnemyStone(TESTSPEED);
			enemys.add(tmp);
			spawnDelta=0;
		}
	}
	
	
	private void initGL() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(width, height));
		Display.create();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		// enable alpha blending
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);

		GL11.glViewport(0, 0, width, height);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);

		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, width,0,height, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

}