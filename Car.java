package Project1;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

public class Car{

	Rectangle frame = new Rectangle();
	int index;
	Circle circleF = new Circle();
	Circle circleL = new Circle();
	Rectangle rectangle = new Rectangle();
	TextField CarSpeed = new TextField();
	int speed;
	Timeline timeline = new Timeline();	
	
	//构造函数，参数为小车序号
	public Car(int i) {
		index = i-1;
	}
	
	//框架，小车的框
	public void getFrame(AnchorPane _pane) {
		frame.setX(50);
		frame.setY(50+160*index);
		frame.setWidth(700);
		frame.setHeight(150);
		frame.setStroke(Color.BLACK);
		frame.setFill(Color.WHITE);
        _pane.getChildren().add(frame);
	}
	
	//画出小车
	public void init(AnchorPane _pane) {
		circleF.setCenterX(70);
		circleF.setCenterY(195+160*index);
		circleF.setRadius(5);
		circleF.setStroke(Color.BLACK);
		circleF.setFill(Color.WHITE);
		circleL.setCenterX(100);
		circleL.setCenterY(195+160*index);
		circleL.setRadius(5);
		circleL.setStroke(Color.BLACK);
		circleL.setFill(Color.WHITE);
		rectangle.setX(60);
        rectangle.setY(180+160*index);
        rectangle.setWidth(50);
        rectangle.setHeight(10);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);
		_pane.getChildren().addAll(circleL,circleF,rectangle);
	}
	
	//添加输入框用于输入速度
	public void intiSpeed(GridPane pane) {
		switch(index) {
		case 1:
	        CarSpeed.setPromptText("Speed of the first car.");
		case 2:
			CarSpeed.setPromptText("Speed of the second car.");
		case 3:
			CarSpeed.setPromptText("Speed of the third car.");
		case 4:
			CarSpeed.setPromptText("Speed of the fourth car.");
		}
        GridPane.setConstraints(CarSpeed, index, 0);
        pane.getChildren().add(CarSpeed);
	}
	
	//创建时间轴动画
	public void startCar() {
		//建造两个关键帧，分别是小车开始与结束
		KeyValue xRec  = new KeyValue(rectangle.xProperty(), 690); 
		KeyValue xCirF  = new KeyValue(circleF.centerXProperty(), 700); 
		KeyValue xCirL  = new KeyValue(circleL.centerXProperty(), 730); 
		KeyFrame keyFrame  = new KeyFrame(Duration.millis(speed), xRec, xCirF, xCirL);
		timeline.setAutoReverse(true); 
		timeline.getKeyFrames().add(keyFrame); 
		timeline.play();
	}
	
}
