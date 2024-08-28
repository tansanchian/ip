public class ListIndexOutOfBoundException extends HandsomeException{
    public ListIndexOutOfBoundException(int size) {
        super("Invalid List Index! List has " + size + " items.");
    }
}
