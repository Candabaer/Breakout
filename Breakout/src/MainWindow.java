import java.util.Vector;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class MainWindow {
	
	
	public void start() {
		try {
			Display.setDisplayMode(new DisplayMode(800, 600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
		while (!Display.isCloseRequested()) {
			//objekte rendern
			
			//eingaben überprüfen und ausführen
			
			Display.update();
			Display.sync(60);
		}
		Display.destroy();
	}
}