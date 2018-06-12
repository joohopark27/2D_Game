package org.joohopark.State;

import org.joohopark.Assets.Tiles;
import org.joohopark.Game;
import org.joohopark.World.World;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class EditorState extends State{

    private Canvas canvas;

    private BufferStrategy bs;
    private Graphics g;

    private World world;

    public EditorState(Game game){
        super(game);
        world = new World(game.getMapName());

        Dimension dimension = new Dimension(screen.getWidth(), screen.getHeight());

        canvas = new Canvas();
        canvas.setPreferredSize(dimension);
        canvas.setMaximumSize(dimension);
        canvas.setMinimumSize(dimension);
        canvas.setFocusable(false);

        screen.add(canvas);
        screen.pack();
    }

    @Override
    public void reset() {

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(){

        bs = canvas.getBufferStrategy();
        if(bs == null){
            canvas.createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();

        g.clearRect(0, 0, screen.getWidth(), screen.getHeight());

        for(int y = 0; y < world.getyLength(); y++){
            for(int x = 0; x < world.getxLength(); x++){
                g.drawImage(Tiles.getTile(world.getMap()[y][x]), x * 10, (y - 4) * 10, 10, 10, null);
            }
        }

        //end drawing
        bs.show();
        g.dispose();

    }
}
