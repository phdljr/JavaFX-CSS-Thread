package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MyController implements Initializable {
	@FXML
	private Label lbtimer;
	@FXML
	private Button btn_start;
	@FXML
	private Button btn_stop;

	private boolean isPlay = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_start.setOnAction(e -> startTimer(e));
		btn_stop.setOnAction(e -> stopTimer(e));
	}
	
	public void startTimer(ActionEvent e) {
		isPlay = true;
		Thread th = new Thread(()->{
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			while(isPlay) {
				Platform.runLater(()->lbtimer.setText(sdf.format(new Date()).toString()));
				try {
					Thread.sleep(100);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		th.setDaemon(true);
		th.start();
	}
	
	public void stopTimer(ActionEvent e) {
		isPlay = false;
	}

}
