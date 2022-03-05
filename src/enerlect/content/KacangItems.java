package enerlect.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.*;
import enerlect.content.*;

public class KacangItems implements ContentList{
  public static Item kacang, kacangHijau;
  @Override
  public void load(){
    // items
		kacang = new Item("kacang", Color.valueOf("edcc93")){{
			cost = 0;
			hardness  = 1;
		}};
		kacangHijau = new Item("kacang-hijau", Color.valueOf("c4e880")){{
			cost = 0.1f;
			hardness  = 1;
		}};
		// items end
    }
}
