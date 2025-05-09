package main;

import main.SpriteFactory.SpriteType;

public class BoxCollider {

	public Vector2f position;
	public int width;
	public int height;
	public float xo = 0;
	public float yo = 0;
	public boolean solid = true;
	
	public BoxCollider(Vector2f position, int width, int height){
		this.position = position;
		this.width = width;
		this.height = height;
	}
	
	public BoxCollider(float x, float y, int width, int height){
		this.position = new Vector2f(x,y);
		this.width = width;
		this.height = height;
	}
	
	public BoxCollider(Vector2f position, int width, int height, float xo, float yo){
		this.position = position;
		this.width = width;
		this.height = height;
		this.xo = xo;
		this.yo = yo;
	}
	
	public boolean intersect(BoxCollider collider, float xo, float yo){
		if(collider == null) return false;
		float x0 = position.x+xo+this.xo;
		float y0 = position.y+yo+this.yo;
		
		float x1 = collider.position.x;
		float y1 = collider.position.y;
		
		int w0 = width;
		int h0 = height;
		
		int w1 = collider.width;
		int h1 = collider.height;
		
		return (x0 < x1 + w1 && x0 + w0 > x1 && y0 < y1 + h1 && y0 + h0 > y1);
	}
	
	public void render(RenderHandler renderHandler){
		renderHandler.renderCollider(this, xo, yo);
	}
	
	public void setSolid(boolean solid){
		this.solid = solid;
	}

	public boolean getSolid() {
		return solid;
	}
}
