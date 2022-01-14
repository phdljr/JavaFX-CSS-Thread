package controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
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
	
	private TimeService timeService;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		btn_start.setOnAction(e -> startTimer(e));
		btn_stop.setOnAction(e -> stopTimer(e));
	}
	
	public void startTimer(ActionEvent e) {
//		isPlay = true;
//		Thread th = new Thread(()->{
//			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
//			while(isPlay) {
//				Platform.runLater(()->lbtimer.setText(sdf.format(new Date()).toString()));
//				try {
//					Thread.sleep(100);
//				} catch (InterruptedException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		//th.setDaemon(true);
//		th.start();
		
		
	}
	
	public void stopTimer(ActionEvent e) {
		
	}
	
	class TimeService extends Service<Integer>{
		@Override
		protected Task<Integer> createTask() {
			Task<Integer> task = new Task<>() {
				@Override
				protected Integer call() throws Exception {
					int result = 0;
					for(int i=0;i<100;i++) {
						if(isCancelled()) {
							break;
						}
						result+=i;
						updateProgress(i, 100);
						updateMessage(String.valueOf(i));
						try {
							Thread.sleep(100);
						}
						catch(InterruptedException e) {
							if(isCancelled()) {
								break;
							}
						}
					}
					return result;
				}
			};
			return task;
		}
		
	}
}
