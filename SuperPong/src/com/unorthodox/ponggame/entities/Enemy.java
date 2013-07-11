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
		
		super.update(deltaTime);
		if(ball.getCentreX()-gameScreen.player1.getCentreX()>x-ball.getCentreX() && ball.dx>0)
		{
				
			
			//this.setCentreY(ball.y);
			if(ball.getCentreY()>this.getCentreY() && dy<4 && dy>=-0.1)
			{
				
					//dy+=(deltaTime*0.03);
				dy+=0.1;
				
			}else if(ball.getCentreY()<this.getCentreY() && dy>-4 && dy<=0.1)
			{
				
					//dy-=(deltaTime*0.03)-0.1;
				dy-=0.1;
				
			}else
			{
				dy*=0.3;
			}
		}else
		{
			
				dy = ((this.gameScreen.game.getGraphics().getHeight()/2)-this.getCentreY())/100;
			
		}
		
	}

	

}
