package bird;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public abstract class WaterBird extends Bird{
    protected WaterBody waterBody;

    public WaterBird(WaterBody waterBody) {
        setWaterBody(waterBody);
        setWaterHabitat(true);
    }

    protected void setWaterBody(WaterBody waterBody) {
        this.waterBody = waterBody;
    }

    public WaterBody getWaterBody() {
        return this.waterBody;
    }




}
