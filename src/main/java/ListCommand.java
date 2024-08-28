public class ListCommand extends Command {
    @Override
    public void execute(TaskList tasks, Storage storage, Ui ui) throws HandsomeException {
        ui.showList(tasks);
    };

    @Override
    public boolean isExit() {
        return false;
    };
}
