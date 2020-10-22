package cheatsheet;

import exception.CommandException;
import ui.Printer;

import java.util.ArrayList;

public class CheatSheetList {
    private static ArrayList<CheatSheet> cheatSheets = new ArrayList<>();

    public CheatSheetList() {
    }

    /**
     * Gets the number of cheat sheet currently in the CheatSheetList.
     *
     * @return size of cheatSheets
     */
    public static int getSize() {
        return cheatSheets.size();
    }

    /**
     * Gets all the cheat sheets in the cheatSheetList.
     *
     * @return cheatSheets The current list of cheat sheets
     */
    public static ArrayList<CheatSheet> getCheatSheetList() {
        return cheatSheets;
    }

    /**
     * Converts the cheatSheetName attribute for each cheat sheet into a string.
     * The string will be used by UI for printing
     *
     * @return printedByUI The string to be printed by UI
     */
    public static String printCheatSheetNames() {
        StringBuilder printedByUI = new StringBuilder("Current list of cheat sheet:\n");
        for (CheatSheet cs : cheatSheets) {
            printedByUI.append(cs.getCheatSheetName()).append("\n");
        }
        return printedByUI.toString();
    }

    /**
     * Adds a new cheat sheet to the list.
     */
    public static void add(CheatSheet cheatSheet) {
        cheatSheets.add(cheatSheet);
    }

    /**
     * Deletes a cheat sheet from the list.
     * Prints an error message if name is not found.
     *
     * @param name The name attribute of the desired cheat sheet
     * @throws CommandException when index < 0 or index >= cheatSheets.size()
     */
    public static void remove(String name) throws CommandException {
        int index = 0;
        for (CheatSheet cs : cheatSheets) {
            if (cs.getCheatSheetName().equals(name)) {
                break;
            }
            index++;
        }
        try {
            remove(index);
        } catch (CommandException e) {
            throw new CommandException("Please enter a valid index");
        }
    }

    /**
     * Deletes a cheat sheet from the list.
     * Prints an error message if index is out of bound.
     *
     * @param index The index of the desired cheat sheet
     * @throws CommandException when index < 0 or index >= cheatSheets.size()
     */
    public static void remove(int index) throws CommandException {
        try {
            cheatSheets.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("Please enter a valid index");
        }
    }

    /**
     * Removes all cheat sheet in the list.
     */
    public static void clear() {
        cheatSheets.clear();
    }

    /**
     * Retrieves a cheat sheet from the list using its index.
     *
     * @param index The index of desired cheat sheet
     * @return size of cheatSheets
     * @throws CommandException when index < 0 or index >= cheatSheets.size()
     */
    public static CheatSheet getCheatSheet(int index) throws CommandException {
        CheatSheet cheatSheet;
        try {
            cheatSheet = cheatSheets.get(index - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new CommandException("Please enter a valid index");
        }
        return cheatSheet;
    }

    /**
     * Retrieves a cheat sheet from the list using its name.
     *
     * @param name The name attribute of desired cheat sheet
     * @return size of cheatSheets
     * @throws CommandException when name cannot be found inside the list
     */
    public static CheatSheet getCheatSheet(String name) throws CommandException {
        int index = 0;
        for (CheatSheet cs : cheatSheets) {
            if (cs.getCheatSheetName().equals(name)) {
                break;
            }
            index++;
        }
        CheatSheet cheatSheet;
        try {
            cheatSheet = getCheatSheet(index + 1);
        } catch (CommandException e) {
            throw new CommandException("Please enter a valid name");
        }
        return cheatSheet;
    }
}
