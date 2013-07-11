/**
 * 
 */
package com.unorthodox.ponggame.entities;

import com.unorthodox.ponggame.GameScreen;

/**
 * @author stefa_000
 *
 */
public class Enemy extends Player
{

	GameScreen gameScreen;
	Ball ball;
	public Enemy(int x, int y, int z, int width, int height, int depth, GameScreen gameScreen)
	{
		super(x,y,z,width,height,depth);
		this.gameScreen = gameScreen;
		ball = gameScreen.ball;
	}
	
	@Override
	public void update(float deltaTime) 
	{
		// TODO Auto-generated method stub
		super.update(deltaTime);
		
		if(ball.getCentreY()>this.getCentreY())
		{
			dy+=0.5*deltaTime;
		}else
		{
			dy-=0.5*deltaTime;
		}
		
	}

	

}
