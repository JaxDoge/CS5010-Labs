package conservatory;
import bird.*;

/**
 * This is a Drive Class
 * It has no method
 * It has only one attribute, a conservatory
 * */
public class Driver {
    private static Conservatory conservatory = new Conservatory();



    public static void main(String[] args) {
        System.out.println("Start Here");


        // Let's create some funny birds.
        // Birds who are happy with live with any one
        Bird bird1 = new Pigeon("Robert Baratheon");
        Bird bird2 = new Pigeon("Tyrion Lannister");
        Bird bird3 = new Pigeon("Cersei Lannister");
        Bird bird4 = new Pigeon("Catelyn Stark");
        Bird bird5 = new Shorebird("Jaime Lannister");
        Bird bird6 = new Shorebird("Lancel Lannister");
        Bird bird7 = new Parrot("Daenerys Targaryen", "Daenerys Stormborn of House Targaryen");
        Bird bird8 = new Parrot("Oberyn Martell", "Ahhhhhhh");
        Bird bird9 = new Parrot("Varys","Little birds told me");
        Bird bird10 = new Owl("Jon Snow");
        Bird bird11 = new Owl("Osha");

        // Birds who hate living with other species
        Bird bird12 = new FlightlessBird("Robb Stark");
        Bird bird13 = new FlightlessBird("Sansa Stark");
        Bird bird14 = new PreyBird("Tywin Lannister");
        Bird bird15 = new PreyBird("Margaery Tyrell");
        Bird bird16 = new PreyBird("Khal Drogo");
        Bird bird17 = new Waterfowl("Melisandre");
        Bird bird18 = new Waterfowl("Brienne of Tarth");
        Bird bird19 = new Waterfowl("Talisa Stark");


        conservatory.addNewBird(bird10);
        conservatory.addNewBird(bird11);
        conservatory.addNewBird(bird12);
        conservatory.addNewBird(bird13);
        conservatory.addNewBird(bird14);
        conservatory.addNewBird(bird15);
        conservatory.addNewBird(bird16);
        conservatory.addNewBird(bird17);
        conservatory.addNewBird(bird18);
        conservatory.addNewBird(bird19);
        conservatory.addNewBird(bird1);
        conservatory.addNewBird(bird2);
        conservatory.addNewBird(bird3);
        conservatory.addNewBird(bird4);
        conservatory.addNewBird(bird5);
        conservatory.addNewBird(bird6);
        conservatory.addNewBird(bird7);
        conservatory.addNewBird(bird8);
        conservatory.addNewBird(bird9);

        System.out.println(conservatory.getConservatoryFoodDemand());
        System.out.println(conservatory.checkBirdAviary(bird14));
//        System.out.println(conservatory.getAviary(2).printASign());
//        System.out.println(conservatory.printAMap());
        System.out.println(conservatory.printAIndex());
    }
}
