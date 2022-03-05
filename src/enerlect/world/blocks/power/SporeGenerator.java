package mindustry.world.blocks.power;

import arc.*;
import arc.graphics.*;
import arc.math.*;
import mindustry.content.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.graphics.*;
import mindustry.graphics.Pal;
import mindustry.world.*;
import mindustry.world.meta.*;

public class SporeGenerator extends ThermalGenerator{
    public Effect generateEffect = Fx.none;
    public float effectChance = 0.078f;
    public Attribute attribute = Attribute.none;

    public SporeGenerator(String name){
        super(name);
    }

    @Override
    public void init(){
        super.init();
        //proper light clipping
        clipSize = Math.max(clipSize, 45f * size * 2f * 2f);
    }

    @Override
    public void setStats(){
        super.setStats();

        stats.add(Stat.tiles, attribute, floating, size * size, false);
    }

    @Override
    public void drawPlace(int x, int y, int rotation, boolean valid){
        super.drawPlace(x, y, rotation, valid);

        drawPlaceText(Core.bundle.formatFloat("bar.efficiency", sumAttribute(attribute, x, y) * 100, 1), x, y, valid);
    }

    public class SporeGeneratorBuild extends ThermalGeneratorBuild{
        public float sum;

        @Override
        public void updateTile(){
            productionEfficiency = sum + attribute.env();

            if(productionEfficiency > 0.1f && Mathf.chanceDelta(effectChance)){
                generateEffect.at(x + Mathf.range(3f), y + Mathf.range(3f));
            }
        }

        @Override
        public void drawLight(){
            Drawf.light(team, x, y, (40f + Mathf.absin(10f, 5f)) * Math.min(productionEfficiency, 2f) * size, Pal.spore, 0.4f);
        }

        @Override
        public void onProximityAdded(){
            super.onProximityAdded();

            sum = sumAttribute(attribute, tile.x, tile.y);
        }
    }
}
