import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public abstract class Stone {
	private int speed;
	private int gravity;
	private Texture texture;
	protected int positionX;
	protected int positionY;
	
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