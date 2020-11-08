package command;

import cheatsheet.CheatSheetList;
import exception.CommandException;

import parser.CommandFlag;
import ui.Printer;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * The base class for all Commands.
 */
public abstract class Command {
    protected Printer printer;
    protected CheatSheetList cheatSheetList;

    protected ArrayList<CommandFlag> alternativeFlags; // At least one of these must be filled
    protected ArrayList<CommandFlag> necessaryFlags; // All of these must be filled

    protected LinkedHashMap<CommandFlag, String> flagsToDescriptions;
    public boolean isExitCommand;

    public Command() {
    }

    /**
     * Constructor for Command.
     *
     * @param printer The printer object handles the user interaction
     */
    public Command(Printer printer) {
        this.printer = printer;
<<<<<<< HEAD
        this.alternativeFlags = new ArrayList<>();
        this.necessaryFlags = new ArrayList<>();
=======
        this.alternativeArguments = new ArrayList<>();
        this.necessaryArguments = new ArrayList<>();
>>>>>>> 208c1e9c96dc39116a336443c92bb5b443d621a9
        this.flagsToDescriptions = new LinkedHashMap<>();
        isExitCommand = false;
    }

    public LinkedHashMap<CommandFlag, String> getFlagsToDescriptionsMap() {
        return flagsToDescriptions;
    }

    public void setFlagsToDescriptionsMap(HashMap<CommandFlag, String> flagsToDescriptions) {
        this.flagsToDescriptions.putAll(flagsToDescriptions);
    }

<<<<<<< HEAD
    public ArrayList<CommandFlag> getAlternativeFlags() {
        return alternativeFlags;
    }

    public ArrayList<CommandFlag> getNecessaryFlags() {
        return necessaryFlags;
    }


    public boolean hasRequiredFlags() {
        return hasNecessaryFlags() && hasAlternativeFlags();
    }

    /**
     * Checks if the command has all of the necessary flags.
     *
     * @return A boolean of whether the command contains all the necessary flags
     */
    public boolean hasNecessaryFlags() {
        for (CommandFlag arg : necessaryFlags) {
=======
    public ArrayList<CommandFlag> getAlternativeArguments() {
        return alternativeArguments;
    }

    public ArrayList<CommandFlag> getNecessaryArguments() {
        return necessaryArguments;
    }

    public boolean hasRequiredArguments() {
        return hasNecessaryArguments() && hasAlternativeArguments();
    }

    public boolean hasNecessaryArguments() {
        for (CommandFlag arg : necessaryArguments) {
>>>>>>> 208c1e9c96dc39116a336443c92bb5b443d621a9
            if (flagsToDescriptions.get(arg) == null) {
                return false;
            }
        }

        return true;
    }

    /**
<<<<<<< HEAD
     * Checks if the command has at least one of the alternative flags.
     *
     * @return A boolean of whether the command has at least one of the alternative flags
     */
    public boolean hasAlternativeFlags() {
        if (alternativeFlags.size() == 0) {
            return true;
        }

        for (CommandFlag arg : alternativeFlags) {
=======
     * Checks if the user has at least one of the alternative arguments.
     *
     * @return A boolean whether the user inputted at least one of the alternative arguments
     */
    public boolean hasAlternativeArguments() {
        if (alternativeArguments.size() == 0) {
            return true;
        }

        for (CommandFlag arg : alternativeArguments) {
>>>>>>> 208c1e9c96dc39116a336443c92bb5b443d621a9
            if (flagsToDescriptions.get(arg) != null) {
                return true;
            }
        }
        return false;
    }
    
    public abstract void execute() throws CommandException, InterruptedException, IOException;
}
