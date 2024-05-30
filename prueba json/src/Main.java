import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //escritura del archivo
        Person Orick = new Person("Octavio", 20);
        Person Icon = new Person("Imo", 22);
        Person Gordo = new Person("Luciano", 22);
        Person Titu = new Person("Mateo", 22);

        JSONArray jsonArray = new JSONArray();

        try {
            JSONObject orickObj = new JSONObject();
            orickObj.put("nombre", Orick.getName());
            orickObj.put("edad", Orick.getAge());
            jsonArray.put(orickObj);

            JSONObject iconObj = new JSONObject();
            iconObj.put("nombre", Icon.getName());
            iconObj.put("edad", Icon.getAge());
            jsonArray.put(iconObj);

            JSONObject gordoObj = new JSONObject();
            gordoObj.put("nombre", Gordo.getName());
            gordoObj.put("edad", Gordo.getAge());
            jsonArray.put(gordoObj);

            JSONObject tituObj = new JSONObject();
            tituObj.put("nombre", Titu.getName());
            tituObj.put("edad", Titu.getAge());
            jsonArray.put(tituObj);

            // Supongamos que JSONutils.write escribe en un archivo con el nombre proporcionado
            JSONutils.write(jsonArray, "persons");

        } catch (JSONException e) {
            e.printStackTrace();
        }


        
        //lectura del archivo
        String archivo =JSONutils.read("persons");
        try {
            JSONArray array= new JSONArray(archivo);
            for(int i=0;i< array.length();i++)
            {
                JSONObject aux= array.getJSONObject(i);
                System.out.println(aux.getString("nombre"));
                System.out.println(aux.getInt("edad"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
