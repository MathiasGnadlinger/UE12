package model;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Model
{
    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;
    private String hex;

    @FXML private TextField tf_RED_Input;
    @FXML private TextField tf_GREEN_Input;
    @FXML private TextField tf_BLUE_Input;
    @FXML private TextField tf_HEX_Output;
    @FXML private Button btn_Color_Output;


    public Model(ModularCounter red, ModularCounter green, ModularCounter blue)
    {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed()
    {
        return red.getValue();
    }

    public int getGreen()
    {
        return green.getValue();
    }

    public int getBlue()
    {
        return blue.getValue();
    }

    public String getHex(String hex)
    {
        int red = Integer.parseInt(tf_RED_Input.getText());
        String hexRed = Integer.toHexString(red);
        int green = Integer.parseInt(tf_GREEN_Input.getText());
        String hexGreen = Integer.toHexString(green);
        int blue = Integer.parseInt(tf_BLUE_Input.getText());
        String hexBlue = Integer.toHexString(blue);

        hex = hexRed + hexGreen + hexBlue;
        System.out.printf(" Hexadezimal: %c%c%c ", hexRed,hexGreen,hexBlue);

        return hex;
    }


    public void changeColorViaAbsoluteValue(ColorCode colorCode, String value)
    {
        int intValue = Integer.parseInt(value);
        switch (colorCode)
        {
            case RED:
                red.reset();
                red.update(intValue);
                break;
            case GREEN:
                green.reset();
                green.update(intValue);
                break;
            case BLUE:
                blue.reset();
                blue.update(intValue);
                break;
        }
    }

    public void changeColorViaAbsoluteValue(ColorCode colorCode, int value)
    {
        switch (colorCode)
        {
            case RED:
                red.reset();
                red.update(value);
                break;
            case GREEN:
                green.reset();
                green.update(value);
                break;
            case BLUE:
                blue.reset();
                blue.update(value);
                break;
        }
    }


    public void changeColorViaRelativeValue(ColorCode colorCode, String value)
    {
        int intValue = Integer.parseInt(value);
        switch (colorCode) {
            case RED:
                red.update(intValue);
                break;

            case GREEN:
                green.update(intValue);
                break;

            case BLUE:
                blue.update(intValue);
                break;
        }

    }

    public void changeColorViaRelativeValue(ColorCode colorCode, int value)
    {
        switch (colorCode) {
            case RED:
                red.update(value);
                break;

            case GREEN:
                green.update(value);
                break;

            case BLUE:
                blue.update(value);
                break;
        }

    }


    public static void main(String[] args)
    {
        System.out.printf("UE12 - ColorCalculaor");
    }

    @Override
    public String toString()
    {
        return "Model" +
                "red = " + red +
                ", green = " + green +
                ", blue = " + blue;
    }
}
