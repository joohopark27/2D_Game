package org.joohopark;

import java.io.File;

public class Game {

	Clock clock;
	
	boolean isRunning;
	
	public Game(){
		
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
		//new World("TestMap");
		new Launcher();
	}

}
