public class PromptCommand extends Command {
    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) {
        ui.showPrompt();
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
