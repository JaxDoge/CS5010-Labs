package conservatory;
import java.util.*;
import bird.*;

/**
 * This is a Drive Class
 * It generate two conservatories by default
 * Any new bird could try to be contained in these conservatories
 * */
public class Driver {
    private static Conservatory[] conList = new Conservatory[2];

    public static boolean addBird(Bird bird) {
        for (int i = 0; i < conList.length; i++) {
            if (conList[i].addNewBird(bird)) { return true; }
        }
        System.out.println("All conservatory cannot add this bird at this moment: " + bird);
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Start Here");

        for (int i = 0; i < conList.length; i++) {
            conList[i] = new Conservatory();
        }

        // Let's create some funny birds.
        // Birds who are happy with live with any one
        BlueheadedQuaildove bird1 = new BlueheadedQuaildove("Robert Baratheon");
        BlueheadedQuaildove bird2 = new BlueheadedQuaildove("Tyrion Lannister");
        BlueheadedQuaildove bird3 = new BlueheadedQuaildove("Cersei Lannister");
        BlueheadedQuaildove bird4 = new BlueheadedQuaildove("Catelyn Stark");
        GreatAuk bird5 = new GreatAuk("Jaime Lannister");
        GreatAuk bird6 = new GreatAuk("Lancel Lannister");
        RoseringParakeet bird7 = new RoseringParakeet("Daenerys Targaryen", "Daenerys Stormborn of House Targaryen, the First of Her Name, Queen of the Andals and the First Men, Protector of the Seven Kingdoms, the Mother of Dragons, the Khaleesi of the Great Grass Sea, the Unburnt, the Breaker of Chains.");
        RoseringParakeet bird8 = new RoseringParakeet("Oberyn Martell", "Ahhhhhhh");
        RoseringParakeet bird9 = new RoseringParakeet("Varys","Little birds told me");
        SnowyOwl bird10 = new SnowyOwl("Jon Snow");
        SnowyOwl bird11 = new SnowyOwl("Osha");

        // Birds who hate living with other species
        Moa bird12 = new Moa("Robb Stark");
        Moa bird13 = new Moa("Sansa Stark");
        Hawk bird14 = new Hawk("Tywin Lannister");
        Hawk bird15 = new Hawk("Margaery Tyrell");
        Hawk bird16 = new Hawk("Khal Drogo");
        Swan bird17 = new Swan("Melisandre");
        Swan bird18 = new Swan("Brienne of Tarth");
        Swan bird19 = new Swan("Talisa Stark");



        addBird(bird1);
        addBird(bird2);
        addBird(bird3);
        addBird(bird4);
        addBird(bird5);
        addBird(bird6);
        addBird(bird7);
        addBird(bird8);
        addBird(bird9);
        addBird(bird10);
        addBird(bird11);
        addBird(bird12);
        addBird(bird13);
        addBird(bird14);
        addBird(bird15);
        addBird(bird16);
        addBird(bird17);
        addBird(bird18);
        addBird(bird19);

        for (int i = 0; i < conList.length; i++) {
            System.out.println(conList[i]);
        }
        ;
    }
}
