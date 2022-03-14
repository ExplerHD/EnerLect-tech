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
import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.*;
import enerlect.content.*;

import static mindustry.type.ItemStack.with;

import enerlect.content.*;
import enerlect.graphics.*;
import enerlect.world.blocks.*;
import enerlect.world.blocks.power.*;

public class KacangBlocks implements ContentList{
	public static Block 
	/* code test */ test,
	/* turrets */ binara, udam, rudu;
	@Override
  public void load(){
		test = new AirBlock("test");
		binara = new ItemTurret("binara"){{
			 requirements(Category.turret, with(Items.copper, 28, KacangItems.kacang, 12));
			 ammo(
				 KacangItems.kacang, Bullets.standardDense,
				 KacangItems.kacangHijau, Bullets.fragPlastic
			 );
			 health = 200;
			 range = 192f;
			 recoilAmount = 0.03f;
			 targetAir = true;
			 targetGround = true;
			 reloadTime = 15f;
			 rotateSpeed = 5.5f;
			 limitRange(0f);
		}};
		udam = new ItemTurret("udam"){{
			requirements(Category.turret, with(Items.copper, 28, Items.lead, 15, KacangItems.kacang, 20));
			ammo(KacangItems.kacang, new FlakBulletType(4f, 7){{
            			lifetime = 60f;
            			ammoMultiplier = 5f;
            			shootEffect = Fx.shootSmall;
            			reloadMultiplier = 0.5f;
            			width = height = 8f;
            			hitEffect = Fx.flakExplosion;
            			splashDamage = 27f * 1.5f;
            			splashDamageRadius = 35f;
        			}}
			);
			health = 250;
			range = 200f;
			recoilAmount = 0.01f;
			targetAir = true;
			targetGround = true;
			reloadTime = 15f;
			rotateSpeed = 5.7f;
			limitRange(0f);
		}};
		rudu = new PowerTurret("rudu"){{
            		requirements(Category.turret, with(Items.copper, 75, Items.lead, 25, KacangItems.kacang, 15));
            		shootType = new LightningBulletType(){{
                		damage = 40;
                		lightningLength = 50;
                		collidesAir = true;
                		ammoMultiplier = 1f;
            		}};
            		reloadTime = 28f;
            		shootCone = 40f;
            		rotateSpeed = 9f;
            		powerUse = 3f;
            		targetAir = true;
            		range = 90f;
            		shootEffect = Fx.lightningShoot;
            		heatColor = Color.red;
            		recoilAmount = 1f;
            		size = 2;
            		health = 520;
            		shootSound = Sounds.spark;
        	}};
  	}
}
