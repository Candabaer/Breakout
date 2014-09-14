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
	
	public MainWindow() {
		try {
			initGL();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		player=new PlayerStone(5,0);
	}
	
	public void start() {

		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		while (!Display.isCloseRequested()) {
			//objekte rendern
			player.render();
			//eingaben überprüfen und ausführen
			pollInput();
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
	
	private void pollInput() {
		int delta=1;
		if(Keyboard.isKeyDown(Keyboard.KEY_A)){
			player.move(true, delta);
		}else if(Keyboard.isKeyDown(Keyboard.KEY_D)){
			player.move(false, delta);
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
		GL11.glOrtho(0, width, height, 0, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}

}