package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class WaterBird extends Bird{
    protected WaterBody waterBody;

    public WaterBird() {
        setWaterHabitat(true);
    }

    public void setWaterBody(WaterBody waterBody) {
        this.waterBody = waterBody;
    }

    public WaterBody getWaterBody() {
        return this.waterBody;
    }




}
