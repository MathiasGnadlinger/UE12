package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.ColorCode;
import model.Model;
/**
 * @author Mathias Gnadlinger
 * @version 12, 26.01.2021
 */
public class Controller
{
    private Model model;

    @FXML private TextField tf_RED_Input;
    @FXML private TextField tf_GREEN_Input;
    @FXML private TextField tf_BLUE_Input;
    @FXML private TextField tf_HEX_Output;

    @FXML private Button btn_Color_Output;


    @FXML
    public void AddRed(ActionEvent event)
    {
        model.changeColorViaRelativeValue(ColorCode.RED,10);
        tf_RED_Input.setText(Integer.toString(model.getRed()));
        ShowHex();
    }

    public void AddGreen(ActionEvent event)
    {
        model.changeColorViaRelativeValue(ColorCode.GREEN,10);
        tf_GREEN_Input.setText(Integer.toString(model.getGreen()));
        ShowHex();
    }

    public void AddBlue()
    {
        model.changeColorViaRelativeValue(ColorCode.BLUE,10);
        tf_BLUE_Input.setText(Integer.toString(model.getBlue()));
        ShowHex();
    }


    public void SubRed()
    {
        model.changeColorViaRelativeValue(ColorCode.RED,-10);
        tf_RED_Input.setText(Integer.toString(model.getRed()));
        ShowHex();
    }

    public void SubGreen()
    {
        model.changeColorViaRelativeValue(ColorCode.GREEN,-10);
        tf_BLUE_Input.setText(Integer.toString(model.getGreen()));
        ShowHex();
    }

    public void SubBlue()
    {
        model.changeColorViaRelativeValue(ColorCode.BLUE,-10);
        tf_BLUE_Input.setText(Integer.toString(model.getBlue()));
        ShowHex();
    }


    @FXML
    public void Red(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.RED, tf_RED_Input.getText());
        tf_RED_Input.setText(Integer.toString(model.getRed()));
        ShowHex();
    }
    @FXML
    public void Green(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.GREEN, tf_GREEN_Input.getText());
        tf_GREEN_Input.setText(Integer.toString(model.getGreen()));
        ShowHex();
    }
    @FXML
    public void Blue(ActionEvent event)
    {
        model.changeColorViaAbsoluteValue(ColorCode.BLUE, tf_BLUE_Input.getText());
        tf_BLUE_Input.setText(Integer.toString(model.getBlue()));
        ShowHex();
    }


    @FXML
    private void ShowHex()
    {
        tf_HEX_Output.setText(model.getHex());
        btn_Color_Output.setStyle("-fx-background-color: " + model.getHex() + ";");
    }

    @FXML
    public void initialize()
    {
        model = new Model();
    }
}