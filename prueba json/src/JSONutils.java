import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONutils
{
    public static void write(JSONArray array, String archivo)
    {
        try {
            FileWriter file= new FileWriter(archivo+".json");
            file.write(array.toString());
            file.flush();
            file.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void write(JSONObject object, String arcihvo)
    {
        try{
            FileWriter file= new FileWriter(arcihvo+".json");
            file.write(object.toString());
            file.flush();
            file.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String read(String archivo)
    {
        String content="";
        try{
            content= new String(Files.readString(Paths.get(archivo+".json")));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        return content;
    }
}
