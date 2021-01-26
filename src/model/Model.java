package model;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Scanner;
/**
 * @author Mathias Gnadlinger
 * @version 12, 26.01.2021
 */
public class Model
{
    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;
    private String hex;

    @FXML private TextField tf_RED_Input;
    @FXML private TextField tf_GREEN_Input;
    @FXML private TextField tf_BLUE_Input;


    public Model() {
        red = new ModularCounter(256);
        green = new ModularCounter(256);
        blue = new ModularCounter(256);
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

    public String getHex()
    {
        int red = getRed();
        String hexRed = Integer.toHexString(red);
        int green = getGreen();
        String hexGreen = Integer.toHexString(green);
        int blue = getBlue();
        String hexBlue = Integer.toHexString(blue);

        if (hexRed.length() != 2)
        {
            hexRed = "0" + hexRed;
        }
        else
        {
            hexRed = hexRed;
        }
        if (hexGreen.length() != 2)
        {
            hexGreen = "0" + hexGreen;
        }
        else
        {
            hexRed = hexGreen;
        }
        if (hexBlue.length() != 2)
        {
            hexBlue = "0" + hexBlue;
        }
        else
        {
            hexRed = hexBlue;
        }

        hex ="#" + hexRed + hexGreen + hexBlue;

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
        Model model = new Model();
        ColorCode colorCode = ColorCode.RED;
        boolean isCorrect;
        System.out.printf("Color - Calculator");


        while(true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Auswahl: ");
            System.out.println("A -> Absolut Color Change \nB -> Relativ Color Change \nC -> View values \nD -> Stop!");
            System.out.println("\nYour wish!: ");

            String inputWish = scanner.next();

            switch (inputWish)
            {
                case "A":
                    System.out.printf("Please Enter your color (r,g,b):");
                    String rgbA = scanner.next();
                    isCorrect = true;
                    switch (rgbA)
                    {
                        case "r":
                            colorCode = ColorCode.RED;
                            break;
                        case "g":
                            colorCode = ColorCode.GREEN;
                            break;
                        case "b":
                            colorCode = ColorCode.BLUE;
                            break;
                    }
                    if (isCorrect)
                    {
                        System.out.printf("Enter value:");
                        model.changeColorViaAbsoluteValue(colorCode, scanner.nextInt());
                        System.out.println("Red: " + model.red);
                        System.out.println("Green: " + model.green);
                        System.out.println("Blue: " + model.blue);
                    }
                    break;

                case "B":
                    System.out.printf("Please Enter your color (r,g,b): ");
                    String rgbR = scanner.next();
                    isCorrect = true;
                    switch (rgbR)
                    {
                        case "r":
                            colorCode = ColorCode.RED;
                            break;
                        case "g":
                            colorCode = ColorCode.GREEN;
                            break;
                        case "b":
                            colorCode = ColorCode.BLUE;
                            break;
                    }
                    if (isCorrect)
                    {
                        System.out.printf("Enter value: ");
                        model.changeColorViaRelativeValue(colorCode, scanner.nextInt());
                        System.out.println("Red: " + model.red);
                        System.out.println("Green: " + model.green);
                        System.out.println("Blue: " + model.blue);
                    }
                    break;

                case "C":
                {
                    System.out.println("Red: " + model.red);
                    System.out.println("Green: " + model.green);
                    System.out.println("Blue: " + model.blue);
                    System.out.println("Hex: " + model.getHex());
                }
                    break;
                case "D":
                {
                    System.out.printf("See u soon\n");
                }
            }
        }
    }
}