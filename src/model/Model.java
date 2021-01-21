package model;

public class Model
{
    private ModularCounter red;
    private ModularCounter green;
    private ModularCounter blue;


    public Model(ModularCounter red, ModularCounter green, ModularCounter blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public ModularCounter getRed() {
        return red;
    }

    public ModularCounter getGreen() {
        return green;
    }

    public ModularCounter getBlue() {
        return blue;
    }

    public String getHex()
    {
        return getHex();
    }




    public void changeColorViaAbsoluteValue(ColorCode colorCode, String value)
    {

    }

    public void changeColorViaAbsoluteValue(ColorCode colorCode, int value)
    {

    }

    public void changeColorViaRelativeValue(ColorCode colorCode, String value)
    {

    }

    public void changeColorViaRelativeValue(ColorCode colorCode, int value)
    {

    }



    public static void main(String[] args)
    {
        System.out.printf("UE12 - ColorCalculaor");
    }

    @Override
    public String toString() {
        return "Model" +
                "red = " + red +
                ", green = " + green +
                ", blue = " + blue;
    }
}
