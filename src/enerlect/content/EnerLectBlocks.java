package enerlect.content;

import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.struct.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.ctype.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.Pal;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.entities.bullet.*;
import mindustry.entities.*;
import mindustry.world.*;
import mindustry.world.blocks.*;
import mindustry.world.blocks.power.*;
import mindustry.world.blocks.units.*;
import mindustry.world.blocks.defense.*;
import mindustry.world.blocks.environment.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.production.*;
import mindustry.world.blocks.distribution.*;
import mindustry.world.meta.*;
import mindustry.world.draw.*;

import enerlect.content.*;

import static mindustry.type.ItemStack.with;

public class EnerLectBlocks implements ContentList{
  public static Block
    implosion;
  
  @Override
  public void load() {
    implosion = new PowerTurret("circleator"){{
      requirements(Category.turret, with(
        Items.copper, 50,
        Items.lead, 50,
        Items.plastanium, 60
      ));
      size = 2;
      health = 50 * size * size;
      reloadTime = 90f;
      range = 135f;
      powerUse = 2.7f;
      restitution = 0.05f;
      shootType = new LaserBulletType(145){{ /* contoh code laser bullet */
        colors = new Color[]{Pal.darkishGray.a(1f)};
        hitSize = 6;
        lifetime = 36f;
        drawSize = 200f;
        collidesAir = true;
        length = 135f;
        ammoMultiplier = 2f;
      }};
    }};
  }
}
