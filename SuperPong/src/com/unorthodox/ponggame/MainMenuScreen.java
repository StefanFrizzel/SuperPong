package com.unorthodox.ponggame;

import java.util.List;

import com.unorthodox.framework.Game;
import com.unorthodox.framework.Graphics;
import com.unorthodox.framework.Screen;
import com.unorthodox.framework.Input.TouchEvent;

public class MainMenuScreen extends Screen {
	public MainMenuScreen(Game game) {
		super(game);
	}

	@Override
	public void update(float deltaTime) 
	{
		Graphics g = game.getGraphics();
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) 
			{
				
					game.setScreen(new GameScreen(game));
				
			}
		}
	}

	private boolean inBounds(TouchEvent event, int x, int y, float f,
			float g) {
		if (event.x > x && event.x < x + f - 1 && event.y > y
				&& event.y < y + g - 1)
			return true;
		else
			return false;
	}

	@Override
	public void paint(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawImage(Assets.menu, 0, 0);
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
        android.os.Process.killProcess(android.os.Process.myPid());

	}
}
