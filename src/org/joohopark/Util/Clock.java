package org.joohopark.Util;

public class Clock {
	
    private int ticks;
    private long lastUpdate,
    			 now,
                 lastTimer;
    private double delta;
    private static double nsPerTick = 1000000000D / 60D;
    
    public Clock(){
    	
        this.ticks = 0;
        this.lastUpdate = System.nanoTime();
        this.lastTimer = System.currentTimeMillis();
        this.delta = 0f;
        
    }
    
    public boolean timer(){

        now = System.nanoTime();
        delta += (now - lastUpdate) / nsPerTick;
        lastUpdate = now;
        boolean shouldRender = false;
        
        if(delta >= 1){
        	tick();
        	delta--;
        	shouldRender = true;
        }
        
        
        if (System.currentTimeMillis() - lastTimer > 1000){
      	  	System.out.println("ticks: "+ ticks);
      	  	lastTimer += 1000;
      	  	ticks = 0;
        }
        
        return shouldRender;
    }
    
    private void tick(){
        ticks++;
    }
    
    public static final float getTime(){
        return (System.nanoTime() / 1000000L);
    }
    
}
