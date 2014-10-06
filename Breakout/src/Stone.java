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
	protected float positionX;
	protected float positionY;
	
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
	}

	public void initQuad() {
	}

	public void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		Color.white.bind();
		texture.bind(); // or GL11.glBind(texture.getTextureID());

		GL11.glBegin(GL11.GL_QUADS);
		GL11.glTexCoord2f(0, 0);
		GL11.glVertex2f(positionX, positionY);
		GL11.glTexCoord2f(1, 0);
		GL11.glVertex2f(positionX + texture.getTextureWidth(), positionY);
		GL11.glTexCoord2f(1, 1);
		GL11.glVertex2f(positionX + texture.getTextureWidth(),
				positionY + texture.getTextureHeight());
		GL11.glTexCoord2f(0, 1);
		GL11.glVertex2f(positionX, positionY + texture.getTextureHeight());
		GL11.glEnd();
	}
}