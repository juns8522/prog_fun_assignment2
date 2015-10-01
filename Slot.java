/**
    * A slot represents a place/position where a stone can be put.
    *
    * The player has a slot, and the ground has 4 slots.
    *
    * Slots have positions, but stones do not.
    */
public class Slot
{
    private Stone stone = Stone.PLACEHOLDER; // We use the PLACEHOLDER stone rather than null.
    private int x;

    public Slot(int x)
    {
        this.x = x;
    }

    public void move(int dx)
    {
        x += dx;
    }

    public boolean moveTo(Slot other)
    {
        if (x == other.x && stone != Stone.PLACEHOLDER && other.stone == Stone.PLACEHOLDER)
        {
            other.stone = stone;
            stone = Stone.PLACEHOLDER;
            return true;
        }
        return false;
    }

    public int getX()
    {
        return x;
    }

    public void setStone(Stone stone)
    {
        this.stone = stone;
    }

    public int getNumber()
    {
        return stone.getNumber();
    }

    public Stone getStone()
    {
        return stone;
    }

    public boolean isFilled()
    {
        return stone != Stone.PLACEHOLDER;
    }

    public String toString()
    {
        return stone.toString() + "(" + x + ")";
    }
}
