package enerlect.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class EnerLectLiquids implements ContentList{
  public static Liquid electricLiquid;
  
  @Override
  public void load(){
    electricLiquid = new Liquid("electric-liquid", Color.valueOf("f5372a")){{
      viscosity = 1.2f;
    }};
  }
}
