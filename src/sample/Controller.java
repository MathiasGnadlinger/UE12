package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.ColorCode;
import model.Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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

    private final String FILENAME = "Color.dat";
    private final String FILEFORMAT = "Color File Format 1.0";


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
        tf_GREEN_Input.setText(Integer.toString(model.getGreen()));
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


    @FXML private void ShowHex()
    {
        tf_HEX_Output.setText(model.getHex());
        btn_Color_Output.setStyle("-fx-background-color: " + model.getHex() + ";");
    }

    @FXML public void initialize()
    {
        model = new Model();
    }

    public boolean loadFromFile()
    {
        boolean issaved = false;
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Color.dat"));
            if (bufferedReader.readLine().equals("Color File Format 1.0"))
            {
                model.changeColorViaAbsoluteValue(ColorCode.RED, bufferedReader.readLine());
                tf_RED_Input.setText(Integer.toString(model.getRed()));

                model.changeColorViaAbsoluteValue(ColorCode.GREEN, bufferedReader.readLine());
                tf_GREEN_Input.setText(Integer.toString(model.getGreen()));

                model.changeColorViaAbsoluteValue(ColorCode.BLUE, bufferedReader.readLine());
                tf_BLUE_Input.setText(Integer.toString(model.getBlue()));
                ShowHex();

                issaved = true;
            }
        }
        catch(IOException ex)
        {
            System.out.printf("Error while Loading");
        }
        return issaved;
    }

    public boolean saveToFile()
    {
        boolean issaved = false;
        try
        {
            FileWriter fw= new FileWriter("Color.dat");
            fw.write("Color File Format 1.0");
            fw.write(System.lineSeparator());
            fw.write(Integer.toString(model.getRed()));
            fw.write(System.lineSeparator());
            fw.write(Integer.toString(model.getGreen()));
            fw.write(System.lineSeparator());
            fw.write(Integer.toString(model.getBlue()));
            issaved = true;
            fw.close();
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return issaved;
    }
}