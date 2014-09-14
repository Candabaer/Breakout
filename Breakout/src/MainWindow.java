import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class MainWindow {
	PlayerStone player;
	
	public MainWindow() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		player=new PlayerStone(5,4);
	}
	
	public void start() {
		
		while (!Display.isCloseRequested()) {
			//objekte rendern
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
			player.render();
			//eingaben überprüfen und ausführen
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
}