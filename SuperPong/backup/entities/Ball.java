/**
 * 
 */
package com.unorthodox.ponggame.entities;

import com.unorthodox.framework.Game;
import com.unorthodox.ponggame.Assets;
import com.unorthodox.ponggame.GameScreen;

/**
 * @author stefa_000
 *
 */
public class Ball extends AbstractEntity
{
	int maxX,maxY, maxZ;
	GameScreen gameScreen;
	Game game;
	
	public Ball(int x,int y,int z,int width, int height, int depth, GameScreen gameScreen, Game game)
	{
		
		super( x, y, z, width,  height,  depth);
		maxX = (int) game.getGraphics().getWidth();
		maxY = (int) game.getGraphics().getHeight();
		maxZ = 0;
		this.game = game;
		this.gameScreen = gameScreen;
	}
	
	
	
	
	
	@Override
	public void update(float deltaTime) 
	{
		if(x<0 && dx<0)
		{
			dx *= -1;
		}else if(x+width>maxX && dx>0)
		{
			dx *= -1;
		}else if(this.collidesWith(gameScreen.player1) && dx<0)
		{
			dx *= -1;
			Assets.ballBounce.play(1);
		}else if(this.collidesWith(gameScreen.player2) && dx>0)
		{
			dx *= -1;
			Assets.ballBounce.play(1);
		}
		
		if(y<0 && dy<0)
		{
			dy *= -1;
		}else if(y+height>maxY && dy>0)
		{
			dy *= -1;
		}
		
		if(z<0 && dz<0)
		{
			dz *= -1;
		}else if(z+depth>maxZ && dz>0)
		{
			dz *= -1;
		}
		super.update(deltaTime);
	}




	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	

}
