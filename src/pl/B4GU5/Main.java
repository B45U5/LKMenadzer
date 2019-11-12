package pl.B4GU5;
	
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
        Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println("Handler caught exception: "+throwable.getMessage());
        	errorDialog(throwable.getMessage());
        });
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("controllers/main.fxml"));
		    Scene scene = new Scene(loader.load(), 840, 474);
		    primaryStage.setTitle("LKMenedżer");
		    primaryStage.setMinHeight(320);
            primaryStage.setMinWidth(640);
		    primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("icon.png")));
		    primaryStage.setScene(scene);
		    primaryStage.show();
		    primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
		        @Override
		        public void handle(WindowEvent t) {
		            Platform.exit();
		            System.exit(0);
		        }
		    });
		    
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		settings.loadSettings();
		launch(args);
	}
	
	private static void errorDialog(String exceptionText) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Exception Dialog");
		alert.setHeaderText("");
		alert.setContentText("");

		Label label = new Label("The exception stacktrace was:");

		TextArea textArea = new TextArea(exceptionText);
		textArea.setEditable(false);
		textArea.setWrapText(true);

		textArea.setMaxWidth(Double.MAX_VALUE);
		textArea.setMaxHeight(Double.MAX_VALUE);
		GridPane.setVgrow(textArea, Priority.ALWAYS);
		GridPane.setHgrow(textArea, Priority.ALWAYS);

		GridPane expContent = new GridPane();
		expContent.setMaxWidth(Double.MAX_VALUE);
		expContent.add(label, 0, 0);
		expContent.add(textArea, 0, 1);

		alert.getDialogPane().setExpandableContent(expContent);

		alert.showAndWait();
	}
}
