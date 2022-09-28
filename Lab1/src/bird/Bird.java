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
    static ThmRg bloodtemp = ThmRg.Warmblooded;
    static Loco locomotion = Loco.Bipedal;
    static AniType animaltype = AniType.Vertebrate;
    static ForeLb forelimb = ForeLb.Wings;
    static ExCover exteriorcover = ExCover.Feathers;
    static EatStr eatingstructure = EatStr.Beak;

    /**
     * Attributes that vary from different species*/


}
