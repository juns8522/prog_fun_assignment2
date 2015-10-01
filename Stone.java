public class Stone
{
    // We use a PLACEHOLDER stone rather than null.
    public static final Stone PLACEHOLDER = new Stone(-1000);

    private int number;

    public Stone(int number)
    {
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

    public String getSymbol()
    {
        switch (number)
        {
            case 1: return "#";
            case 2: return "@";
            case 3: return "%";
            case 4: return "$";
            default: return "";
        }
    }

    public String toString()
    {
        return getSymbol();
    }
}
