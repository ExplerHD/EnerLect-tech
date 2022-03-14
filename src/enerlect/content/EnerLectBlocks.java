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
import enerlect.world.blocks.*;
import enerlect.world.blocks.power.*;

import static mindustry.type.ItemStack.with;
import static mindustry.type.ItemStack.*; // bjir

public class EnerLectBlocks implements ContentList{
  public static Block
    // defense
    lightWall, lightWallLarge,
    // crafters
    lightMetalSmelter,
    // turrets
    implosion, aftab, balabad, assaultBulletDestroyer,
    // power
    lunarPanel, mediumLunarPanel, largeLunarPanel;
  @Override
  public void load() {
    // reg defense
    lightWall = new Wall("light-wall"){{
      requirements(Category.defense, with(EnerLectItems.lightMetal, 6));
      health = 400 * 4;
      lightningChance = 1f;
    }};
    lightWallLarge = new Wall("light-wall-large"){{
      requirements(Category.defense, with(EnerLectItems.lightMetal, 24));
      health = 400 * 4 * 4;
      lightningChance = 1f;
    }};
    // end defense
    // reg crafters
    lightMetalSmelter = new GenericCrafter("light-metal-smelter"){{
      requirements(Category.crafting, with(Items.copper, 40, Items.lead, 35, Items.silicon, 15));
      craftEffect = Fx.smeltsmoke;
      outputItem = new ItemStack(EnerLectItems.lightMetal, 2);
      craftTime = 60f;
      size = 3;
      hasPower = true;
      hasLiquids = false;
      drawer = new DrawSmelter(Color.valueOf("fdfdfd"));
      ambientSound = Sounds.smelter;
      ambientSoundVolume = 0.07f;

      consumes.items(with(Items.copper, 2, Items.metaglass, 2));
      consumes.power(1.5f);
    }};
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
    aftab = new PowerTurret("aftab"){{
      requirements(Category.turret, with(
        Items.copper, 150,
        Items.lead, 135,
        Items.silicon, 87
      ));
      size = 2;
      health = 1200;
      reloadTime = 60f;
      range = 25f * 8f;
      powerUse = 6.25f;
      restitution = 0.05f;
      shootType = new LaserBulletType(154){{
        colors = new Color[]{Pal.lancerLaser.cpy().a(0.4f), Pal.lancerLaser, Color.white};
        hitEffect = Fx.hitLancer;
        hitSize = 4;
        lifetime = 32f;
        drawSize = 400f;
        collidesAir = true;
        length = 25f * 8f;
        ammoMultiplier = 1f;
      }};
    }};
    balabad = new ItemTurret("balabad"){{
      requirements(Category.turret, with(Items.copper, 100, Items.titanium, 62, Items.plastanium, 40));
      ammo(
        Items.metaglass, Bullets.fragGlass,
        Items.blastCompound, Bullets.fragExplosive,
        Items.plastanium, Bullets.fragPlastic,
        Items.surgeAlloy, Bullets.fragSurge
      );
      xRand = 4f;
      reloadTime = 8f;
      range = 154f;
      size = 2;
      recoilAmount = 1f;
      rotateSpeed = 7f;
      inaccuracy = 0f;
      shootCone = 30f;
      shootSound = Sounds.shootSnap;

      health = 145 * size * size;
      limitRange();
    }};

    assaultBulletDestroyer = new PointDefenseTurret("assault-bullet-destroyer"){{
      requirements(Category.turret, with(Items.silicon, 290, Items.thorium, 180, Items.phaseFabric, 140, Items.surgeAlloy, 25));
      health = 250 * size * 2;
      size = 3;
      hasPower = true;
      consumes.powerCond(11f, (PointDefenseBuild b) -> b.target != null);
      shootLength = 5f;
      bulletDamage = 100f;
      reloadTime = 2;
    }};
    // turrets end
    // reg power
    /* spectralGenerator = new SingleTypeGenerator("spectral-generator"){{
      requirements(Category.power, with(Items.copper, 60, Items.lead, 60, Items.plastanium, 60, Items.phaseFabric, 60));
      consumes.item(Items.thorium);
      consumes.liquid(EnerLectItems.electricLiquid, 0.15f);
      hasItems = true;
      hasLiquids = true;
      size = 4;
      health = 40 * size * size;
      powerProduction = 115f;
      ambientSound = Sounds.steam;
      ambientSoundVolume = 0.03f;
    }};  //disabled due to nullpointerexception */
    lunarPanel = new LunarGenerator("lunar-panel"){{
      requirements(Category.power, with(Items.silicon, 15, EnerLectItems.darkenedMetal, 10, Items.lead, 15));
      health = 45 * size * size;
      size = 2;
      powerProduction = 0.27f;
    }};
    
    mediumLunarPanel = new LunarGenerator("medium-lunar-panel"){{
      requirements(Category.power, with(Items.silicon, 30, EnerLectItems.darkenedMetal, 15, Items.lead, 30, Items.metaglass, 15));
      health = 90 * size * size;
      size = 3;
      powerProduction = 0.7f;
    }};

    largeLunarPanel = new LunarGenerator("large-lunar-panel"){{
      requirements(Category.power, with(Items.silicon, 60, EnerLectItems.darkenedMetal, 30, Items.lead, 60, Items.metaglass, 30, Items.phaseFabric, 10));
      health = 90 * size * size;
      size = 4;
      powerProduction = 1f;
    }};
  }
}
