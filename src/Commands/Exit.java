package Commands;

public class Exit implements Command{


    /**
     * Implements Exit Command
     * @return null
     * By returning null. The CommandManager exits the program.
     */
    @Override
    public Command execute() {
        return null;
    }
}
