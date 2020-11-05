package command;

import cheatsheet.CheatSheet;
import cheatsheet.CheatSheetList;
import editor.Editor;
import exception.CommandException;
import exception.EditorException;
import parser.CommandFlag;
import ui.Printer;

public class AddCommand extends Command {
    private final Editor editor;
    private static final String NO_SPECIAL_CHAR = "^[^`~!@#$%^&*()_+={}\\[\\]|\\\\:;“’<,>.?]*$";
    public static final String invoker = "/add";

    public AddCommand(Printer printer, CheatSheetList cheatSheetList, Editor editor) {
        super(printer);
        this.cheatSheetList = cheatSheetList;
        this.editor = editor;

        flagsToDescriptions.put(CommandFlag.NAME, null);
        flagsToDescriptions.put(CommandFlag.SUBJECT, null);
        alternativeArguments.add(CommandFlag.NAME);
        alternativeArguments.add(CommandFlag.SUBJECT);
        if (printer.getDisplayingHelpMessages()) {
            printer.printAddCommandHelpMessage();
        }
    }

    @Override
    public void execute() throws CommandException {
        String name = flagsToDescriptions.get(CommandFlag.NAME);

        if (name == null || name.isEmpty() || name.isBlank()) {
            throw new CommandException("Name cannot be blank");
        }

        name = name.trim();
        if (cheatSheetList.exists(name)) {
            throw new CommandException("Name already existed, please enter another name");
        }


        if (!name.matches(NO_SPECIAL_CHAR)) {
            throw new CommandException("Name can only contain alphanumeric characters");
        }

        String subject = flagsToDescriptions.get(CommandFlag.SUBJECT);
        if (subject != null) {
            subject = convertToPascalCaseNoSpace(subject);
        } else {
            subject = "Unsorted";
        }

        callContentEditor();

        try {
            String description = editor.getContent();
            CheatSheet cheatSheet = new CheatSheet(name, subject, description);
            cheatSheetList.add(cheatSheet);
            printer.printAddNewCheatSheetMessage(cheatSheet, cheatSheetList);
        } catch (EditorException | NullPointerException e) {
            throw new CommandException(e.getMessage());
        }
    }

    private void callContentEditor() {
        editor.open();
        editor.waitForClose();
    }

    private String convertToPascalCaseNoSpace(String input) {
        if (input.length() == 0) {
            return "Unsorted";
        }
        String[] splitInput = input.split("\\p{IsWhite_Space}+");
        for (int i = 0; i < splitInput.length; i++) {
            splitInput[i] = splitInput[i].substring(0, 1).toUpperCase() + splitInput[i].substring(1).toLowerCase();
        }
        return String.join("", splitInput);
    }
}
