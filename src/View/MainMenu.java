package View;

import View.Commands.AddtoTree;
import View.Commands.CloseMenu;
import View.Commands.ShowTree;
import View.Commands.SortByName;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
List<Command> mainMenuList;


public MainMenu(){
    mainMenuList = new ArrayList<>();
    mainMenuList.add(new AddtoTree());
    mainMenuList.add(new ShowTree());
    mainMenuList.add(new SortByName());
    mainMenuList.add(new CloseMenu());
}

public void addToMainMenu(Command command){
    mainMenuList.add(command);
}

    public List<Command> getMainMenuList() {
        return mainMenuList;
    }

    @Override
    public String toString(){
    StringBuilder sb = new StringBuilder();
        for (int i = 0; i <mainMenuList.size() ; i++) {
            sb.append(i + 1).append(". ").append(mainMenuList.get(i).getCommandName()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
