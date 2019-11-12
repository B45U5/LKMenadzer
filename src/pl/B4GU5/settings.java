package pl.B4GU5;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class settings {
	static String host = "";
	static int port = 0;
	static String name = "";
	static String username = "";
	static String pass = "";
	static Boolean connected = false;
	
	public static void loadSettings() {
		String sbjs = "";

        try (BufferedReader br = Files.newBufferedReader(Paths.get("settings.json"))) {

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
            	sbjs += line;
            }

        } catch (IOException e) {
        	e.printStackTrace();
        }
        	//System.out.println(sbjs);
			JSONObject obj = new JSONObject(sbjs);
			host = obj.getJSONObject("polaczenie").getString("adresip");
			port = Integer.parseInt(obj.getJSONObject("polaczenie").getString("port"));
			username = obj.getJSONObject("polaczenie").getString("nazwauzytkownika");
			pass = obj.getJSONObject("polaczenie").getString("haslo");
			name = obj.getJSONObject("polaczenie").getString("nazwaurzadzenia");

	}
	
	public static void saveSettings() {
        //TODO
	}
	
	//Pobieranie wartoœci
	public static String getHost( ) {
		return host;
	}
	public static int getPort( ) {
		return port;
	}
	public static String getUsername( ) {
		return username;
	}
	public static String getPassword( ) {
		return pass;
	}
	public static String getDeviceName( ) {
		return name;
	}
	public static Boolean isConnected( ) {
		return connected;
	}

	//Przypisywanie wartoœci
	public static void setHost(String a) {
		host = a;
	}
	public static void setPort(int a) {
		port = a;
	}
	public static void setUsername(String a) {
		username = a;
	}
	public static void setPassword(String a) {
		pass = a;
	}
	public static void setDeviceName(String a) {
		name = a;
	}
	public static void setConnected(Boolean a) {
		connected = a;
	}
}
