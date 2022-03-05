package enerlect.world.blocks.defense.turrets;

import arc.*;
import arc.scene.ui.layout.*;
import arc.struct.*;
import arc.util.io.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.entities.bullet.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.ui.*;
import mindustry.world.consumers.*;
import mindustry.world.meta.*;
import mindustry.world.blocks.defense.turrets.*;
import mindustry.world.blocks.defense.*;
import enerlect.content.*;
import enerlect.world.blocks.*;
import mindustry.Vars.*;
import mindustry.ctype.*;
import mindustry.ctype.Content;
import mindustry.ctype.ContentList;
import mindustry.ctype.ContentType;
import mindustry.core.*;
import static mindustry.Vars.*;

public class RandomTurret extends ItemTurret{ // kool random turret code
    public ObjectMap<Item, BulletType> ammoTypes = new ObjectMap<>();

    public RandomTurret(String name){
        super(name);
        hasItems = true;
    }

    @Override
    public void setStats(){
        super.setStats();
        stats.add(Stat.ammo, StatValues.ammo(ObjectMap.of(this, shootType)));
    }

    /** Makes copies of all bullets and limits their range. */
    public void limitRange(){
        limitRange(0f);
    }

    /** Makes copies of all bullets and limits their range. */
    public void limitRange(float margin){
        for(var entry : ammoTypes.copy().entries()){
            var copy = entry.value.copy();
            copy.lifetime = (range + margin) / copy.speed;
            ammoTypes.put(entry.key, copy);
        }
    }
	
    @Override
    public void init(){
        consumes.add(new ConsumeItemFilter(i -> ammoTypes.containsKey(i)){
            @Override
            public void build(Building tile, Table table){
                MultiReqImage image = new MultiReqImage();
                content.items().each(i -> filter.get(i) && i.unlockedNow(), item -> image.add(new ReqImage(new ItemImage(item.uiIcon),
                () -> tile instanceof RandomTurretBuild it && !it.ammo.isEmpty() && ((RandomEntry)it.ammo.peek()).item == item)));

                table.add(image).size(8 * 4);
            }

            @Override
            public boolean valid(Building entity){
                //valid when there's any ammo in the turret
                return entity instanceof RandomTurretBuild it && !it.ammo.isEmpty();
            }

            @Override
            public void display(Stats stats){
                //don't display
            }
        });

        super.init();
    }

    public class RandomTurretBuild extends ItemTurretBuild{

        @Override
        public void onProximityAdded(){
            super.onProximityAdded();

            if(cheating() && ammo.size > 0){
                handleItem(this, ammoTypes.entries().next().key);
            }
        }

        @Override
        public void updateTile(){
            unit.ammo((float)unit.type().ammoCapacity * totalAmmo / maxAmmo);

            super.updateTile();
        }

        @Override
        public void displayBars(Table bars){
            super.displayBars(bars);

            bars.add(new Bar("stat.ammo", Pal.ammo, () -> (float)totalAmmo / maxAmmo)).growX();
            bars.row();
        }

        @Override
        public int acceptStack(Item item, int amount, Teamc source){
            BulletType type = ammoTypes.get(item);

            if(type == null) return 0;

            return Math.min((int)((maxAmmo - totalAmmo)), amount);
        }

        @Override
        public void handleStack(Item item, int amount, Teamc source){
            for(int i = 0; i < amount; i++){
                handleItem(null, item);
            }
        }

        @Override
        public int removeStack(Item item, int amount){
            return 1;
        }

        @Override
        public void handleItem(Building source, Item item){

            if(item == Items.pyratite){
                Events.fire(Trigger.flameAmmo);
            }

            BulletType type = ammoTypes.get(item);
            if(type == null) return;
            totalAmmo += type.ammoMultiplier;

            ammo.add(new ItemEntry(item, (int)type.ammoMultiplier));
        }

        @Override
        public boolean acceptItem(Building source, Item item){
            return ammoTypes.get(item) != null && totalAmmo + ammoTypes.get(item).ammoMultiplier <= maxAmmo;
        }

        @Override
        public byte version(){
            return 2;
        }

        @Override
        public void write(Writes write){
            super.write(write);
            write.b(ammo.size);
            for(AmmoEntry entry : ammo){
                ItemEntry i = (ItemEntry)entry;
                write.s(i.item.id);
                write.s(i.amount);
            }
        }

        @Override
        public void read(Reads read, byte revision){
            super.read(read, revision);
            ammo.clear();
            totalAmmo = 0;
            int amount = read.ub();
            for(int i = 0; i < amount; i++){
                Item item = Vars.content.item(revision < 2 ? read.ub() : read.s());
                short a = read.s();

                if(item != null){
                    totalAmmo += a;
                    ammo.add(new RandomEntry(item, a));
                }
            }
		}
		
		@Override
        public BulletType useAmmo(){
            return shootType;
        }

        @Override
        public boolean hasAmmo(){
            return true;
        }

        @Override
        public BulletType peekAmmo(){
            return shootType;
		}
    }

    public class RandomEntry extends ItemEntry{
        public Item item;

        RandomEntry(Item item, int amount){
            this.item = item;
            this.amount = amount;
        }

        @Override
        public BulletType type(){
            return ammoTypes.get(item);
        }
    }
}
