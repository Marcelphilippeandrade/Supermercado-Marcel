package br.com.supermercado.marcel.controller;

import java.time.LocalDate;
import br.com.supermercado.marcel.interfaces.InterfaceCadastro;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import net.synedra.validatorfx.TooltipWrapper;
import net.synedra.validatorfx.Validator;

public class LoteItemController implements InterfaceCadastro {

	@FXML
	private TextField textFildCodigoLote;

	@FXML
	private Button btnLimparLote;

	@FXML
	private Button btnCadastrarLote;

	@FXML
	private FlowPane flowPaneLoteItem;
	
	@FXML
	private AnchorPane anchorPaneLote;
	
	@FXML
	private DatePicker datePikerLote;

	private Validator validator;

	public LoteItemController() {
		this.validator = new Validator();
		this.btnLimparLote = new Button();
		this.btnCadastrarLote = new Button();
		this.textFildCodigoLote = new TextField();
		this.datePikerLote = new DatePicker();
	}

	public void limpar() {
		btnLimparLote.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetTextFildCodigoLote();
			}
		});
	}

	public void cadastrar() {
		
		validator.createCheck()
		.dependsOn("codigo", textFildCodigoLote.textProperty())
		.dependsOn("datePikerLote", datePikerLote.valueProperty()).withMethod(c -> {
			String codigo = c.get("codigo");
			LocalDate dataFabricacaoPikerLote = c.get("datePikerLote");
			if (codigo.isEmpty() && dataFabricacaoPikerLote == null) {
				c.error("O campo código do lote não pode ser vazio.");
				c.error("O campo data de fabricação não pode ser vazio.");
				TooltipWrapper<Button> signUpWrapper = new TooltipWrapper<>(btnCadastrarLote,
						validator.containsErrorsProperty(),
						Bindings.concat("Favor observar os erros:\n", validator.createStringBinding()));
				anchorPaneLote.getChildren().add(signUpWrapper);
			}
		}).decorates(textFildCodigoLote).decorates(datePikerLote).immediate();
		
		
		btnCadastrarLote.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
//				validator.createCheck().dependsOn("codigo", textFildCodigoLote.textProperty()).withMethod(c -> {
//					String codigo = c.get("codigo");
//					if (codigo.isEmpty()) {
//						Tooltip toolTipCodigoLote = tooltipErro("O campo código do lote não pode ser vazio.");
//						c.error(toolTipCodigoLote.getText());
//					}
//				}).decorates(textFildCodigoLote).immediate();
//
//				ValidationMessage messagesErrorTextFildCodigoLote = new ValidationMessage(Severity.ERROR, "O campo código do lote não pode ser vazio.");
//				validationMessages.add(messagesErrorTextFildCodigoLote);
//
//				validator.createCheck().dependsOn("datePikerLote", datePikerLote.valueProperty()).withMethod(c -> {
//					LocalDate dataFabricacaoPikerLote = c.get("datePikerLote");
//					if (dataFabricacaoPikerLote == null) {
//						Tooltip toolTipDataFabricacaoLote = tooltipErro("O campo data fabricação do lote não pode ser vazio.");
//						c.error(toolTipDataFabricacaoLote.getText());
//					}
//				}).decorates(datePikerLote).immediate();
//
//				ValidationMessage messagesErrorDatePikerLote = new ValidationMessage(Severity.ERROR, "O campo data fabricação do lote não pode ser vazio.");
//				validationMessages.add(messagesErrorDatePikerLote);
//
//				ValidationResult validationResult = new ValidationResult();
//				validationResult.addAll(validationMessages);

//				Lote lote = new Lote();
//				LoteDao loteDao = new LoteDao();
//
//				if (loteDao.findLote(lote)) {
//					alertaInformacao("Lote já cadastrado, favor cadastrar um novo lote!");
//					resetTextFildCodigoLote();
//				} else {
//					loteDao.salvar(lote);
//					resetTextFildCodigoLote();
//					alertaInformacao("Lote cadastrado com sucesso!");
//				}

//				Lote lote = new Lote();
//				lote.setCodigo(TextFildCodigoLote.getText());
//				lote.setDataFabricacao(new DataUtil().FormataDataRetornaDataLocalDate(DatePikerLote.getValue()));
//				LoteDao lteDao = new LoteDao();
//
//				if (loteDao.findLote(lote)) {
//					alertaInformacao("Lote já cadastrado, favor cadastrar um novo lote!");
//					resetTextFildCodigoLote();
//
//				} else {
//					if (lote.getCodigo() != null && !lote.getCodigo().isEmpty()) {
//						loteDao.salvar(lote);
//						resetTextFildCodigoLote();
//
//						alertaInformacao("Lote cadastrado com sucesso!");
//					}
//				}
			}
		});
	}

	private void resetTextFildCodigoLote() {
		textFildCodigoLote.setText("");
		datePikerLote.setValue(null);
	}

	private void alertaInformacao(String mensagem) {
		Alert alertSucesso = new Alert(AlertType.INFORMATION);
		alertSucesso.setTitle("Alerta");
		alertSucesso.setContentText(mensagem);
		alertSucesso.show();
	}

	private Tooltip tooltipErro(String mensagem) {
		Tooltip toolTip = new Tooltip();
		toolTip.setText(mensagem);
		toolTip.setStyle("-fx-background-color: red;");
		btnCadastrarLote.setTooltip(toolTip);
		return toolTip;
	}
}
