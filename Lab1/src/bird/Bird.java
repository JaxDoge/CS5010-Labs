package bird;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;


/**
 * This is the basic bird parent class. It implements Birdable interface which define all birds common behavior.
 * Bird class define all properties thar shared by every bird. Those properties are described in spec https://northeastern.instructure.com/courses/123270/assignments/1549374
 * Bird has nickname, typename, species name and favorite foods demand. It could live near water or not.
 * It is extinct right now or not
 * It could introduce its characteristic.
 * It has certain number of wings, including nil.
 * */
public abstract class Bird implements Birdable {

    /**
     * Attributes that are shared by all bird class
     * */
    private static final Map<String, TypeName> species2Type = new HashMap<>();
    private static final Map<TypeName, AviaryDemand> type2Demand = new HashMap<>();

    /**
     * Instance attributes that need to be concreted
     * */
    protected String nickName;
    protected String speciesName;
    protected TypeName typeName;
    protected boolean isExtinct;
    protected Map<Food, Integer> favoriteFood;
    protected List<String> Characteristic;
    protected int wingsNum;
    protected boolean waterHabitat;

   /**
    * Populating the species2Type memo map.
    * */
    static {
        species2Type.put("Moa", TypeName.FLIGHTLESSBIRD);
        species2Type.put("Hawk", TypeName.PREYBIRD);
        species2Type.put("RoseringParakeet", TypeName.PARROT);
        species2Type.put("Kakapo", TypeName.PARROT);
        species2Type.put("Swan", TypeName.WATERFOWL);
        species2Type.put("BlueheadedQuaildove", TypeName.PIGEON);
        species2Type.put("GreatAuk", TypeName.SHOREBIRD);
        species2Type.put("SnowyOwl", TypeName.OWL);
    }

    /**
     * Populating the type2Demand memo map
     * */
    static {
        type2Demand.put(TypeName.FLIGHTLESSBIRD, AviaryDemand.FLIGHTLESS_BIRD);
        type2Demand.put(TypeName.PREYBIRD, AviaryDemand.PREY_BIRD);
        type2Demand.put(TypeName.WATERFOWL, AviaryDemand.WATERFOWL);
        type2Demand.put(TypeName.PARROT, AviaryDemand.NO_DEMAND);
        type2Demand.put(TypeName.SHOREBIRD, AviaryDemand.NO_DEMAND);
        type2Demand.put(TypeName.PIGEON, AviaryDemand.NO_DEMAND);
        type2Demand.put(TypeName.OWL, AviaryDemand.NO_DEMAND);

    }

    /**
     * Set extinction
     * */
    @Override
    public void setExtinction(boolean extFlag) {
        this.isExtinct = extFlag;
    }

    /**
     * Get extinction
     * */
    @Override
    public boolean isExtinction() {
        return this.isExtinct;
    };

    /**
     * Set nickname.
     * nickName String: Input nickname
     * Throw IllegalArgument: if the input nickname is invalid
     * */
    @Override
    public void setNickName(String nickName) {
        if (checkNameValidity(nickName)) {
            this.nickName = nickName;
        }

    }

    /**
     * Get nickname
     * Return String: current nickname
     * */
    @Override
    public String getNickName() {
        return this.nickName;
    }

    /**
     * Set species name.
     * speciesName String: Input species name
     * Throw IllegalArgument: if the input species name is invalid, or this species name is not belong to current bird type.
     * */
    @Override
    public void setSpeciesName(String speciesName) {
        if (checkNameValidity(speciesName) && checkTypeBelong(speciesName)) {
            this.speciesName = speciesName;
        }
    }

    /**
     * Get species name.
     * Return String: current species name
     */
    @Override
    public String getSpeciesName() {
        return this.speciesName;
    }

    /**
     * Set type name
     * typeName TypeName: Input enum type name
     * Throw IllegalArgument: if the input type name does not match current bird class.
     * */
    @Override
    public void setTypeName(TypeName typeName){
        if (!typeName.toString().equalsIgnoreCase(this.getClass().getSimpleName())) {
            throw new IllegalArgumentException("The type name does not match with this bird type.");
        }
        this.typeName = typeName;
    }

    /**
     * Get current type Name
     * Return TypeName: type name
     * */
    @Override
    public TypeName getTypeName() {
        return this.typeName;
    }

    /**
     * Set this bird's characteristic.
     * characteristic List<String>: input characteristic
     * Throw IllegalArgumentE if there is a empty string
     * */
    @Override
    public void setCharacteristic(List<String> characteristic){
        // Check each characteristic item
        for (String chara : characteristic) {
            if (chara.length() == 0) {
                throw new IllegalArgumentException("One characteristic string is empty");
            }
        }
        this.Characteristic = characteristic;
    }

    /**
     * Get characteristic
     * Return List<String>: current characteristic
     * */
    @Override
    public List<String> getCharacteristic() {
        return this.Characteristic;
    }

    /**
     * Set wing numbers
     * wings int: input wing number
     * Throw exception if the input is a negative integer
     * */
    @Override
    public void setWingsNum(int wings) {
        if (wings < 0) {
            throw new IllegalArgumentException("Wing number cannot be negative.");
        }
        this.wingsNum = wings;
    }

    /**
     * Get wing numbers
     * Return int:
     * */
    @Override
    public int getWingsNum() {
        return this.wingsNum;
    }

    /**
     * Set wing numbers
     * wings int: input wing number
     * Throw exception if the input size is not two or one has ZERO portion
     * */
    @Override
    public void setFavFood(Map<Food, Integer> favFood) {
        if (favFood.size() != 2) {
            throw new IllegalArgumentException("The number of favorite food must be TWO.");
        }
        for (Map.Entry<Food, Integer> set : favFood.entrySet()) {
            if (set.getValue() <= 0) {
                throw new IllegalArgumentException(String.format("The portion of food (%s) is less or equal to ZERO", set.getKey()));
            }
        }
        this.favoriteFood = favFood;
    }

    /**
     * Set wing numbers
     * wings int: input wing number
     * Throw exception if the input is a negative integer
     * */
    @Override
    public Map<Food, Integer> getFavFood() {
        return this.favoriteFood;
    }

    /**
     * Get wing numbers
     * Return int:
     * */
    @Override
    public int getFavFoodPortion(Food food) {
        if (this.favoriteFood == null) {
            throw new NullPointerException("The bird's favorite food hasn't settled yet.");
        }
        if (!this.favoriteFood.containsKey(food)) {
            throw new IllegalArgumentException("The bird doesn't like this food: " + food + ".");
        }
        return this.favoriteFood.get(food);
    }

    /**
     * Get wing numbers
     * Return int:
     * */
    @Override
    public void setWaterHabitat(boolean waterFlag) {
        this.waterHabitat = waterFlag;
    }

    /**
     * Get wing numbers
     * Return int:
     * */
    @Override
    public boolean getWaterHabitat() {
        return this.waterHabitat;
    }

    /**
     * Get wing numbers
     * Return int:
     * */
    @Override
    public AviaryDemand getAviaryDemand(TypeName typeName) {
        return type2Demand.get(typeName);
    }

    /**
     * Get wing numbers
     * Return int:
     * */
    @Override
    public AviaryDemand getAviaryDemand() {
        return type2Demand.get(this.typeName);
    }

    /**
     * Check if input species name is belong to current bird type.
     * Return boolean:
     * */
    @Override
    public boolean checkTypeBelong(String speciesName) {
        if (species2Type.containsKey(speciesName) && species2Type.get(speciesName) == this.typeName) {
            return true;
        }
        throw new IllegalArgumentException("This species name is not valid for current bird type");
    }

    /**
     * Check if input name is valid.
     * A valid name only includes words, space and _
     * The start of a valid name must be a word.
     * Return boolean:
     * */
    public static boolean checkNameValidity(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("The input name string is empty");
        } else if (Pattern.compile("^\\W | ^_").matcher(name).find()) {
            throw new IllegalArgumentException("The input name string start with a non-word or non-number character, included _");
        } else if (Pattern.compile("[^\\w\\s_]").matcher(name).find()) {
            throw new IllegalArgumentException("The input name string contains non-word special character, excepted _ and space character");
        } else if (Pattern.compile("\\s{2,} | _{2,}").matcher(name).find()) {
            throw new IllegalArgumentException("The input name string contains adjacent space character or _");
        } else if (Pattern.compile("\\W$ | _$").matcher(name).find()) {
            throw new IllegalArgumentException("The input name string end with a non-word or non-number character, included _");
        }
        return true;
    }

    /**
     * Print out the spec of this bird
     * Return String
     * */
    public String birdSpec() {
        String typeName = this.getTypeName().toString();
        String nickName = this.getNickName();
        String speciesName = this.getSpeciesName();
        String habitat = this.waterHabitat ? "Near Water" : "Land";
        String chara = this.getCharacteristic() == null? "[]" : this.getCharacteristic().toString();
        StringBuilder describeSB = new StringBuilder();
        describeSB.append("Type: ");
        describeSB.append(typeName);
        describeSB.append("\n");
        describeSB.append("Species: ");
        describeSB.append(speciesName);
        describeSB.append("\n");
        describeSB.append("Nickname: ");
        describeSB.append(nickName);
        describeSB.append("\n");
        describeSB.append("Live in: ");
        describeSB.append(habitat);
        describeSB.append("\n");
        describeSB.append("Fun info: ");
        describeSB.append(chara);
        return describeSB.toString();
    }
    @Override
    public String toString() {
        String typeName = this.getTypeName().toString();
        String nickName = this.getNickName();
        String speciesName = this.getSpeciesName();

        return nickName + "-" + speciesName + "-" + typeName;
    }

}
