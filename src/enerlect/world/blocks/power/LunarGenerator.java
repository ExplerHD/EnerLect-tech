package enerlect.world.blocks.power;

import arc.math.*;
import arc.struct.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.power.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.type.*;
import mindustry.ctype.*;

import static mindustry.Vars.*;
public class LunarGenerator extends PowerGenerator{
  
  public LunarGenerator(String name){
    super(name);
    flags = EnumSet.of();
    envEnabled = Env.any;
  }
  
  @Override
  public void setStats(){
    super.setStats();
    stats.remove(generationType);
    stats.add(generationType, powerProduction * 60.0f, StatUnit.powerSecond);
  }
  
  public class LunarGeneratorBuild extends GeneratorBuild{
    @Override
    public void updateTile(){
      productionEfficiency = enabled ?
        Mathf.maxZero(Attribute.light.env() + 
                      (state.rules.lighting ?
                       0.1f + state.rules.ambientLight.a :
                       1f
        )) : 0f;
    }
  }
}
