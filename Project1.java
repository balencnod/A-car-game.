package Project1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Project1 extends Application{

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("赛车小游戏");
        GridPane pane = new GridPane();
        AnchorPane _pane = new AnchorPane();
        Scene scene = new Scene(_pane,800,700);
        stage.setScene(scene);
        
        //声明小车
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Car car3 = new Car(3);
        Car car4 = new Car(4);
        
        //加框架
        car1.getFrame(_pane);
        car2.getFrame(_pane);
        car3.getFrame(_pane);
        car4.getFrame(_pane);

        _pane.getChildren().add(pane);
        
        //初始化小车
        car1.init(_pane);
        car2.init(_pane);
        car3.init(_pane);
        car4.init(_pane);
        
        //输入速度
        car1.intiSpeed(pane);
        car2.intiSpeed(pane);
        car3.intiSpeed(pane);
        car4.intiSpeed(pane);
        
        //小车开始运行，创建按钮以开始
        Button button = new Button("Start!");
		GridPane.setConstraints(button, 5, 0);
        pane.getChildren().add(button);
        button.setOnAction(new EventHandler<ActionEvent>(){
    		@Override
    		public void handle(ActionEvent e) {
    			//获取框内速度，转化为整形赋给speed，在开始小车动画
    			car1.speed = 1000*(Integer.parseInt(car1.CarSpeed.getText().trim()));
    			car1.startCar();
    			
    			car2.speed = 1000*(Integer.parseInt(car2.CarSpeed.getText().trim()));
    			car2.startCar();
    			
    			car3.speed = 1000*(Integer.parseInt(car3.CarSpeed.getText().trim()));
    			car3.startCar();
    			
    			car4.speed = 1000*(Integer.parseInt(car4.CarSpeed.getText().trim()));
    			car4.startCar();
    		}
    	});
            
		stage.show();
	}

}
