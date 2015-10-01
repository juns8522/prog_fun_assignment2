public class Player
{
    private Slot slot;
    private String name;
    private SlotCollection ground;
    private TreasureChest chest;
    private int maxTurns;
    private int turns;

    public Player(String name, int x, SlotCollection ground, TreasureChest chest, int maxTurns)
    {
        this.name = name;
        slot = new Slot(x);
        this.ground = ground;
        this.chest = chest;
        this.maxTurns = maxTurns;
        turns = 0;
    }

    public void act(int action)
    {
        switch (action)
        {
            case Action.LEFT:
                move(-1);
                break;
            case Action.RIGHT:
                move(1);
                break;
            case Action.UP:
                pickUp();
                break;
            case Action.DOWN:
                putDown();
                break;
        }
        turns++;
    }

    public void move(int direction)
    {
        slot.move(direction);
    }

    public boolean pickUp()
    {
        return ground.moveTo(slot) || chest.moveTo(slot);
    }

    public boolean putDown()
    {
        return ground.moveFrom(slot) || chest.moveFrom(slot);
    }

    public boolean usedUpTurns()
    {
        return turns >= maxTurns;
    }

    public Slot getSlot()
    {
        return slot;
    }

    public int getX()
    {
        return slot.getX();
    }

    public String toString()
    {
        return name + slot;
    }
}
