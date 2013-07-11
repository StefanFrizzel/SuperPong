package com.unorthodox.ponggame;


import java.util.List;


import android.graphics.Color;
import android.graphics.Paint;

import com.unorthodox.framework.Game;
import com.unorthodox.framework.Graphics;
import com.unorthodox.framework.Image;
import com.unorthodox.framework.Screen;
import com.unorthodox.framework.Input.TouchEvent;
import com.unorthodox.ponggame.entities.Ball;
import com.unorthodox.ponggame.entities.Enemy;
import com.unorthodox.ponggame.entities.Player;
import com.unorthodox.ponggame.entities.Stick;

public class GameScreen extends Screen 
{
	enum GameState 
	{
		Ready, Running, Paused, GameOver
	}

	GameState state = GameState.Ready;

	// Variable Setup

	//private static Background background1;
	

	private Image stick1, stick2, ballImage;
	public Player player1,player2;
	public Enemy enemy;
	public Ball ball;
	static Background background;
	Paint paint, paint2;
	public boolean pvp = false;
	public Game game;

	public GameScreen(Game game) 
	{
		super(game);

		this.game = game;
		// Initialize game objects here
		background = new Background(0,0);
		stick1 = Assets.stick1;
		stick2 = Assets.stick2;
		ballImage = Assets.ball;
		
		
		player1 =  new Player(0, 0,0,30, 100, 0);
		player1.setCentreX((int) (game.getGraphics().getWidth()/10));
		player1.setCentreY( (game.getGraphics().getHeight()/2));
		
		
		player2 = new Player(0, 0, 0, 30, 100, 0);
		player2.setCentreX((int) (game.getGraphics().getWidth()*0.9));
		player2.setCentreY( (game.getGraphics().getHeight()/2));
		
		
		
		ball= new Ball(0, 0, 0, 20, 20, 0, this, game);
		ball.setCentreX(game.getGraphics().getWidth()/2);
		ball.setCentreY(game.getGraphics().getHeight()/2);
		ball.setDX(2);
		ball.setDY(2);
		

		enemy = new Enemy(0, 0, 0, 30, 100, 0, this);
		enemy.setCentreX((int) (game.getGraphics().getWidth()*0.9));
		enemy.setCentreY( (game.getGraphics().getHeight()/2));

		loadMap();

		// Defining a paint object
		 paint = new Paint();
		paint.setTextSize(30);
		paint.setTextAlign(Paint.Align.CENTER);
		paint.setAntiAlias(true);
		paint.setColor(Color.RED);

		paint2 = new Paint();
		paint2.setTextSize(100);
		paint2.setTextAlign(Paint.Align.CENTER);
		paint2.setAntiAlias(true);
		paint2.setColor(Color.GREEN);

	}

	private void loadMap() 
	{
		

	}

	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents();

		// We have four separate update methods in this example.
		// Depending on the state of the game, we call different update methods.
		// Refer to Unit 3's code. We did a similar thing without separating the
		// update methods.

		if (state == GameState.Ready)
			updateReady(touchEvents, deltaTime);
		if (state == GameState.Running)
			updateRunning(touchEvents, deltaTime);
		if (state == GameState.Paused)
			updatePaused(touchEvents);
		if (state == GameState.GameOver)
			updateGameOver(touchEvents);
	}

	private void updateReady(List<TouchEvent> touchEvents, float deltaTime) 
	{

		// This example starts with a "Ready" screen.
		// When the user touches the screen, the game begins.
		// state now becomes GameState.Running.
		// Now the updateRunning() method will be called!

		if (touchEvents.size() > 0)
			state = GameState.Running;
		
		ball.update(deltaTime);
		enemy.update(deltaTime);
	}

	private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) 
	{

		// This is identical to the update() method from our Unit 2/3 game.

		// 1. All touch input is handled here:
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DRAGGED) 
			{
				if(event.x<game.getGraphics().getWidth()/5)
				{
					//update stick 1
					player1.setCentreY(event.y);
					
				}else if(event.x>game.getGraphics().getWidth()*0.8 && pvp)
				{
					//update stick 2
					player2.setY(event.y);
				}

			}

			if (event.type == TouchEvent.TOUCH_UP) 
			{

				
			}

			
			
		}

		// 2. Check miscellaneous events like death:

		if (false)//livesLeft == 0) 
		{
			state = GameState.GameOver;
		}

		// 3. Call individual update() methods here.
		// This is where all the game updates happen.
		// For example, robot.update();
		

		
		ball.update(deltaTime);
		enemy.update(deltaTime);

	}

	private boolean inBounds(TouchEvent event, int x, int y, int width,
			int height) {
		if (event.x > x && event.x < x + width - 1 && event.y > y
				&& event.y < y + height - 1)
			return true;
		else
			return false;
	}

	private void updatePaused(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_UP) {
				if (inBounds(event, 0, 0, 800, 240)) {

					if (!inBounds(event, 0, 0, 35, 35)) {
						resume();
					}
				}

				if (inBounds(event, 0, 240, 800, 240)) {
					nullify();
					goToMenu();
				}
			}
		}
	}

	private void updateGameOver(List<TouchEvent> touchEvents) {
		int len = touchEvents.size();
		for (int i = 0; i < len; i++) {
			TouchEvent event = touchEvents.get(i);
			if (event.type == TouchEvent.TOUCH_DOWN) {
				if (inBounds(event, 0, 0, 800, 480)) {
					nullify();
					game.setScreen(new MainMenuScreen(game));
					return;
				}
			}
		}

	}

	

	@Override
	public void paint(float deltaTime) 
	{
		Graphics g = game.getGraphics();

		g.drawImage(Assets.background, 0,0,0,0,g.getWidth(), g.getHeight());//background.getBgX(), background.getBgY());
		
		// First draw the game elements.
		g.drawImage(Assets.ball, (int)ball.getX(),(int) (int)ball.getY(),(int)ball.getWidth(), (int)ball.getHeight());
		g.drawImage(Assets.stick1,(int)player1.getX(), (int)player1.getY(), (int)player1.getWidth(), (int)player1.getHeight());
		if(pvp)
		{
			g.drawImage(Assets.stick2,(int) (int)player2.getX(), (int)player2.getY(), (int)player2.getWidth(),(int) player2.getHeight());
			
		}else
		{
			g.drawImage(Assets.stick2,(int)(int) enemy.getX(), (int)enemy.getY(),(int)enemy.getWidth(), (int)enemy.getHeight());
			
		}
		
		
		// Example:
		// g.drawImage(Assets.background, 0, 0);
		// g.drawImage(Assets.character, characterX, characterY);

		// Secondly, draw the UI above the game elements.
		if (state == GameState.Ready)
			drawReadyUI();
		if (state == GameState.Running)
			drawRunningUI();
		if (state == GameState.Paused)
			drawPausedUI();
		if (state == GameState.GameOver)
			drawGameOverUI();

	}

	

	

	private void nullify() 
	{

		// Set all variables to null. You will be recreating them in the
		// constructor.
		this.background = null;
		this.ballImage = null;
		this.player1 = null;
		this.stick1 = null;
		this.stick2 = null;

		// Call garbage collector to clean up memory.
		System.gc();

	}

	private void drawReadyUI() 
	{
		Graphics g = game.getGraphics();

		g.drawARGB(155, 0, 0, 0);
		g.drawString("Tap to Start.", 400, 240, paint);

	}

	private void drawRunningUI() {
		Graphics g = game.getGraphics();
		
	}

	private void drawPausedUI() {
		Graphics g = game.getGraphics();
		// Darken the entire screen so you can display the Paused screen.
		g.drawARGB(155, 0, 0, 0);
		g.drawString("Resume", 400, 165, paint2);
		g.drawString("Menu", 400, 360, paint2);

	}

	private void drawGameOverUI() {
		Graphics g = game.getGraphics();
		g.drawRect(0, 0, 1281, 801, Color.BLACK);
		g.drawString("GAME OVER.", 400, 240, paint2);
		g.drawString("Tap to return.", 400, 290, paint);

	}

	@Override
	public void pause() {
		if (state == GameState.Running)
			state = GameState.Paused;

	}

	@Override
	public void resume() {
		if (state == GameState.Paused)
			state = GameState.Running;
	}

	@Override
	public void dispose() {

	}

	@Override
	public void backButton() {
		pause();
	}

	private void goToMenu() {
		// TODO Auto-generated method stub
		game.setScreen(new MainMenuScreen(game));

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



	

}