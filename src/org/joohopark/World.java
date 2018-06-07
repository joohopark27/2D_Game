package org.joohopark;

public class World {

    public int xLength,
               yLength;
    public int[][] map;

    public World(String path){
        
        String rawData = Util.loadMap(path + ".map");

        String[] data = rawData.split("\\s+");
        xLength = Util.parseInt(data[0]);
        yLength = Util.parseInt(data[1]);
        map = new int[yLength][xLength];

        for(int y = 0; y < yLength; y++){
            for(int x = 0; x < xLength; x++){
                map[y][x] = Util.parseInt(data[2 + x + y*5]);
            }
        }

/*      for(int[] y : map){
            for(int x : y){
                System.out.print(x + " ");
            }
            System.out.println();
        }*/

    }

}
