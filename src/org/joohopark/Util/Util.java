package org.joohopark.Util;

import java.io.*;

public class Util {

    public static String loadMap(String mapName){
        return readFile("res/" + mapName + ".map");
    }

    public static String readFile (String path){
        String fileData = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line;
            while ((line = reader.readLine()) != null) {
                fileData += line;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileData;

    }

    public static void saveMap(String mapName,int width, int height, int[][] map){
        String[] data = new String[height + 1];
        data[0] = Integer.toString(width) + " " + Integer.toString(height);
        for(int y = 1; y <= height; y++){
            for(int x = 0; x < width; x++){
                data[y] = Integer.toString(map[y-1][x]) + " ";
            }
        }
        editFile("res/" + mapName + ".map", data);
    }

    public static void editFile(String path, String[] text) {
        try {
            PrintWriter writer = new PrintWriter(new File(path));
            for (String line : text) {
                writer.println(line);
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static int parseInt(String number){
		try{
			return Integer.parseInt(number);
		}catch(NumberFormatException e){
			e.printStackTrace();
			return 0;
		}
	}

}
