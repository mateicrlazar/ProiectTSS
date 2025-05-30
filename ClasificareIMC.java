package imc;

public final class ClasificareIMC
{
    public static String clasifica(double imc)
    {
        if (Double.isNaN(imc) || Double.isInfinite(imc) || imc <= 0 || imc > 100)
            return "invalid";
        if (imc < 18.5)
            return "subponderal";
        if (imc < 25)
            return "normal";
        if (imc < 30)
            return "supraponderal";
        if (imc < 40)
            return "obez";
        return "obez morbid";
    }
    private ClasificareIMC()
    {

    }
}