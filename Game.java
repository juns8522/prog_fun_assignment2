
public class Game
{
    private Player player;
    private TreasureChest chest;
    private SlotCollection ground;
    private UI ui;

    public Game(UI ui)
    {
        this.ui = ui;
        int numStones = ui.readStones(); // You can ignore this until task 2
        ground = new SlotCollection(1, 2, 3, 4);
        ground.placeStone(ground.getSlot1(), 1);
        ground.placeStone(ground.getSlot2(), 2);
        ground.placeStone(ground.getSlot3(), 3);
        ground.placeStone(ground.getSlot4(), 4);
        chest = new TreasureChest(ui.readCombination(), 5);
        int maxTurns = ui.readMaxTurns();
        player = new Player(ui.readName(), 0, ground, chest, maxTurns);
    }

    public void play()
    {
        ui.updateScreen();
        while (!isOver())
        {
            turn();
            ui.updateScreen();
        }
        if (won())
            ui.win();
        else
            ui.lose();
    }

    public void turn()
    {
        player.act(ui.nextAction());
    }

    public SlotCollection getGround()
    {
        return ground;
    }

    public TreasureChest getChest()
    {
        return chest;
    }

    public Player getPlayer()
    {
        return player;
    }

    public boolean isOver()
    {
        return won() || player.usedUpTurns();
    }

    public boolean won()
    {
        return chest.isUnlocked();
    }

    public String toString()
    {
        return player + " " + ground + " " + chest;
    }
}
