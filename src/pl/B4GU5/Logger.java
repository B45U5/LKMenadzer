package pl.B4GU5;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	private static String data() {
		SimpleDateFormat format = new SimpleDateFormat("[dd.MM.yyyy][HH:mm]");
		Date data = new Date();
		return format.format(data);
	}

	public static String info(String str) {
		String ret = "[Log]" + data() + "[INFO] " + str;
		System.out.println(ret);
		return ret;
	}
	public static String warn(String str) {
		String ret = "[Log]" + data() + "[WARN] " + str;
		System.out.println(ret);
		return ret;
	}
	public static String error(String str) {
		String ret = "[Log]" + data() + "[ERROR] " + str;
		System.out.println(ret);
		return ret;
	}
}
