package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.ColorCode;
import model.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller
{
    private Model model;

    @FXML private TextField tf_RED_Input;
    @FXML private TextField tf_GREEN_Input;
    @FXML private TextField tf_BLUE_Input;
    @FXML private TextField tf_HEX_Output;

    @FXML private Button btn_Color_Output;
    @FXML private Button btn_REDpl;
    @FXML private Button btn_REDmi;
    @FXML private Button btn_GREENpl;
    @FXML private Button btn_GREENmi;
    @FXML private Button btn_BLUEpl;
    @FXML private Button btn_BLUEmi;


    @FXML
    public void AddRed(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.RED,10);
        tf_BLUE_Input.setText(Integer.toString(model.getRed()));
        hex();
    }

    public void AddGreen(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.GREEN,10);
        tf_BLUE_Input.setText(Integer.toString(model.getGreen()));
        hex();
    }

    public void AddBlue()
    {
        model.changeColorViaAbsoluteValue(ColorCode.BLUE,10);
        tf_BLUE_Input.setText(Integer.toString(model.getBlue()));
        hex();
    }


    public void SubRed()
    {
        model.changeColorViaAbsoluteValue(ColorCode.RED,-10);
        tf_BLUE_Input.setText(Integer.toString(model.getRed()));
        hex();
    }

    public void SubGreen()
    {
        model.changeColorViaAbsoluteValue(ColorCode.GREEN,-10);
        tf_BLUE_Input.setText(Integer.toString(model.getGreen()));
        hex();
    }

    public void SubBlue()
    {
        model.changeColorViaAbsoluteValue(ColorCode.BLUE,-10);
        tf_BLUE_Input.setText(Integer.toString(model.getBlue()));
        hex();
    }


    @FXML
    public void Red(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.RED, tf_RED_Input.getText());
        tf_RED_Input.setText(Integer.toString(model.getRed()));
        hex();
    }
    @FXML
    public void Green(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.GREEN, tf_GREEN_Input.getText());
        tf_RED_Input.setText(Integer.toString(model.getGreen()));
        hex();
    }
    @FXML
    public void Blue(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.BLUE, tf_BLUE_Input.getText());
        tf_RED_Input.setText(Integer.toString(model.getBlue()));
        hex();
    }



    private void hex()
    {
        tf_HEX_Output.setText(model.getHex());
        btn_Color_Output.setStyle("-fx-background-color: " + model.getHex() + ";");
    }

    @FXML
    public void initialize(){
        model = new Model();
    }
}
