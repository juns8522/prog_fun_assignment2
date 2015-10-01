import java.util.*;

/**
    * This is the main class for the basic UI.
    *
    * Right-click on this class and invoke the main method to start.
    */
public class BasicUI implements UI
{
    public static void main(String[] args) { new BasicUI(); }

    private Scanner keyboard = new Scanner(System.in);
    private Game game;

    public BasicUI()
    {
        game = new Game(this);
        game.play();
    }

    public int readStones()
    {
        return promptInt("How many stones should be created? ");
    }

    public int readCombination()
    {
        int combination;
        while (!validCombination(combination = promptInt("Enter combination for the treasure chest: ")))
            System.out.println("Invalid combination.");
        return combination;
    }

    private boolean validCombination(int combination)
    {
        return true;
        // In Assignment 2, we can no longer check the validity,
        // since an arbitrary number of stones is possible.
        //
        // Here is the Assignment 1 check for validity:
        //return combination >= 5 && combination <= 10;
    }

    public String readName()
    {
        System.out.print("Enter player name: ");
        return keyboard.nextLine();
    }

    public int readMaxTurns()
    {
        return promptInt("Enter maximum allowed moves: ");
    }

    private int promptInt(String prompt)
    {
        System.out.print(prompt);
        int result = keyboard.nextInt();
        keyboard.nextLine();
        return result;
    }

    public int nextAction()
    {
        System.out.print("Move (l/r/p/d): ");
        switch (keyboard.nextLine().charAt(0))
        {
            case 'l': return Action.LEFT;
            case 'r': return Action.RIGHT;
            case 'p': return Action.UP;
            case 'd': return Action.DOWN;
            default: return -1;
        }
    }

    public void updateScreen()
    {
        System.out.println(game);
    }

    public void win()
    {
        System.out.println("You unlocked the treasure!");
    }

    public void lose()
    {
        System.out.println("You lose.");
    }
}
