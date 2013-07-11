/**
 * 
 */
package com.unorthodox.ponggame.entities;

import com.unorthodox.ponggame.Background;

/**
 * @author stefa_000
 *
 */
public interface Entity 
{

	public float getX();
	public float getY();
	public float getZ();
	public float getCentreX();
	public float getCentreY();
	public float getCentreZ();
	public float getDX();
	public float getDY();
	public float getDZ();
	public float getWidth();
	public float getHeight();
	public float getDepth();
	public boolean isVisible();
	public Background getBackground();
	
	public void setX(float value);
	public void setY(float value);
	public void setZ(float value);
	public void setCentreX(float value);
	public void setCentreY(float value);
	public void setCentreZ(float value);
	public void setDX(float value);
	public void setDY(float value);
	public void setDZ(float value);
	public void setVisible(boolean visibility);
	public void setBackground(Background b);
	
	public void update(float deltaTime);
	public boolean collidesWith(Entity other);
	public void draw();
	
	
}
