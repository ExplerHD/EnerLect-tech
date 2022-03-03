package enerlect.content;

import arc.graphics.*;
import mindustry.ctype.*;
import mindustry.type.*;

public class EnerLectLiquid implements ContentList{
  public static Liquid electricLiquid;
  
  @Override
  public void load(){
    electricLiquid = new Liquid("electric-liquid", Color.valueOf("f5372a")){{
      heatCapacity = 0.4f;
      effect = StatusEffects.shocked;
    }};
  }
}
