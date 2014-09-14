import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public abstract class Stone {
	protected int speed;
	protected int gravity;
	protected Texture texture;
	
	protected Stone(int speed, int gravity) {
		this.speed = speed;
		this.gravity = gravity;
	}

	public void loadTextures(final String SOURCE) {
		try {
			texture = TextureLoader.getTexture("PNG",
					ResourceLoader.getResourceAsStream(SOURCE));
		} catch (IOException e) {
			e.printStackTrace();
		}
	};

	public void initQuad() {
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());
	};

	public void updateQuad() {
		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(100, 100);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(100 + texture.getTextureWidth(), 100);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(100 + texture.getTextureWidth(),
				100 + texture.getTextureHeight());
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(100, 100 + texture.getTextureHeight());
		GL11.glEnd();
	};
	
	public void move() {

	};

}