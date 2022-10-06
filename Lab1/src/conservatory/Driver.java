package conservatory;
import bird.*;

/**
 * This is a Drive Class
 * It generate two conservatories by default
 * Any new bird could try to be contained in these conservatories
 * */
public class Driver {
    private static Conservatory[] conList = new Conservatory[2];

    public static boolean addBird(Birdable bird) {
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
        Birdable bird1 = new BlueheadedQuaildove("Robert Baratheon");
        Birdable bird2 = new BlueheadedQuaildove("Tyrion Lannister");
        Birdable bird3 = new BlueheadedQuaildove("Cersei Lannister");
        Birdable bird4 = new BlueheadedQuaildove("Catelyn Stark");
        Birdable bird5 = new GreatAuk("Jaime Lannister");
        Birdable bird6 = new GreatAuk("Lancel Lannister");
        Birdable bird7 = new RoseringParakeet("Daenerys Targaryen", "Daenerys Stormborn of House Targaryen, the First of Her Name, Queen of the Andals and the First Men, Protector of the Seven Kingdoms, the Mother of Dragons, the Khaleesi of the Great Grass Sea, the Unburnt, the Breaker of Chains.");
        Birdable bird8 = new RoseringParakeet("Oberyn Martell", "Ahhhhhhh");
        Birdable bird9 = new RoseringParakeet("Varys","Little birds told me");
        Birdable bird10 = new SnowyOwl("Jon Snow");
        Birdable bird11 = new SnowyOwl("Osha");

        // Birds who hate living with other species
        Birdable bird12 = new Moa("Robb Stark");
        Birdable bird13 = new Moa("Sansa Stark");
        Birdable bird14 = new Hawk("Tywin Lannister");
        Birdable bird15 = new Hawk("Margaery Tyrell");
        Birdable bird16 = new Hawk("Khal Drogo");
        Birdable bird17 = new Swan("Melisandre");
        Birdable bird18 = new Swan("Brienne of Tarth");
        Birdable bird19 = new Swan("Talisa Stark");



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
        addBird(bird1);
        addBird(bird2);
        addBird(bird3);
        addBird(bird4);
        addBird(bird5);
        addBird(bird6);
        addBird(bird7);
        addBird(bird8);
        addBird(bird9);


        for (int i = 0; i < conList.length; i++) {
            System.out.println(conList[i]);
        }
        ;
    }
}
