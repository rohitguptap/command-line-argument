import java.util.HashMap;
import java.util.Map;

import Exception.ServerException;


public enum Commands {
    A("help", new HelpCommand()),
    B("read", new ReadCommand()),
    C("quit", new QuitCommand()),
    D("count", new CountCommand()),
    E("list", new ListCommand()),
    F("delete", new DeleteCommand()),
    G("update", new UpdateCommand());
   
    private String value;
    private Command command;
    private static Map<String, Commands> commandsMap;

    static {
        commandsMap = new HashMap<String, Commands>();
        for (Commands c : Commands.values()) {
            commandsMap.put(c.getValue(), c);    
        }
    }

    Commands(String value, Command command) {
        this.value= value;
        this.command = command;
    }

    public String getValue() {
        return value;
    }

    public Command getCommand() {
        return command;
    }

    public static Command getCommand(String value) throws ServerException {
        if(!commandsMap.containsKey(value)) {
            throw new ServerException("value not found:" + value);
        }
        return commandsMap.get(value).getCommand();
    }
}