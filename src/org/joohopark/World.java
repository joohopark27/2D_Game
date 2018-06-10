package org.joohopark;

public class World {

    private int xLength,
               yLength;
    private int[][] map;

    private String mapName;

    public World(String mapName){

        this.mapName = mapName;
        String rawData = Util.loadMap(mapName);

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
*           for(int x : y){
*               System.out.print(x + " ");
*           }
*           System.out.println();
*       }*/
    }

    public String getMapName(){
        return mapName;
    }

}
