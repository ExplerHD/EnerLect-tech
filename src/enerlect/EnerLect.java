package enerlect;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.mod.*;
import mindustry.gen.*;

public class EnerLect extends Mod{
  
  public EnerLect(){
    log.info("Loaded EnerLect Constructor");
  }
  
  @Override
  public boid loadContent(){
    new EnerLectBlocks().load();
    new EnerLectBullets().load();
  }
}
