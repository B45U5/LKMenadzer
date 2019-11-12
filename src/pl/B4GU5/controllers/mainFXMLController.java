package pl.B4GU5.controllers;

import java.text.DecimalFormat;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSlider;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import pl.B4GU5.XmlReader;
import pl.B4GU5.getHandler;
import pl.B4GU5.settings;
import pl.B4GU5.Logger;

public class mainFXMLController {
	@FXML
	private Label a0;
	@FXML
	private Label a1;
	@FXML
	private Label a2;
	@FXML
	private Label a3;
	@FXML
	private Label b0;
	@FXML
	private Label b1;
	@FXML
	private Label b2;
	@FXML
	private Label b3;
	@FXML
	private Label b4;
	@FXML
	private Label b5;
	@FXML
	private Label b6;
	@FXML
	private Label b7;
	@FXML
	private Label b8;
	@FXML
	private Label b9;
	@FXML
	private Label b10;
	@FXML
	private Label b11;
	@FXML
	private Label b12;
	@FXML
	private Label b13;
	@FXML
	private Label b14;
	@FXML
	private Label b15;
	@FXML
	private Label b16;
	@FXML
	private Label b17;
	@FXML
	private Label b18;
	@FXML
	private Label b19;
	@FXML
	private Label b20;
	@FXML
	private Label b21;
	@FXML
	private Label b22;
	@FXML
	private Label b23;
	@FXML
	private Label b24;
	@FXML
	private Label b25;
	@FXML
	private Label b26;
	@FXML
	private Label b27;
	@FXML
	private Label b28;
	@FXML
	private Label b29;
	@FXML
	private Label r0;
	@FXML
	private Label r1;
	@FXML
	private Label r2;
	@FXML
	private Label r3;
	@FXML
	private Label r4;
	@FXML
	private Label e0;
	@FXML
	private Label e1;
	@FXML
	private Label e2;
	@FXML
	private Label e3;
	@FXML
	private Label e4;
	@FXML
	private Label ds;
	@FXML
	private Circle status;
	@FXML
	private Label statusLabel;
	@FXML
	private Label workingLabel;
	@FXML
	private JFXSpinner workingLoader;
	@FXML
	private StackPane stackpane;
	@FXML
	private AnchorPane anchorpane;
	@FXML
	private AnchorPane dialogPane;
	@FXML
	private JFXCheckBox out0;
	@FXML
	private JFXCheckBox out1;
	@FXML
	private JFXCheckBox out2;
	@FXML
	private JFXCheckBox out3;
	@FXML
	private JFXCheckBox out4;
	@FXML
	private JFXCheckBox out5;
	@FXML
	private JFXCheckBox pwm0;
	@FXML
	private JFXCheckBox pwm1;
	@FXML
	private JFXCheckBox pwm2;
	@FXML
	private JFXCheckBox pwm3;
	@FXML
	private JFXTextField hostName;
	@FXML
	private JFXTextField hostIP;
	@FXML
	private JFXTextField hostPort;
	@FXML
	private JFXTextField hostUsername;
	@FXML
	private JFXPasswordField hostPassword;
	@FXML
	private Label t1name;
	@FXML
	private Label t2name;
	@FXML
	private Label t3name;
	@FXML
	private Label t4name;
	@FXML
	private Label t5name;
	@FXML
	private Label t6name;
	@FXML
	private Label t7name;
	@FXML
	private Label t8name;
	@FXML
	private Label t9name;
	@FXML
	private Label t1temp;
	@FXML
	private Label t2temp;
	@FXML
	private Label t3temp;
	@FXML
	private Label t4temp;
	@FXML
	private Label t5temp;
	@FXML
	private Label t6temp;
	@FXML
	private Label t7temp;
	@FXML
	private Label t8temp;
	@FXML
	private Label t9temp;
	@FXML
	private Label h1name;
	@FXML
	private Label p1name;
	@FXML
	private Label h1value;
	@FXML
	private Label p1value;
	@FXML
	private JFXSlider pwm0slider;
	@FXML
	private JFXSlider pwm1slider;
	@FXML
	private JFXSlider pwm2slider;
	@FXML
	private JFXSlider pwm3slider;
	@FXML
	private JFXListView<String> deviceList;
	@FXML
	private Label nameLabel;
	@FXML
	private JFXTextField nameField;
	@FXML
	private AnchorPane editDialogPane;
	@FXML
	private JFXTextField out0fr;
	@FXML
	private JFXTextField out1fr;
	
    @FXML
    public void initialize() {
    	hostIP.setText(settings.getHost());
    	hostPort.setText(Integer.toString(settings.getPort()));
    	hostUsername.setText(settings.getUsername());
    	hostPassword.setText(settings.getPassword());
    	hostName.setText(settings.getDeviceName());
    }
	
	
	    @FXML
	    protected void cliBtn(ActionEvent event) {
    		showDialog("Uwaga!", "Najpierw siê po³¹cz z urz¹dzeniem!\nZ urz¹dzeniem po³¹czysz siê klikaj¹c w przycisk 'Po³¹cz'");
	    }
		@FXML
	    protected void connectBtn(ActionEvent event) {
	    	showConnectDialog();
	    }
		Thread thread;
	    private void runThread() {
	    	thread = new Thread(new Runnable(){
	            @Override
	            public void run() {

	            	while(true) {
	            		working(true, "");
	            		try {
							Thread.sleep(5000);
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
	            		working(false, "Synchronizacja danych ...");
	            		Logger.info("Synchronizacja danych ...");
	        	    	String host = settings.getHost();
	        	    	int port = settings.getPort();
	            		getHandler connection = new getHandler();
	            		Boolean Status = connection.checkConnetion(host, port);
	            		try {
							Thread.sleep(500);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	            		Platform.runLater(new Runnable() {
	            			@Override public void run() {
	            				if (Status) {
	            					settings.setConnected(true);
	            					statusLabel.setText("Po³¹czono z '" + host + ":" + port + "'");
	            					status.setFill(Color.web("#52e809"));
	            					updateCheckboxes();
	            					updateSensors();
	            					updateSliders();
	            					updatePWMFreq();
	            					Logger.info("Zakoñczono! Po³¹czono z '" + host + ":" + port + "'");
	            				} else {
	            					settings.setConnected(false);
	            					statusLabel.setText("Brak po³¹czenia");
	            					status.setFill(Color.web("#ea3109"));
	            					Logger.info("Zakoñczono! Brak po³¹czenia.");
	            				}
	            			}
	            		});
	            		
	            	}
	            }
	    	});
	    	
	    	thread.start();
	 
	    }
	    
	    private void showConnectDialog() {
	    	dialogPane.setVisible(true);
	        BoxBlur blur = new BoxBlur(5, 5, 5);
	        anchorpane.setEffect(blur);

	    }
	    int idEdit;
	    private void showEditDialog(int id) {
	    	switch(id) {
	    		case(1):
	    			nameLabel.setText(t1name.getText() + " - DS1");
	    			break;
	    		case(2):
	    			nameLabel.setText(t2name.getText() + " - DS2");
	    			break;
	    		case(3):
	    			nameLabel.setText(t3name.getText() + " - DS3");
	    			break;
	    		case(4):
	    			nameLabel.setText(t4name.getText() + " - DS4");
	    			break;
	    		case(5):
	    			nameLabel.setText(t5name.getText() + " - DS5");
	    			break;
	    		case(6):
	    			nameLabel.setText(t6name.getText() + " - DS6");
	    			break;
	    		case(7):
	    			nameLabel.setText(t7name.getText() + " - DS7");
	    			break;
	    		case(8):
	    			nameLabel.setText(t8name.getText() + " - DS8");
	    			break;
	    		case(9):
	    			nameLabel.setText(t8name.getText() + " - T1");
	    			break;
	    		case(10):
	    			nameLabel.setText(h1name.getText() + " - H1");
	    			break;
	    		case(11):
	    			nameLabel.setText(p1name.getText() + " - P1");
	    			break;
	    	}
	    	idEdit = id;
	    	editDialogPane.setVisible(true);
	        BoxBlur blur = new BoxBlur(5, 5, 5);
	        anchorpane.setEffect(blur);

	    }
	    @FXML
	    protected void cancelDialogBtn(ActionEvent event) {
	    	dialogPane.setVisible(false);
	    	anchorpane.setEffect(null);
	    }
	    @FXML
	    protected void connectDialogBtn(ActionEvent event) {
	    	working(false, "Synchronizacja danych ...");
	        settings.setHost(hostIP.getText());
	        settings.setPort(Integer.parseInt(hostPort.getText()));
	        settings.setUsername(hostUsername.getText());
	        settings.setPassword(hostPassword.getText());
	        
	        if (!hostName.getText().isEmpty()) {
	        	if (deviceList.getItems().contains(hostName.getText())) {
		    		showDialog("Uwaga!", "Takie urz¹dzenia znajduje siê ju¿ na liœcie!");
	        	} else {
	        		deviceList.getItems().add(hostName.getText());
	        	}
	        	
	        }
	        
	    	if (thread == null || !thread.isAlive()) runThread();
	      
	        dialogPane.setVisible(false);
	    	anchorpane.setEffect(null);
	    }
	    
	    @FXML
	    protected void cancelEditMode(ActionEvent event) {
	    	editDialogPane.setVisible(false);
	    	anchorpane.setEffect(null);
	    }
	    @FXML
	    protected void exitEditMode(ActionEvent event) {
	    	switch(idEdit) {
    			case(1):
	    			t1name.setText(nameField.getText());
	    			break;
	    		case(2):
	    			t2name.setText(nameField.getText());
	    			break;
	    		case(3):
	    			t3name.setText(nameField.getText());
	    			break;
	    		case(4):
	    			t4name.setText(nameField.getText());
	    			break;
	    		case(5):
	    			t5name.setText(nameField.getText());
	    			break;
	    		case(6):
	    			t6name.setText(nameField.getText());
	    			break;
	    		case(7):
	    			t7name.setText(nameField.getText());
	    			break;
	    		case(8):
	    			t8name.setText(nameField.getText());
	    			break;
	    		case(9):
	    			t9name.setText(nameField.getText());
	    			break;
	    		case(10):
	    			h1name.setText(nameField.getText());
	    			break;
	    		case(11):
	    			p1name.setText(nameField.getText());
	    			break;
	    	}
	    	editDialogPane.setVisible(false);
	    	anchorpane.setEffect(null);
	    }
	    @FXML
	    protected void editNameDS1(ActionEvent event) {
	    	showEditDialog(1);
	    }
	    @FXML
	    protected void editNameDS2(ActionEvent event) {
	    	showEditDialog(2);
	    }
	    @FXML
	    protected void editNameDS3(ActionEvent event) {
	    	showEditDialog(3);
	    }
	    @FXML
	    protected void editNameDS4(ActionEvent event) {
	    	showEditDialog(4);
	    }
	    @FXML
	    protected void editNameDS5(ActionEvent event) {
	    	showEditDialog(5);
	    }
	    @FXML
	    protected void editNameDS6(ActionEvent event) {
	    	showEditDialog(6);
	    }
	    @FXML
	    protected void editNameDS7(ActionEvent event) {
	    	showEditDialog(7);
	    }
	    @FXML
	    protected void editNameDS8(ActionEvent event) {
	    	showEditDialog(8);
	    }
	    @FXML
	    protected void editNameT1(ActionEvent event) {
	    	showEditDialog(9);
	    }
	    @FXML
	    protected void editNameH1(ActionEvent event) {
	    	showEditDialog(10);
	    }
	    @FXML
	    protected void editNameP1(ActionEvent event) {
	    	showEditDialog(11);
	    }
	    
	    getHandler gethandler = new getHandler();
	    DecimalFormat df = new DecimalFormat("###");
	    @FXML
	    protected void pwm0slider(MouseEvent e) {
	    	String pwm = df.format(pwm0slider.getValue());
	    	gethandler.sendPwmSlider(0, Integer.parseInt(pwm));
	    	updateSliders();
	    }
	    @FXML
	    protected void pwm1slider(MouseEvent e) {
	    	String pwm = df.format(pwm1slider.getValue());
	    	gethandler.sendPwmSlider(1, Integer.parseInt(pwm));
	    	updateSliders();
	    }
	    @FXML
	    protected void pwm2slider(MouseEvent e) {
	    	String pwm = df.format(pwm2slider.getValue());
	    	gethandler.sendPwmSlider(2, Integer.parseInt(pwm));
	    	updateSliders();
	    }
	    @FXML
	    protected void pwm3slider(MouseEvent e) {
	    	String pwm = df.format(pwm3slider.getValue());
	    	gethandler.sendPwmSlider(3, Integer.parseInt(pwm));
	    	updateSliders();
	    }
	    private void working(Boolean Disabled, String txt) {
    		Platform.runLater(new Runnable() {
    			@Override public void run() {
    		    	if (Disabled) {
    		    		workingLabel.setText("");
    		    		workingLoader.setVisible(false);
    		    		workingLabel.setVisible(false);
    		    	} else {
    		    		workingLabel.setText(txt);
    		    		workingLoader.setVisible(true);
    		    		workingLabel.setVisible(true);
    		    	}
    			}
    		});
	    }
	    
	    @FXML
	    protected void out0(ActionEvent event) {
	    	gethandler.sendOut(0);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void out1(ActionEvent event) {
	    	gethandler.sendOut(1);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void out2(ActionEvent event) {
	    	gethandler.sendOut(2);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void out3(ActionEvent event) {
	    	gethandler.sendOut(3);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void out4(ActionEvent event) {
	    	gethandler.sendOut(4);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void out5(ActionEvent event) {
	    	gethandler.sendOut(5);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void pwm0(ActionEvent event) {
	    	gethandler.sendPwm(0);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void pwm1(ActionEvent event) {
	    	gethandler.sendPwm(1);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void pwm2(ActionEvent event) {
	    	gethandler.sendPwm(2);
	    	updateCheckboxes();
	    }
	    @FXML
	    protected void pwm3(ActionEvent event) {
	    	gethandler.sendPwm(3);
	    	updateCheckboxes();
	    }
	    
	    @FXML
	    protected void readBtn(ActionEvent event) {
		   //System.out.println("Btn(READBTN):#CLICKED!");
		   updateCheckboxes();
		   updateSensors();
		   updateSliders();
		   updatePWMFreq();
	    }
	    private void updateCheckboxes() {
	    	if(settings.isConnected()) {
		    	Thread thread = new Thread(new Runnable(){
		            @Override
		            public void run() {
		            	XmlReader xml = new XmlReader();
		            	Boolean out0val = (xml.getOutStatus(0) == 1);
		            	Boolean out1val = (xml.getOutStatus(1) == 1);
		            	Boolean out2val = (xml.getOutStatus(2) == 1);
		            	Boolean out3val = (xml.getOutStatus(3) == 1);
		            	Boolean out4val = (xml.getOutStatus(4) == 1);
		            	Boolean out5val = (xml.getOutStatus(5) == 1);
		            	Boolean pwm0val = (xml.getPWMStatus(0) == 1);
		            	Boolean pwm1val = (xml.getPWMStatus(1) == 1);
		            	Boolean pwm2val = (xml.getPWMStatus(2) == 1);
		            	Boolean pwm3val = (xml.getPWMStatus(3) == 1);
		        		Platform.runLater(new Runnable() {
		        			@Override public void run() {
						    	
						    	out0.setSelected(out0val);
								out1.setSelected(out1val);
								out2.setSelected(out2val);
								out3.setSelected(out3val);
								out4.setSelected(out4val);
								out5.setSelected(out5val);
								pwm0.setSelected(pwm0val);
								pwm1.setSelected(pwm1val);
								pwm2.setSelected(pwm2val);
								pwm3.setSelected(pwm3val);
		        			}
		        		});
		            }
		    	});
		    	thread.start();
	    	} else {
	    		showDialog("Uwaga!", "Najpierw siê po³¹cz z urz¹dzeniem!\nZ urz¹dzeniem po³¹czysz siê klikaj¹c w przycisk 'Po³¹cz'");
	    	}
	    }
	    private void updateSliders() {
	    	if(settings.isConnected()) {
		    	Thread thread = new Thread(new Runnable(){
		            @Override
		            public void run() {
		            	XmlReader xml = new XmlReader();
		            	int pwm0val = xml.getPWMSliders(0);
		            	int pwm1val = xml.getPWMSliders(1);
		            	int pwm2val = xml.getPWMSliders(2);
		            	int pwm3val = xml.getPWMSliders(3);
		        		Platform.runLater(new Runnable() {
		        			@Override public void run() {
						    	
						    	pwm0slider.setValue(pwm0val);
						    	pwm1slider.setValue(pwm1val);
						    	pwm2slider.setValue(pwm2val);
						    	pwm3slider.setValue(pwm3val);
		        			}
		        		});
		            }
		    	});
		    	thread.start();
	    	} else {
	    		showDialog("Uwaga!", "Najpierw siê po³¹cz z urz¹dzeniem!\nZ urz¹dzeniem po³¹czysz siê klikaj¹c w przycisk 'Po³¹cz'");
	    	}
					    
	    }
	    private void updatePWMFreq() {
	    	if(settings.isConnected()) {
		    	Thread thread = new Thread(new Runnable(){
		            @Override
		            public void run() {
		            	XmlReader xml = new XmlReader();
		            	int pwm0val = xml.getPWMfreq(0);
		            	int pwm1val = xml.getPWMfreq(1);
		        		Platform.runLater(new Runnable() {
		        			@Override public void run() {
						    	out0fr.setText(Integer.toString(pwm0val));
						    	out1fr.setText(Integer.toString(pwm1val));
		        			}
		        		});
		            }
		    	});
		    	thread.start();
	    	} else {
	    		showDialog("Uwaga!", "Najpierw siê po³¹cz z urz¹dzeniem!\nZ urz¹dzeniem po³¹czysz siê klikaj¹c w przycisk 'Po³¹cz'");
	    	}
					    
	    }
	    private void updateSensors() {
	    	if(settings.isConnected()) {
		    	Thread thread = new Thread(new Runnable(){
		            @Override
		            public void run() {
		            	XmlReader xml = new XmlReader();
		            	String ds1val = xml.getSensorsValues("ds1");
		            	String ds2val = xml.getSensorsValues("ds2");
		            	String ds3val = xml.getSensorsValues("ds3");
		            	String ds4val = xml.getSensorsValues("ds4");
		            	String ds5val = xml.getSensorsValues("ds5");
		            	String ds6val = xml.getSensorsValues("ds6");
		            	String ds7val = xml.getSensorsValues("ds7");
		            	String ds8val = xml.getSensorsValues("ds8");
		            	String dth0val = xml.getSensorsValues("dth0");
		            	String dth1val = xml.getSensorsValues("dth1");
		            	String bmp280pval = xml.getSensorsValues("bm280p");
		            	
		        		Platform.runLater(new Runnable() {
		        			@Override public void run() {
						    	
						    	t1temp.setText(ds1val);
						    	t2temp.setText(ds2val);
						    	t3temp.setText(ds3val);
						    	t4temp.setText(ds4val);
						    	t5temp.setText(ds5val);
						    	t6temp.setText(ds6val);
						    	t7temp.setText(ds7val);
						    	t8temp.setText(ds8val);
						    	t9temp.setText(dth0val);
						    	h1value.setText(dth1val);
						    	p1value.setText(bmp280pval);
		        			}
		        		});
		            }
		    	});
		    	thread.start();
	    	} else {
	    		showDialog("Uwaga!", "Najpierw siê po³¹cz z urz¹dzeniem!\nZ urz¹dzeniem po³¹czysz siê klikaj¹c w przycisk 'Po³¹cz'");
	    	}

	    }
	    
    	boolean more = false;
	    public void showDialog(String header, String body) {
	    	if(!more) {
		    	BoxBlur blur = new BoxBlur(5, 5, 5);
		    	JFXDialogLayout content = new JFXDialogLayout();
		    	content.setHeading(new Text(header));
		    	content.setBody(new Text(body));
		    	StackPane stackPane = new StackPane();
		    	stackPane.autosize();
		    	JFXDialog dialog = new JFXDialog(stackpane, content, JFXDialog.DialogTransition.TOP, true);
		    	JFXButton button = new JFXButton("Ok");
		    	button.setOnAction(new EventHandler<ActionEvent>() {
		    		@Override
		    		public void handle(ActionEvent event) {
		    			dialog.close();
		    		}
		    	});
		    	dialog.setOnDialogClosed((JFXDialogEvent e1) -> {
	    			anchorpane.setEffect(null);
	    			more = false;
		    	});
		    	button.setButtonType(com.jfoenix.controls.JFXButton.ButtonType.RAISED);
		    	button.setPrefHeight(32);
		    	button.setPrefWidth(128);
		    	content.setActions(button);
		    	anchorpane.setEffect(blur);
		    	more = true;
		    	dialog.show();
	    	}
	    }
}
