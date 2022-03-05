/* package enerlect.type.weapons;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.scene.ui.layout.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.entities.units.*;
import mindustry.gen.*;
import mindustry.type.*;
import mindustry.world.blocks.units.*;
import mindustry.world.meta.*;

public class StatusLaserBeamWeapon extends Weapon{
  public booelan targetBuilding = false;
  
  public StatusEffect effect;
  public float beamWidth = 1f;
  public float pulseRadius = 6f;
  public float pulseStroke = 2f;
  
  public TextureRegion laser, laserEnd, laserTop, laserTopEnd;
  public Color laserColor = Color.valueOf("ffcf7d"), laserTopColor = Color.white.cpy();
  
  public StatusLaserBeamWeapon(String name){
    super(name);
  }
  
  public StatusLaserBeam(){
  }
  {
    // must be >0 to prevent bugs
    reload = 1f;
    predictTarget = false;
    autoTarget = true;
        controllable = false;

        rotate = true;

        useAmmo = false;

        mountType = HealBeamMount::new;

        recoil = 0f;

    }
*/ 
