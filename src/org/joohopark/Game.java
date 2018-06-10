package org.joohopark;

import org.joohopark.Util.Clock;
import org.joohopark.World.World;

public class Game {

    World map;
	Clock clock;
	
	boolean isRunning;
	
	public Game(String mapName){

		map = new World(mapName);
		clock = new Clock();
		
		init();
		run();
		
	}
	
	public void init(){
		
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
