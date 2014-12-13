import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public abstract class Stone {
	protected float speed;
	protected Texture texture;
	protected float positionX;
	protected float positionY;
	protected Rectangle rect;
	protected Boolean toRender;
	
	protected Stone(float speed) {
		this.speed = speed;
		toRender=true;
	}

	/*Initialisiert die Texture und das Rectangle*/
	public void loadTextures(final String SOURCE) {
		try {
			texture = TextureLoader.getTexture("PNG",
					ResourceLoader.getResourceAsStream(SOURCE));
		} catch (IOException e) {
			e.printStackTrace();
		}
		rect=new Rectangle((int)(positionX),(int)(positionY),(int)(texture.getImageWidth()),
				(int)texture.getHeight());
	}
	
	public void updateRectangle(){
		rect.setLocation((int)positionX, (int)positionY);
	}

	public void render() {
		if(toRender){
			Color.white.bind();
			texture.bind(); // or GL11.glBind(texture.getTextureID());
	
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(positionX, positionY);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(positionX + texture.getTextureWidth(), positionY);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(positionX + texture.getTextureWidth(),
					positionY + texture.getTextureHeight());
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(positionX, positionY + texture.getTextureHeight());
			GL11.glEnd();
		}
	}
	
	public void setToRender(Boolean toRender){
		this.toRender=toRender;
	}
	
	/*@Returns a the Rectangle*/
	public Rectangle getRect(){
		return rect;
	}
}