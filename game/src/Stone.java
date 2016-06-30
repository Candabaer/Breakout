import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Rectangle;
import org.newdawn.slick.Color;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public abstract class Stone {
	protected int width = 1351;
	protected int height = 760;
	
	
	protected float speed;
	protected Texture texture;
	protected float[] position; //0 = x, 1 = y
	protected Rectangle rect;
	protected Boolean toRender;
	
	protected Stone(float speed) {
		position = new float[2];
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
		rect=new Rectangle((int)(position[0]),(int)(position[1]),(int)(texture.getImageWidth()),
				(int)texture.getImageHeight());
	}
	
	public void updateRectangle(){
		rect.setLocation((int)position[0], (int)position[1]);
	}

	public void render() {
		if(toRender){
			Color.white.bind();
			texture.bind(); // or GL11.glBind(texture.getTextureID());
	
			GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(position[0], position[1]);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(position[0] + texture.getTextureWidth(), position[1]);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(position[0] + texture.getTextureWidth(),
					position[1] + texture.getTextureHeight());
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(position[0], position[1] + texture.getTextureHeight());
			//GL11.glScalef(0.5f, 0.5f, 0.5f);
			GL11.glEnd();
		}
	}
	
	public Texture getTexture(){
		return texture;
	}
	
	public float[] getPositon(){
		return position;
	}
	
	public void setToRender(Boolean toRender){
		this.toRender=toRender;
	}
	
	/*@Returns a the Rectangle*/
	public Rectangle getRect(){
		return rect;
	}
}