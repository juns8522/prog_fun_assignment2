import java.util.*;

/**
    * Defines the common set of methods that all user interfaces support.
    *
    * This allows us to easily switch one user interface for another.
    *
    * (Note: You will learn a better way to do User Interface programming in the
    * following subject: Applications Programming / Object-Oriented Design.)
    */
public interface UI
{
    public int readStones();
    public int readCombination();
    public String readName();
    public int readMaxTurns();
    public int nextAction();
    public void updateScreen();
    public void win();
    public void lose();
}
