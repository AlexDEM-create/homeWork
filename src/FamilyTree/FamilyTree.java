package FamilyTree;

import java.util.*;
import Human.Human;

public class FamilyTree {
    private final List<Human> ListOfFamily;

    public FamilyTree(){
        ListOfFamily = new ArrayList<>();
    }

    public void addHumantoTree(Human human) {
        if (!ListOfFamily.contains(human)){
            ListOfFamily.add(human);
            addHumantoChildListofParents(human);
            makeHumanaParentofChildList(human);
        }
    }

    private boolean makeHumanaParentofChildList(Human human) {
        for(Human child: human.getHumansChildrenList()){
            child.addParentstoHuman(human);
        }
        return true;
    }

    private void addHumantoChildListofParents(Human human) {
        for(Human parent: human.getParentsofHuman()){
            parent.addChildrentoHuman(human);
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В семейном дереве сейчас: ");
        sb.append(ListOfFamily.size()).append(" Чел."+"\n");
        for (Human human: ListOfFamily) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

}


