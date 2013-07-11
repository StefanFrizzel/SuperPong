package com.unorthodox.ponggame;

import com.unorthodox.framework.Game;
import com.unorthodox.framework.Graphics;
import com.unorthodox.framework.Screen;
import com.unorthodox.framework.Graphics.ImageFormat;

public class LoadingScreen extends Screen 
{

	public LoadingScreen(Game game) 
	{
		
		super(game);
		
	}

	@Override
	public void update(float deltaTime) 
	{
	
		Graphics g = game.getGraphics();
		Assets.menu = g.newImage("menu.png", ImageFormat.RGB565);
		Assets.background = g.newImage("background.png", ImageFormat.RGB565);
		Assets.ball = g.newImage("ball.png", ImageFormat.ARGB4444);
		Assets.stick1 = g.newImage("stick.png", ImageFormat.ARGB4444);
		Assets.stick2 = g.newImage("stick.png", ImageFormat.ARGB4444);
		
		Assets.ballBounce = game.getAudio().createSound("ballBounce.ogg");
		Assets.click = game.getAudio().createSound("blip.ogg");
			
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		game.setScreen(new MainMenuScreen(game));
		
		
		

	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.splash, 0, 0);
	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {

	}
}