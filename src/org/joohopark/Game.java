package org.joohopark;

import org.joohopark.Assets.Tiles;
import org.joohopark.Util.Clock;
import org.joohopark.World.World;

public class Game {

    World map;
	Clock clock;
	
	boolean isRunning;
	
	public Game(String mapName){
		
		init(mapName);
		run();
		
	}
	
	public void init(String mapName){

		map = new World(mapName);
		clock = new Clock();

		Tiles.init();

		isRunning = true;
		
	}
	
	public void run(){
		while(isRunning){
			if(clock.timer()){
				update();
			}
		}
	}
	
	public void update(){
		
	}
	
	public static void main(String[] args) {
		new Launcher();
	}

}
