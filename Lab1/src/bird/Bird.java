package bird;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.*;

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


    @Override
    public void setExtinction(boolean extFlag) {
        this.isExtinct = extFlag;
    }

    @Override
    public boolean isExtinction() {
        return this.isExtinct;
    };

    @Override
    public void setNickName(String nickName) {
        if (checkNameValidity(nickName)) {
            this.nickName = nickName;
        }

    }


    @Override
    public String getNickName() {
        return this.nickName;
    }

    @Override
    public void setSpeciesName(String speciesName) {
        if (checkNameValidity(speciesName) && checkTypeBelong(speciesName)) {
            this.speciesName = speciesName;
        }
    }


    @Override
    public String getSpeciesName() {
        return this.speciesName;
    }

    @Override
    public void setTypeName(TypeName typeName){
        if (!typeName.toString().equalsIgnoreCase(this.getClass().getSimpleName())) {
            throw new IllegalArgumentException("The type name does not match with this bird type.");
        }
        this.typeName = typeName;
    }

    @Override
    public TypeName getTypeName() {
        return this.typeName;
    }

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

    @Override
    public List<String> getCharacteristic() {
        return this.Characteristic;
    }

    @Override
    public void setWingsNum(int wings) {
        if (wings < 0) {
            throw new IllegalArgumentException("Wing number cannot be negative.");
        }
        this.wingsNum = wings;
    }

    @Override
    public int getWingsNum() {
        return this.wingsNum;
    }

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

    @Override
    public Map<Food, Integer> getFavFood() {
        return this.favoriteFood;
    }

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

    @Override
    public void setWaterHabitat(boolean waterFlag) {
        this.waterHabitat = waterFlag;
    }

    @Override
    public boolean getWaterHabitat() {
        return this.waterHabitat;
    }

    @Override
    public AviaryDemand getAviaryDemand(TypeName typeName) {
        return type2Demand.get(typeName);
    }

    @Override
    public AviaryDemand getAviaryDemand() {
        return type2Demand.get(this.typeName);
    }

    @Override
    public boolean checkTypeBelong(String speciesName) {
        if (species2Type.containsKey(speciesName) && species2Type.get(speciesName) == this.typeName) {
            return true;
        }
        throw new IllegalArgumentException("This species name is not valid for current bird type");
    }

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
