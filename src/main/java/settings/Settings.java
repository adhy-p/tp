package settings;

import ui.ConsoleColorsEnum;
import ui.Printer;

public class Settings {
    private boolean isDisplayingHelpMessages;
    private Printer printer;

    public Settings(Printer printer) {
        this.printer = printer;
        isDisplayingHelpMessages = true;
    }

    public void setDisplayingHelpMessages(boolean isDisplayingHelpMessages) {
        this.isDisplayingHelpMessages = isDisplayingHelpMessages;
    }

    public boolean getDisplayingHelpMessages() {
        return this.isDisplayingHelpMessages;
    }

    public void setColor(int option) {
        switch (option) {
        case 1:
            printer.textColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.favColor = ConsoleColorsEnum.BRIGHT_GREEN_TEXT;
            printer.logoColor = ConsoleColorsEnum.BRIGHT_GREEN_TEXT;
            printer.nameColor = ConsoleColorsEnum.BRIGHT_MAGENTA_TEXT;
            printer.subjectColor = ConsoleColorsEnum.BOLD_MAGENTA_TEXT;
            printer.detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            printer.reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        case 2:
            printer.textColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.favColor = ConsoleColorsEnum.BRIGHT_BLUE_TEXT;
            printer.logoColor = ConsoleColorsEnum.BRIGHT_BLUE_TEXT;
            printer.nameColor = ConsoleColorsEnum.BRIGHT_RED_TEXT;
            printer.subjectColor = ConsoleColorsEnum.BOLD_YELLOW_TEXT;
            printer.detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            printer.reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        case 3:
            printer.textColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.favColor = ConsoleColorsEnum.BOLD_WHITE_TEXT;
            printer.logoColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.nameColor = ConsoleColorsEnum.BOLD_WHITE_TEXT;
            printer.subjectColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            printer.reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        default:
            printer.textColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.favColor = ConsoleColorsEnum.BRIGHT_YELLOW_TEXT;
            printer.logoColor = ConsoleColorsEnum.BRIGHT_CYAN_TEXT;
            printer.nameColor = ConsoleColorsEnum.BRIGHT_CYAN_TEXT;
            printer.subjectColor = ConsoleColorsEnum.BRIGHT_BLUE_TEXT;
            printer.detailsColor = ConsoleColorsEnum.WHITE_TEXT;
            printer.alertColor = ConsoleColorsEnum.BOLD_RED_TEXT;
            printer.reset = ConsoleColorsEnum.WHITE_TEXT;
            break;
        }
        printer.printSetColorMessage(option);
    }
}
