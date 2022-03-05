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
    // crafters
    yellowsteelForge,
    // turrets
    implosion, aftab, /* balabad, */ 
    // distr
    leadconveyor, metaglassconveyor,
    // power
    spectralGenerator, lunarPanel, mediumLunarPanel, largeLunarPanel, hugeLunarPanel, biostoneGenerator;
  @Override
  public void load() {
    // reg crafters
    yellowsteelForge = new GenericCrafter("yellowsteel-forge"){{
      requirements(Category.crafting, with(Items.copper, 80, Items.lead, 45, Items.graphite, 57));
      craftEffect = Fx.pulverizeMedium;
      outputItem = new ItemStack(EnerLectItems.yellowsteel, 1);
      craftTime = 60f;
      size = 2;
      hasItems = true;
      consumes.items(with(Items.copper, 2, Items.silicon, 1, Items.coal, 1));
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
    // distr start
    leadconveyor = new Conveyor("lead-conveyor"){{
      requirements(Category.distribution, with(Items.copper, 1), true);
      health = 45;
      speed = 0.04f;
      displayedSpeed = 4.3f;
      buildCostMultiplier = 2f;
    }};
    metaglassconveyor = new Conveyor("metaglass-conveyor"){{
      requirements(Category.distribution, with(Items.copper, 1), true);
      health = 45;
      speed = 0.04f;
      displayedSpeed = 4.3f;
      buildCostMultiplier = 2f;
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
    }}; */ //disabled due to nullpointerexception
    
    lunarPanel = new LunarGenerator("lunar-panel"){{
      requirements(Category.power, with(Items.silicon, 15, EnerLectItems.darkenedMetal, 10, Items.lead, 15));
      health = 40 * size * size;
      size = 2;
      powerProduction = 0.27f;
    }};
    
    mediumLunarPanel = new LunarGenerator("medium-lunar-panel"){{
      requirements(Category.power, with(Items.silicon, 30, EnerLectItems.darkenedMetal, 15, Items.lead, 30, Items.metaglass, 15));
      health = 40 * size * size;
      size = 3;
      powerProduction = 0.7f;
    }};

    largeLunarPanel = new LunarGenerator("large-lunar-panel"){{
      requirements(Category.power, with(Items.silicon, 60, EnerLectItems.darkenedMetal, 30, Items.lead, 60, Items.metaglass, 30, Items.phaseFabric, 10));
      health = 40 * size * size;
      size = 4;
      powerProduction = 1f;
    }};
    
    hugeLunarPanel = new LunarGenerator("huge-lunar-panel"){{
      requirements(Category.power, with(Items.silicon, 100, EnerLectItems.darkenedMetal, 70, Items.lead, 100, Items.metaglass, 60, Items.phaseFabric, 30, Items.surgeAlloy, 10));
      health = 40 * size * size;
      size = 5;
      powerProduction = 1.5f;
    }};
    biostoneGenerator = new SporeGenerator("biostone-generator"){{
      requirements(Category.power, with(Items.copper, 40, Items.graphite, 35, Items.lead, 50, Items.silicon, 35, Items.metaglass, 40));
      powerProduction = 2.15f;
      generateEffect = EnerLectFx.biostonegenerate;
      size = 2;
      floating = true;
      ambientSound = Sounds.hum;
      ambientSoundVolume = 0.06f;
    }};
  }
}
