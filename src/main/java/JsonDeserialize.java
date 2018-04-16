import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.FileReader;

public class JsonDeserialize {

    public static void main(String[] args) {
        try {

            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(new FileReader(new File("src/main/resources/linux.json")));
            if (jsonElement.isJsonObject()) {
                JsonObject jsonObject = jsonElement.getAsJsonObject().getAsJsonObject("Variables");
                JsonObject jsonLinux = jsonObject.getAsJsonObject("Linux");
                String linuxHost = jsonLinux.get("Host").getAsString();
                String linuxPassword = jsonLinux.get("Password").getAsString();
                JsonObject jsonArgs = jsonObject.getAsJsonObject("Alpr");
                String arg1 = jsonArgs.get("Configuration").getAsString();
                String arg2 = jsonArgs.get("Path").getAsString();

                System.out.print(linuxHost + " " + linuxPassword + " "
                        + arg1 + " " + arg2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
