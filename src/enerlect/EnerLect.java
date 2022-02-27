package enerlect;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.gen.*;

public class EnerLect extends Mod{
  
  public EnerLect(){}

  @Override
  public void loadContent(){
    new EnerLectBlocks().load();
    new EnerLectBullets().load();
  }
}
