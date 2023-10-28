package Commands;

import java.util.ArrayList;
import java.util.List;

public final class History implements ICommand{
    private final List<String> commandsList;

    public History(){
        commandsList = new ArrayList<>();
    }

    public void addCommand(String command){
        commandsList.add(command);
    }

    public List<String> getHistory(){
        return commandsList;
    }

    public String getHistoryAsString(){
        List<String> historyInList = getHistory();
        if (historyInList.size() == 0){
            return "";
        }
        String hs = "\u001B[32m" + "";
        for (int i = 0; i < historyInList.size() - 1; i++) {
            hs += (i + 1) + " - " + historyInList.get(i) + "\n";
        }

        hs += historyInList.size() + " - " + historyInList.get(historyInList.size() - 1) + "\u001B[0m";
        return hs;
    }

    @Override
    public Boolean isValidArgs(String[] args) {
        return true;
    }

    @Override
    public void PutArgs(String[] args) throws Exception {
        return;
    }

    @Override
    public void runCommand() {
        System.out.println(getHistoryAsString());
    }
}
