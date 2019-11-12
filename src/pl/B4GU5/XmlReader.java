package pl.B4GU5;

import java.io.IOException;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlReader {
	String server = "http://" + settings.getHost() + ":" + settings.getPort() + "";
	private Document outs;
	private Document sensors;
	private Document pwms;
	private Document hw;

	getHandler urlhandler = new getHandler();
	public int getOutStatus(int num) {
		
		outs = loadXMLFromString(urlhandler.getOut());
		String outsString = outs.getElementsByTagName("out").item(0).getTextContent();
		String[] splits = outsString.split("");
		switch(num) {
			case(0):
				Logger.info("Wyjœcie 0 (0-Wy³, 1-W³) :: " + splits[0]);
				return(Integer.parseInt(splits[0]));
			case(1):
				Logger.info("Wyjœcie 1 (0-Wy³, 1-W³) :: " + splits[1]);
				return(Integer.parseInt(splits[1]));
			case(2):
				Logger.info("Wyjœcie 2 (0-Wy³, 1-W³) :: " + splits[2]);
				return(Integer.parseInt(splits[2]));
			case(3):
				Logger.info("Wyjœcie 3 (0-Wy³, 1-W³) :: " + splits[3]);
				return(Integer.parseInt(splits[3]));
			case(4):
				Logger.info("Wyjœcie 4 (0-Wy³, 1-W³) :: " + splits[4]);
				return(Integer.parseInt(splits[4]));
			case(5):
				Logger.info("Wyjœcie 5 (0-Wy³, 1-W³) :: " + splits[5]);
				return(Integer.parseInt(splits[5]));
		}
		return 6;
	}
	public int getPWMStatus(int num) {
		pwms = loadXMLFromString(urlhandler.getIX());
		int pwm = Integer.parseInt(pwms.getElementsByTagName("pwm").item(0).getTextContent());
		String pwmString = String.format("%4s", Integer.toBinaryString(pwm)).replace(' ', '0');

		String[] splits = pwmString.split("");
		switch(num) {
			case(0):
				Logger.info("Wyjœcie PWM 0 (0-Wy³, 1-W³) :: " + splits[3]);
				return(Integer.parseInt(splits[3]));
			case(1):
				Logger.info("Wyjœcie PWM 1 (0-Wy³, 1-W³) :: " + splits[2]);
				return(Integer.parseInt(splits[2]));
			case(2):
				Logger.info("Wyjœcie PWM 2 (0-Wy³, 1-W³) :: " + splits[1]);
				return(Integer.parseInt(splits[1]));
			case(3):
				Logger.info("Wyjœcie PWM 3 (0-Wy³, 1-W³) :: " + splits[0]);
				return(Integer.parseInt(splits[0]));
		}
		//System.out.println(outIF);
		return 6;
	}
	public int getPWMSliders(int num) {
		pwms = loadXMLFromString(urlhandler.getStat());

		switch(num) {
			case(0):
				return(Integer.parseInt(pwms.getElementsByTagName("pwmd0").item(0).getTextContent()));
			case(1):
				return(Integer.parseInt(pwms.getElementsByTagName("pwmd1").item(0).getTextContent()));
			case(2):
				return(Integer.parseInt(pwms.getElementsByTagName("pwmd2").item(0).getTextContent()));
			case(3):
				return(Integer.parseInt(pwms.getElementsByTagName("pwmd3").item(0).getTextContent()));
		}
		//System.out.println(outIF);
		return 6;
	}
	public int getPWMfreq(int num) {
		pwms = loadXMLFromString(urlhandler.getStat());

		switch(num) {
			case(0):
				return(Integer.parseInt(pwms.getElementsByTagName("pwmf0").item(0).getTextContent()));
			case(1):
				return(Integer.parseInt(pwms.getElementsByTagName("pwmf1").item(0).getTextContent()));
		}
		//System.out.println(outIF);
		return 6;
	}
	public String getHW() {
		hw = loadXMLFromString(urlhandler.getStat());
		
		if (hw == null) return "false";
		
		//System.out.println(outIF);
		return hw.getElementsByTagName("sname").item(0).getTextContent() + hw.getElementsByTagName("hw").item(0).getTextContent();
	}
	public String getSensorsValues(String sensorName) {
		
		sensors = loadXMLFromString(urlhandler.getIX());
		switch(sensorName) {
			case("ds1"):
				String sensords1 = sensors.getElementsByTagName("ds1").item(0).getTextContent();
				if (sensords1.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords1)/10 + " °C");
			case("ds2"):
				String sensords2 = sensors.getElementsByTagName("ds2").item(0).getTextContent();
				if (sensords2.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords2)/10 + " °C");
			case("ds3"):
				String sensords3 = sensors.getElementsByTagName("ds3").item(0).getTextContent();
				if (sensords3.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords3)/10 + " °C");
			case("ds4"):
				String sensords4 = sensors.getElementsByTagName("ds4").item(0).getTextContent();
				if (sensords4.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords4)/10 + " °C");
			case("ds5"):
				String sensords5 = sensors.getElementsByTagName("ds5").item(0).getTextContent();
				if (sensords5.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords5)/10 + " °C");
			case("ds6"):
				String sensords6 = sensors.getElementsByTagName("ds6").item(0).getTextContent();
				if (sensords6.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords6)/10 + " °C");
			case("ds7"):
				String sensords7 = sensors.getElementsByTagName("ds7").item(0).getTextContent();
				if (sensords7.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords7)/10 + " °C");
			case("ds8"):
				String sensords8 = sensors.getElementsByTagName("ds8").item(0).getTextContent();
				if (sensords8.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensords8)/10 + " °C");
			case("dth0"):
				String sensordth0 = sensors.getElementsByTagName("dth0").item(0).getTextContent();
				if (sensordth0.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensordth0)/10 + " °C");
			case("dth1"):
				String sensordth1 = sensors.getElementsByTagName("dth1").item(0).getTextContent();
				if (sensordth1.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensordth1)/10 + " %");
			case("bm280p"):
				String sensorbm280p = sensors.getElementsByTagName("bm280p").item(0).getTextContent();
				if (sensorbm280p.equals("-600")) {
					return("--------");
				}
				return(Double.parseDouble(sensorbm280p)/100 + " hPa");
		}
		//System.out.println(outIF);
		return "";
	}
	
	//Inne
	public static Document loadXMLFromString(String xml) {
	    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder builder = null;
		try {
			builder = factory.newDocumentBuilder();
			InputSource is = new InputSource(new StringReader(xml));
			return builder.parse(is);
		} catch (SAXException | IOException | ParserConfigurationException e) {
			return null;
		}
	}
}
