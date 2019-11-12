package pl.B4GU5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.Base64;

public class getHandler {
	public boolean checkConnetion(String host, int port) {
	    try (Socket socket = new Socket()) {
	        socket.connect(new InetSocketAddress(host, port), 500);
			XmlReader reader = new XmlReader();
			String hw = reader.getHW();
			if (hw.isEmpty()) return false;
	        if (hw.contains("LK3_controller1.0")) {
	        	return true;
	        } else {
	        	return false;
	        }
	    } catch (IOException e) {
	        return false;
	    }
	}
	public void sendOut(int num) {
		if(settings.isConnected()) {
			getXml("/outs.cgi?out=out" + num);
		}
	}
	public void sendPwm(int num) {
		if(settings.isConnected()) {
			getXml("/outs.cgi?pwm=pwm" + num);
		}
	}
	public void sendPwmSlider(int num, int value) {
		if(settings.isConnected()) {
			getXml("/stm.cgi?pwmd=" + num + "" + value);
		}
	}
	public String getOut() {
		return getXml("/outs.cgi");
	}
	public String getIX() {
		return getXml("/xml/ix.xml");
	}
	public String getStat() {
		return getXml("/xml/stat.xml");
	}
	
	private String getXml(String file) {
		String xml = null;
		try {
			xml = urlhandler(new URL("http://" + settings.getHost() + ":" + settings.getPort() + file));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return xml;
	}	
	private String urlhandler(URL obj) {
		StringBuffer response = new StringBuffer();
		try {
			
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "");
			if (settings.getUsername() != null || settings.getPassword() != null) {
				con.setRequestProperty("Authorization", "Basic " + Base64.getEncoder().encodeToString((settings.getUsername() + ":" + settings.getPassword()).getBytes()));
			}
			int responseCode = con.getResponseCode();
			Logger.info("Kod odpowiedzi GET :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // Sukces
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				Logger.info("Odpowiedz prawid³owa! (" + obj + ")");
			} else {
				Logger.warn("¯¹danie GET nie zadzia³a³o prawid³owo!");
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		return response.toString();
	}
}
