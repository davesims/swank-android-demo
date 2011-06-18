package de.exterm.android;

import de.exterm.android.SpriteRenderer.GLSprite;

public class Sprite implements GLSprite {
	private float x = 0;
	private float y = 0;
	private float a = 0;
	private float s = 1;	
	
	public Sprite(float x, float y, float a, float s) {
		this.x = x;
		this.y = y;
		this.a = a;
		this.s = s;
	}

	@Override
	public float getX() {
		return x;
	}

	@Override
	public float getY() {
		return y;
	}

	@Override
	public float getAngle() {
		return a;
	}

	@Override
	public float getScale() {
		return s;
	}

	@Override
	public void setX(float x) {
		this.x = x;
		
	}

	@Override
	public void setY(float y) {
		this.y = y;		
	}

	@Override
	public void setAngle(float a) {
		this.a = a;		
	}

	@Override
	public void setScale(float s) {
		this.s = s;		
	}
}
