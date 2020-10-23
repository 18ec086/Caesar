
import java.util.Optional;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ChipherApp extends Application{
	TextField tf1,num,result;
	Button btn;
	VBox vb;
	HBox hb1,hb2,hb3,hb4;
	Label label1,label2,label3;
	CaesarChiper a;

	@Override
	public void start(Stage primaryStage) {
		btn=new Button("次へ");
		btn.setOnAction(e->clickedNext());

		tf1 =new TextField();
		result =new TextField();
		num=new TextField();
		num.setPrefSize(40, 20);
		result.setEditable(false);

		label1=new Label("元の文");
		label2=new Label("変換後");
		label3=new Label("文字");

		hb4=new HBox(num,label3);
		hb1=new HBox(30,label1,tf1,hb4);
		hb2=new HBox(30,btn);
		hb2.setAlignment(Pos.CENTER);
		hb3=new HBox(30,label2,result);

		vb=new VBox(hb1,hb2,hb3);
		Scene scene=new Scene(vb,400,100);
		primaryStage.setScene(scene);
        primaryStage.setTitle("CaesarChiperApp");
        primaryStage.show();

	}
	void clickedNext() {
		try {
			String str=tf1.getText();
			String str2;
			String strNum=num.getText();
			a=new CaesarChiper(str);
			str2=a.shiftStr(Integer.parseInt(strNum));
			result.setText(str2);
		}catch(Exception e) {
			Alert alert =new Alert(Alert.AlertType.ERROR,"入力に誤りがあります");
    		Optional opt =alert.showAndWait();
		}

	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Application.launch(args);
        System.out.println("完了--");


	}
}
