package bird;

/**
 * Technically there should be parent class of Bird class
 * But We do not have
 * So just record several attributes by hard coding*/
public class Bird {
    /**
     * Common birds' attributes
     * No need initialize later
     * Shared by every bird species*/
    protected static ThmRg bloodtemp = ThmRg.Warmblooded;
    protected static Loco locomotion = Loco.Bipedal;
    protected static AniType animaltype = AniType.Vertebrate;
    protected static ForeLb forelimb = ForeLb.Wings;
    protected static ExCover exteriorcover = ExCover.Feathers;
    protected static EatStr eatingstructure = EatStr.Beak;

    /**
     * Attributes that vary from different species
     * */

    public boolean isExtinction() {
        return false;
    }


}
