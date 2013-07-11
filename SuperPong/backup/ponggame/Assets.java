package com.unorthodox.ponggame;

import com.unorthodox.framework.Image;
import com.unorthodox.framework.Music;
import com.unorthodox.framework.Sound;

public class Assets {
	
	public static Image menu, splash, background, stick1, stick2, ball;
	//public static Image menu, splash, background, character, character2, character3, heliboy, heliboy2, heliboy3, heliboy4, heliboy5;
	//public static Image tiledirt, tilegrassTop, tilegrassBot, tilegrassLeft, tilegrassRight, characterJump, characterDown;
	
	public static Sound click,ballBounce;
	public static Music theme;
	
	public static void load(PongGame pongGame) {
		// TODO Auto-generated method stub
		theme = pongGame.getAudio().createMusic("music.mp3");
		theme.setLooping(true);
		theme.setVolume(0.3f);
		theme.play();
	}
	
}
