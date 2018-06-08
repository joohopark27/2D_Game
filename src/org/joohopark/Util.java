package org.joohopark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Util {

    public static String loadMap (String path){
        String Map = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(path));

            String line;
            while ((line = reader.readLine()) != null) {
                Map += line;
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Map;

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
