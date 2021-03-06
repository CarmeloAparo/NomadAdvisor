import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;

public class PersonalAreaInterface {

    @FXML
    private Button logoutButton;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox tempCheckBox;

    @FXML
    private Label nameLabel;

    @FXML
    private Label titleLebel;

    @FXML
    private Label surnameLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Separator upperSeparator;

    @FXML
    private Label preferencesLabel;

    @FXML
    private Separator lowerSeparator;

    @FXML
    private CheckBox airCheckBox;

    @FXML
    private CheckBox qualityLifeCheckBox;

    @FXML
    private CheckBox foreignersCheckBox;

    @FXML
    private CheckBox healthcareCheckBox;

    @FXML
    private CheckBox nightlifeCheckBox;

    @FXML
    private CheckBox costCheckBox;

    @FXML
    private CheckBox safetyCheckBox;

    @FXML
    private CheckBox walkabilityCheckBox;

    @FXML
    private CheckBox wifiCheckBox;

    @FXML
    private CheckBox englishCheckBox;

    @FXML
    private Button saveButton;

    @FXML
    private Label emailLabel;
    
    @FXML
    private Label outcomeLabel;
    
    private NomadAdvisor nomadAdvisor;

    @FXML
    // Comes back to the city interface
    void comeBack(ActionEvent event) {
    	clearAll();
    	nomadAdvisor.changeScene("cityInterface");
    }

    @FXML
    // Logout and returns to login interface
    void logout(ActionEvent event) {
    	clearAll();
    	nomadAdvisor.changeScene("loginInterface");
    }

    @FXML
    // Saves the preferences added from the customer
    void savePreferences(ActionEvent event) {
    	List<String> preferences = this.getPreferences();
    	Customer customer = (Customer) nomadAdvisor.getUser();
    	outcomeLabel.setText(NomadHandler.updatePreferences(customer, preferences));
    }
    
    // Sets the username label with the username of the logged user
    private void setUsernameLabel(String username) {
    	if(username == null)
    		usernameLabel.setText("");
    	else
    		usernameLabel.setText(username);
    }
    
    // Sets the name label with the name of the logged user
    private void setNameLabel(String name) {
    	if(name == null)
    		nameLabel.setText("Name: not available");
    	else
    		nameLabel.setText("Name: " + name);
    }
    
    // Sets the surname label with the surname of the logged user
    private void setSurnameLabel(String surname) {
    	if(surname == null)
    		surnameLabel.setText("Surname: not available");
    	else
    		surnameLabel.setText("Surname: " + surname);
    }
    
    // Sets the email label with the email of the logged user
    private void setEmailLabel(String email) {
    	if(email == null)
    		emailLabel.setText("Email: not available");
    	else
    		emailLabel.setText("Email: " + email);
    }
    
    // Select the checkbox fields depending on the preferences of the logged customer
    private void setPreferences(List<String> preferences) {
    	if(preferences != null) {
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.TEMPERATURE))) tempCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.AIR_QUALITY))) airCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.QUALITY_LIFE))) qualityLifeCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.FOREIGNERS))) foreignersCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.HEALTHCARE))) healthcareCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.NIGHTLIFE))) nightlifeCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.COST))) costCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.SAFETY))) safetyCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.WALKABILITY))) walkabilityCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.WIFI))) wifiCheckBox.setSelected(true);
	    	if(preferences.contains(Utils.cityAttributes.get(Utils.cityNames.ENGLISH))) englishCheckBox.setSelected(true);
    	}
    }
    
    // Creating a list of preferences depending on what the customer selects on the interface
    private List<String> getPreferences() {
    	List<String> preferences = new ArrayList<>();
    	if(tempCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.TEMPERATURE));
    	if(airCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.AIR_QUALITY));
    	if(qualityLifeCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.QUALITY_LIFE));
    	if(foreignersCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.FOREIGNERS));
    	if(healthcareCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.HEALTHCARE));
    	if(nightlifeCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.NIGHTLIFE));
    	if(costCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.COST));
    	if(safetyCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.SAFETY));
    	if(walkabilityCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.WALKABILITY));
    	if(wifiCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.WIFI));
    	if(englishCheckBox.isSelected()) preferences.add(Utils.cityAttributes.get(Utils.cityNames.ENGLISH));
    	return preferences;
    }
    
    // Get the logged Customer from NomadAdvisor and sets the fields of the interface
    public void initInterface() {
    	outcomeLabel.setText("");
    	Customer customer = null;
    	if(nomadAdvisor != null)
    		customer = (Customer) nomadAdvisor.getUser();
    	if(customer != null) {
	    	this.setUsernameLabel(customer.getUsername());
	    	this.setNameLabel(customer.getName());
	    	this.setSurnameLabel(customer.getSurname());
	    	this.setEmailLabel(customer.getEmail());
	    	this.setPreferences(customer.getPreferences());
    	}
    }
    
    // Sets the reference to the NomadAdvisor object
    public void setNomadAdvisor(NomadAdvisor nomadAdvisor) {
    	this.nomadAdvisor = nomadAdvisor;
    }
    
    // Clears all the fields of the interface
    private void clearAll() {
    	outcomeLabel.setText("");
    	tempCheckBox.setSelected(false);
    	airCheckBox.setSelected(false);
    	qualityLifeCheckBox.setSelected(false);
    	foreignersCheckBox.setSelected(false);
    	healthcareCheckBox.setSelected(false);
    	nightlifeCheckBox.setSelected(false);
    	costCheckBox.setSelected(false);
    	safetyCheckBox.setSelected(false);
    	walkabilityCheckBox.setSelected(false);
    	wifiCheckBox.setSelected(false);
    	englishCheckBox.setSelected(false);
    }

}
