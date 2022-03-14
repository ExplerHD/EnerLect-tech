package enerlect.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.struct.*;
import mindustry.ai.types.*;
import mindustry.ctype.*;
import mindustry.entities.*;
import mindustry.entities.abilities.*;
import mindustry.entities.bullet.*;
import mindustry.entities.effect.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.type.ammo.*;
import mindustry.type.weapons.*;
import mindustry.world.meta.*;

public class EnerLectUnitContent implements ContentList{
  public static UnitType
    wrenches, screwdriver;
  
  @Override
  public void load(){
    wrenches = new UnitType("wrenches"){{
      health = 750f;
      speed = 2f;
      hitSize = 11f;
      flying = true;
      range = 160;
      maxRange = range;
      buildSpeed = 0.9f;
      commandLimit = 8;
      armor = 1f;
      constructor = UnitEntity::create;
      abilities.add(new RepairFieldAbility(60f, 60f * 4, 60f));
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
    screwdriver = new UnitType("screwdriver"){{
      health = 900f;
      hitSize = 15f;
      rotateSpeed = 5f;
      range = 70f;
      constructor = UnitEntity::create;
      flying = false;
      commandLimit = 8;
      buildSpeed = 1.1f;
      armor = 1f;
      canBoost = true;
      boostMultiplier = 2f;
      engineOffset = 6f;
      engineSize = 3f;
      lowAltitude = true:
      riseSpeed = 0.07f;
      landShake = 4f;
      weapons.add(new Weapon("screwdriver-laser"){{
        x = 9f;
        y = 1f;
        reload = 60f;
        recoil = 4f;
        shake = 2f;
        shootSound = Sounds.laser;
        bullet = new LaserBulletType(){{
          damage = 45f;
          recoil = 1f;
          sideAngle = 45f;
          sideWidth = 1f;
          sideLength = 75f;
          length = 135f;
          collidesTeam = true;
          healPercent = 10;
          colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerlaser, Color.white};
        }};
      }});
    }};
  }
}
