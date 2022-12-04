package br.com.supermercado.marcel.main;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Aplicacao extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {

		FlowPane flowPaneLoteItem = new FlowPane();
		URL fxmlUrlTelaLoteItem = this.getClass().getClassLoader().getResource("br/com/supermercado/marcel/telas/TelaLoteItem.fxml");
		flowPaneLoteItem = FXMLLoader.<FlowPane>load(fxmlUrlTelaLoteItem);

		Scene minhaCena = new Scene(flowPaneLoteItem);
		primaryStage.setScene(minhaCena);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
