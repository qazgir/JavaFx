import java.net.*;
import java.util.*;
import com.google.gson.*;

public class PolioImmune {
    public static void main(String[] args) {
        String s = "http://apps.who.int/gho/athena/data/GHO/WHS4_544.json?profile=simple&filter=YEAR:1980";
        URL url = null;
        try {
            url = new URL(s);
        } catch (Exception e) {
            System.out.println("Improper URL " + s);
            System.exit(-1);
        }
     
        // read from the URL
        Scanner scan = null;
        try {
            scan = new Scanner(url.openStream());
        } catch (Exception e) {
            System.out.println("Could not connect to " + s);
            System.exit(-1);
        }
        
        String str = new String();
        while (scan.hasNext()) {
            str += scan.nextLine() + "\n";
        }
        scan.close();

        Gson gson = new Gson();
        DataPoint[] data = gson.fromJson(str, DataPoint.class);
        
        String output = "";
        for(DataPoint d : data){
            output += d.toString();
            output += "\n";
        }
        System.out.println(output);
    }
}
