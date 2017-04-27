/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIControl;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import main.Controller;
import main.Employee;
import main.ShiftTime;
import main.Booking;

/**
 * FXML Controller class
 *
 * @author tn
 */
public class GUIBOViewBookingSumController implements Initializable {
    
	private Controller c;
	
    @FXML
    private TableView<Booking> booking;

    @FXML
    private TableColumn<Booking, Number> ID;

    @FXML
    private TableColumn<Booking, String> customer;
    
	@FXML
    private TableColumn<Booking, Date> date; 

    @FXML
    private TableColumn<Booking, ShiftTime> time;

    @FXML
    private TableColumn<Booking, Number> employeeID;
	
	@FXML
    private Button navMenu;
    
    @FXML
    private Button exit;
	
    @FXML
    private void closeButtonAction(ActionEvent event) throws IOException {
    	Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    @FXML
    private void navMenuButtonAction(ActionEvent event) throws IOException {
    	Stage stage = (Stage) navMenu.getScene().getWindow();
		// load the scene
		Scene boMenu = new Scene(FXMLLoader.load(getClass().getResource("GUIBOMenu.fxml")));
		
		// switch scenes
		stage.setScene(boMenu);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TN - Populate Appointments
        ID.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Booking, Number>, 
    			ObservableValue<Number>>() {

            @Override
            public ObservableValue<Number> call(CellDataFeatures<Booking, Number> param) {
                IntegerProperty prop = new SimpleIntegerProperty();
                prop.setValue(param.getValue().ID);
                return prop;
            }
    	});
        customer.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Booking, String>, 
        		ObservableValue<String>>() {

			@Override
			public ObservableValue<String> call(CellDataFeatures<Booking, String> param)
			{
				StringProperty prop = new SimpleStringProperty();
				prop.setValue(param.getValue().getCustomer());
				
				return prop;
			}	
		});
        
        employeeID.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Booking, Number>, 
        		ObservableValue<Number>>() {

			@Override
			public ObservableValue<Number> call(CellDataFeatures<Booking, Number> param)
			{
				IntegerProperty prop = new SimpleIntegerProperty();
				prop.setValue(param.getValue().getEmployeeID());
				
				return prop;
			}	
		});
         
        booking.getItems().setAll(c.getPastBookings());
    }    
    
}
