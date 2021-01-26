package model;

public class Model
{
    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;
    private String hex;


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
        hex = String.format("#%02x%02x%02x", red.getValue(), green.getValue(), blue.getValue()).toUpperCase();
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


    @Override
    public String toString()
    {
        return "Model" +
                "red = " + red +
                ", green = " + green +
                ", blue = " + blue;
    }
}
