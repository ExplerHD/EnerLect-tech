package enerlect.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class EnerLectItems implements ContentList{
  public static Items darkenedMetal;
  public static Liquid electricLiquid;
  
  @Override
  public void load(){
    darkenedMetal = new Item("darkened-metal", Color.valueOf("6b6464")){{
      cost = 4;
    }};
    
    electricLiquid = new Liquid("electric-liquid", Color.valueOf("f5372a")){{
      viscosity = 1.2f;
    }};
  }
}
