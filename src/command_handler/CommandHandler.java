package command_handler;

public interface CommandHandler {
    void helpCommand();
    void addCommand();
    void discardCommand();
    void listCommand();
    void cartCommand();
    void orderCommand();
    void ordersCommand();
}
