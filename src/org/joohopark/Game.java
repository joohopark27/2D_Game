package org.joohopark;

import org.joohopark.Assets.Tiles;
import org.joohopark.Util.Clock;
import org.joohopark.World.World;

public class Game {

    private World map;
	private Clock clock;
	
	private boolean isRunning;
	
	public Game(String mapName){
		
		init(mapName);
		run();
		
	}
	
	private void init(String mapName){

		map = new World(mapName);
		clock = new Clock();

		Tiles.init();

		isRunning = true;
		
	}
	
	private void run(){
		while(isRunning){
			if(clock.timer()){
				update();
			}
		}
	}
	
	private void update(){
		
	}
	
	public static void main(String[] args) {
		new Launcher();
	}

}
