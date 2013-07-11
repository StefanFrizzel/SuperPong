/**
 * 
 */
package com.unorthodox.ponggame.entities;

import com.unorthodox.ponggame.Background;

/**
 * @author stefa_000
 *
 */
public abstract class AbstractEntity implements Entity 
{
	



	protected float x,y,z;
	protected float dx;
	protected float dy;
	protected float dz;
	protected float width;
	protected float height;
	protected float depth;
	protected boolean isVisible;
	Background background;

	public AbstractEntity(float x,float y,float z,float width, float height, float depth)
	{
		 this.x = x;
		 this.y = y;
		 this.z = z;
		 this.width = width;
		 this.height = height;
		 this.depth = depth;
		 isVisible = true;
		 dx = 0;
		 dy = 0;
		 dz = 0;
	}
	
	public AbstractEntity()
	{
		
	}
	
	
	
	
	@Override
	public float getX() 
	{
		return x;
	}


	@Override
	public float getY() 
	{
		return y;
	}

	
	@Override
	public float getZ() 
	{
		return z;
	}

	
	@Override
	public float getDX() 
	{
		return dx;
	}

	
	@Override
	public float getDY() 
	{
		return dy;
	}

	
	@Override
	public float getDZ() 
	{
		return dz;
	}

	@Override
	public boolean isVisible() 
	{
		return isVisible;
	}


	@Override
	public Background getBackground() 
	{
		return background;
	}

	
	@Override
	public void setX(float value) 
	{
		x = value;
	}


	@Override
	public void setY(float value) 
	{
		y = value;
	}


	@Override
	public void setZ(float value)
	{
		z = value;
	}

	@Override
	public void setDX(float value) 
	{
		dx = value;
	}

	
	@Override
	public void setDY(float value) 
	{
		dy = value;
	}

	
	@Override
	public void setDZ(float value)
	{
		dz = value;
	}

	@Override
	public void setVisible(boolean visibility) 
	{
		isVisible = visibility;
	}

	@Override
	public void setBackground(Background b) 
	{
		background = b;
	}

	
	
	public void update(float deltaTime) 
	{
		x += (dx*deltaTime); 
		y += (dy*deltaTime); 
		z += (dz*deltaTime); 
	}

	
	@Override
	public float getWidth() 
	{
	
		return width;
	}


	
	@Override
	public float getHeight() 
	{
		return height;
	}



	@Override
	public float getDepth()
	{
		return depth;
	}


	



	@Override
	public float getCentreX() 
	{
		 return x + (width/2);
	}


	@Override
	public float getCentreY() 
	{
		return y + (height/2);
	}

	@Override
	public float getCentreZ() 
	{
		return z + (depth/2);
	}


	
	@Override
	public void setCentreX(float value) 
	{
		x=value-(width/2);
	}


	@Override
	public void setCentreY(float value) 
	{
		y=value-(height/2);
	}


	
	@Override
	public void setCentreZ(float value) 
	{
		z=value-(depth/2);
	}


	@Override
	public boolean collidesWith(Entity other) 
	{
		//basic collision detection, needs upgrading to per pixel detection or oct-trees
		if(getCentreX()>=other.getX() && (getCentreX()<=other.getX()+other.getWidth()))
		{
			if(getCentreY()>=other.getY() && (getCentreY()<=other.getY()+other.getHeight()))
			{
				if(getCentreZ()>=other.getZ() && (getCentreZ()<=other.getZ()+other.getDepth()))
				{
					return true;
				}
			}
		}
		return false;
	}


}
