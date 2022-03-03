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
import enerlect.graphics.*;

import static mindustry.type.ItemStack.with;

public class EnerLectBlocks implements ContentList{
  public static Block
    // turrets
    implosion,
  
    // power
    spectralGenerator;
  @Override
  public void load() {
    // reg turrets
    implosion = new PowerTurret("implosion"){{
      requirements(Category.turret, with(
        Items.copper, 50,
        Items.lead, 50,
        Items.plastanium, 60
      ));
      size = 2;
      health = 320;
      reloadTime = 90f;
      range = 135f;
      powerUse = 2.7f;
      restitution = 0.05f;
      shootType = new MissileBulletType(3.1f, 350){{
        // bullet sprite
        sprite = "missile-large";
        // targeting
        collidesGround = collidesAir = true;
        // general
        width = height = 12f;
        shrinkY = 0f;
        drag = -0.003f;
        keepVelocity = false;
        // lighting
        lightRadius = 60f;
        lightOpacity = 0.7f;
        lightColor = Color.blue;
        // damage
        splashDamageRadius = 70f;
        splashDamage = 350f;
        lifetime = 80f;
        backColor = Color.blue;
        frontColor = Color.white;
        // effects
        hitEffect = EnerLectFx.implosion;
        despawnEffect = EnerLectFx.implosion;
      }};
    }};
    // turrets end
    // reg power
    spectralGenerator = new SingleTypeGenerator("spectral-generator"){{
      requirements(Category.power, with(Items.copper, 60, Items.lead, 60, Items.plastanium, 60, Items.phaseFabric, 60));
      consumes.item(Items.thorium);
      consumes.liquid(EnerLectLiquids.electricLiquid, 0.1);
      hasItems = true;
      hasLiquids = true;
      size = 4;
      health = 40 * size * size;
      powerProduction = 115f;
      ambientSound = Sounds.steam;
      ambientSoundVolume = 0.03f;
    }};
  }
}
