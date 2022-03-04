package enerlect.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class EnerLectItems implements ContentList{
  public static Item darkenedMetal, biostone, fragments, yellowsteel;
  public static Liquid electricLiquid;
  
  @Override
  public void load(){
    // items start
    darkenedMetal = new Item("darkened-metal", Color.valueOf("6b6464")){{
      cost = 4;
    }};
    biostone = new Item("biostone", Color.valueOf("21de63")) {{
      cost = 0;
      flammability = 0.5f;
      hardness = 0;
    }};
    fragments = new Item("fragments", Color.valueOf("b54ed4")) {{
      cost = 0.5f;
      charge = 0.15f;
      hardness = 0;
    }};
    yellowsteel = new Item("yellow-steel", Color.valueOf("d9d35f")) {{
      cost = 0.7f;
      charge = 0.01f;
      hardness = 2;
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
