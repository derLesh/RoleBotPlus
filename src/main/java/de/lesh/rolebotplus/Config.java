package de.lesh.rolebotplus;

import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static de.lesh.rolebotplus.Main.jLog;

public class Config {
    private static String TOKEN = null;
    private static int ADMIN_ID;

    static {
        load();
    }

    private static String token;
    private static String admin_id;

    public static void load() {
        try (Scanner s = new Scanner(new File("config.json")).useDelimiter("\\A")) {
            JSONObject config = new JSONObject(s.next());
            token = config.getString("token");
            admin_id = config.getString("admin_id");
        } catch (FileNotFoundException e) {
            jLog.error("Error during loading config", e);
            System.exit(1);
        }
    }

    public static String getAdminId() {
        return admin_id;
    }
    public static String getToken() {
        return token;
    }
}
