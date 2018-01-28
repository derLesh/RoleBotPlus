package de.lesh.rolebotplus;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static de.lesh.rolebotplus.Main.jLog;

public class Config {
    private static String TOKEN = null;

    static {
        load();
    }

    private static String token;

    public static void load() {
        try (Scanner s = new Scanner(new File("config.json")).useDelimiter("\\A")) {
            JSONObject config = new JSONObject(s.next());
            token = config.getString("token");
        } catch (FileNotFoundException e) {
            jLog.error("Error during loading config", e);
            System.exit(1);
        }
    }

    public static String getToken() {
        return token;
    }
}
