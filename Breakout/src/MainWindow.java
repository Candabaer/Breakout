import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class MainWindow {
	private PlayerStone player;
	private int width = 800;
	private int height = 600;
	private Timer timer;
	private int delta;
	private Vector<EnemyStone> enemys;
	
	public MainWindow() {
		delta=0;
		timer=new Timer();
		try {
			initGL();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		player=new PlayerStone(5);
	}
	
	public void start() {
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		while (!Display.isCloseRequested()) {
			//timer
			spawnEnemys();
			//objekte rendern
			/*for(EnemyStone tmp:enemys){
				tmp.render();
				tmp.move(timer.getDelta());
			}*/
			player.render();
			//eingaben überprüfen und ausführen
			pollInput();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	private void pollInput() {
		int inputDelta=1;
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.move(player.LEFT, inputDelta);
		}if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.move(player.RIGHT, inputDelta);
		}if(Keyboard.isKeyDown(Keyboard.KEY_S)){
			player.move(player.UP, inputDelta);
		}if(Keyboard.isKeyDown(Keyboard.KEY_W)){
			player.move(player.DOWN, inputDelta);
		}
	}
	
	private void spawnEnemys(){
		delta+=timer.getDelta();
		int timeToSpawn=5000;
		if(delta>=timeToSpawn){
			EnemyStone tmp=new EnemyStone(2);
			delta=0;
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
		GL11.glOrtho(0, width,height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

}