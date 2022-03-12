package enerlect.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class EnerLectItems implements ContentList{
  public static Item darkenedMetal, biostone, fragments, yellowsteel;
  public static Liquid electricLiquid, thoriumCooler;
  
  @Override
  public void load(){
    // items start
    darkenedMetal = new Item("darkened-metal", Color.valueOf("6b6464")){{
      cost = 4;
    }};
    // items end
    // liquids start
    electricLiquid = new Liquid("electric-liquid", Color.valueOf("f5372a")){{
      viscosity = 1.2f;
    }};
    thoriumCooler = new Liquid("thoriumCooler", Color.valueOf("#f29dd0")){{
      viscosity = 1f;
    }};
    // liquids end
  }
}
