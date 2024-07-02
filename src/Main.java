import FamilyTree.FamilyTree;
import Human.Human;
import Human.Gender;
import Writer.FileHandler;
import Human.HumanBuilder;
import java.io.*;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree humanTree = new FamilyTree();
        HumanBuilder humanBuilder = new HumanBuilder();

        Human human1 = humanBuilder.createHuman( "Иван", Gender.Male, LocalDate.of(1928, 5, 15));
        Human human2 = humanBuilder.createHuman("Мария", Gender.Female, LocalDate.of(1929, 10, 13));
        Human human3 = humanBuilder.createHuman("Сергей", Gender.Male, LocalDate.of(1957, 5, 15), human1, human2);
        Human human4 = humanBuilder.createHuman("Ольга", Gender.Male, LocalDate.of(1956, 4, 9));
        Human human5 = humanBuilder.createHuman("Федор", Gender.Male, LocalDate.of(1984, 7, 9), human3,human4);
        Human human6 = humanBuilder.createHuman("Светлана", Gender.Female, LocalDate.of(1985, 3, 8),human3,human4);
        Human human7 = humanBuilder.createHuman("Василий", Gender.Male, LocalDate.of(1988, 12, 12),human3,human4);
        Human human8 = humanBuilder.createHuman("Олег", Gender.Male, LocalDate.of(1985, 12, 12));
        Human human9 = humanBuilder.createHuman("Елена", Gender.Female, LocalDate.of(2010, 1, 30));

        human1.setDod(LocalDate.of(2013, 10, 19));
        human6.addSpouse(human8);
        human6.addChildrentoHuman(human9);

        humanTree.addHumantoTree(human1);
        humanTree.addHumantoTree(human2);
        humanTree.addHumantoTree(human3);
        humanTree.addHumantoTree(human4);
        humanTree.addHumantoTree(human5);
        humanTree.addHumantoTree(human6);
        humanTree.addHumantoTree(human7);
        humanTree.addHumantoTree(human8);
        humanTree.addHumantoTree(human9);


        System.out.println(humanTree.getbyId(5));

        FileHandler newFileHandler = new FileHandler();
        if (newFileHandler.writeObjecttoFile(humanTree)){
            System.out.println("Объект успешно сериализован в файл ");
        }
        FamilyTree newFamilyTree = (FamilyTree) newFileHandler.readObjectfromFile();
        System.out.println("Объект успешно десериализован из файла");
        System.out.println(newFamilyTree);

    }
}
