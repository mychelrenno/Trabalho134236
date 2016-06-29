package br.trabalho.address.view;

import java.io.File;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import org.controlsfx.dialog.Dialogs;

import br.trabalho.address.MainApp;
import br.trabalho.address.model.Cliente;
import br.trabalho.address.util.DateUtil;

/**
 * The controller for the root layout. The root layout provides the basic
 * application layout containing a menu bar and space where other JavaFX
 * elements can be placed.
 * 
 * @author Marco Jakob
 */
public class RootLayoutController {

	@FXML
    private TextField clienteNome;
    @FXML
    private TextField clienteEndereco;
    @FXML
    private TextField clienteNumero;
    @FXML
    private TextField clienteComplemento;
    @FXML
    private TextField clienteBairro;
    @FXML
    private TextField clienteCidade;
    @FXML
    private TextField clienteEstado;
    @FXML
    private TextField clienteCep;
    @FXML
    private TextField clienteTelefone;
    @FXML
    private TextField clienteCelular;
	
    // Reference to the main application
    private MainApp mainApp;

    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }

    /**
     * Creates an empty address book.
     */
    @FXML
    private void handleNew() {
        mainApp.getPersonData().clear();
        mainApp.setPersonFilePath(null);
    }

    /**
     * Opens a FileChooser to let the user select an address book to load.
     */
    @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();

        // Set extension filter
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);

        // Show save file dialog
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadPersonDataFromFile(file);
        }
    }

    /**
     * Saves the file to the person file that is currently open. If there is no
     * open file, the "save as" dialog is shown.
     */
    @FXML
    private void handleSave() {
        File personFile = mainApp.getPersonFilePath();
        if (personFile != null) {
            mainApp.savePersonDataToFile(personFile);
        } else {
            handleSaveAs();
        }
    }

    /**
     * Opens a FileChooser to let the user select a file to save to.
     */
    @FXML
    private void handleSaveAs() {
		FileChooser fileChooser = new FileChooser();

		// Set extension filter
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
				"XML files (*.xml)", "*.xml");
		fileChooser.getExtensionFilters().add(extFilter);

		// Show save file dialog
		File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

		if (file != null) {
			// Make sure it has the correct extension
			if (!file.getPath().endsWith(".xml")) {
				file = new File(file.getPath() + ".xml");
			}
			mainApp.savePersonDataToFile(file);
		}
	}
    
    /**
     * Opens the birthday statistics.
     */
    @FXML
    private void handleShowBirthdayStatistics() {
      mainApp.showBirthdayStatistics();
    }

    /**
     * Opens an about dialog.
     */
    @FXML
    private void handleAbout() {
		Dialogs.create()
	        .title("AddressApp")
	        .masthead("About")
	        .message("Author: Marco Jakob\nWebsite: http://code.makery.ch")
	        .showInformation();
    }

    /**
     * Closes the application.
     */
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
    @FXML
    private void menuItemCadastroDeCliente(){
    	mainApp.chamaTelaCadastroDeCliente();
    }
    
    @FXML
    private void menuItemCadastroDeProduto(){
    	mainApp.chamaTelaCadastroDeProduto();
    }
    
    @FXML
    private void cadastroClienteOk(){
    	Cliente c = new Cliente();
    	
    	c.setBairro(clienteBairro.getText());
    	c.setCelular(clienteCelular.getText());
        c.setCep(clienteCep.getText());
        c.setCidade(clienteCidade.getText());
        c.setComplemento(clienteComplemento.getText());
        c.setEndereco(clienteEndereco.getText());
        c.setEstado(clienteEstado.getText());
        c.setNome(clienteNome.getText());
        c.setNumero(clienteNumero.getText());
        c.setTelefone(clienteTelefone.getText());
//
//        okClicked = true;
//        dialogStage.close();
    }
    
    @FXML
    private void cadastroClienteCancelar(){
    	
    }
}






















