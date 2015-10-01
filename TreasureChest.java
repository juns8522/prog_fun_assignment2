public class TreasureChest
{
    private int combination;
    private SlotCollection slots; // Inheritance would be a better option
    private int x;

    public TreasureChest(int combination, int x)
    {
        this.combination = combination;
        this.x = x;
        slots = new SlotCollection(x, x, x, x);
    }

    public boolean moveTo(Slot slot)
    {
        return slots.moveTo(slot);
    }

    public boolean moveFrom(Slot slot)
    {
        return slots.moveFrom(slot);
    }

    public int getX()
    {
        return x;
    }
    
    public int getCombination()
    {
        return combination;
    }

    public boolean isUnlocked()
    {
        return slots.getSlot4().isFilled() && getKey() == combination;
    }

    public boolean isFilled()
    {
        return slots.isFilled();
    }

    private int getKey()
    {
        // This method contains the formula to unlock the combination of the treasure.
        return (slots.getSlot1().getNumber() + slots.getSlot2().getNumber()) * slots.getSlot3().getNumber();
    }

    public String toString()
    {
        return "Treasure/" + combination + "\\(" + x + ")";
    }
}
