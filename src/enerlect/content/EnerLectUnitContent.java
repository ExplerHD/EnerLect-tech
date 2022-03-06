package enerlect.content;

import arc.graphics.Color;
import arc.struct.*;
import mindustry.graphics.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.abilities.*;
import mindustry.world.meta.*;
import mindustry.gen.*;
import mindustry.ctype.ContentList;
import mindustry.type.*;

public class EnerLectUnitContent implements ContentList{
  public static UnitType
    wrenches;
  
  @Override
  public void load(){
    wrenches = new UnitType("wrenches"){{
      health = 750f;
      speed = 2f;
      hitSize = 9f;
      flying = true;
      range = 160;
      maxRange = range;
      buildSpeed = 0.9f;
      commandLimit = 8;
      armor = 1f;
      constructor = UnitEntity::create;
      weapons.add(new Weapon("wrenches-healing-bolt"){{
        x = y = 0;
        reload = 20f;
        mirror = false;
        rotate = false;
        shootSound = Sounds.lasershoot;
        bullet = new LaserBoltBulletType(5.2f, 13f){{
          lifetime = 30f;
          healPercent = 3f;
          collidesTeam = true;
          frontColor = Pal.heal;
          backColor = Color.white;
        }};
      }});
    }};
  }
}
