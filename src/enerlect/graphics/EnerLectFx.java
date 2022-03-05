package enerlect.graphics;

import arc.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.math.*;
import arc.math.geom.*;
import arc.struct.*;
import arc.util.*;
import mindustry.entities.*;
import mindustry.game.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.type.*;
import mindustry.world.Block;

import static arc.graphics.g2d.Draw.rect;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.*;
import static mindustry.Vars.*;

public class EnerLectFx{
  
  public static final Effect
    
  implosion = new Effect(60f, e -> {
    color(Color.blue);
    stroke(3f * e.fout());
    Lines.poly(e.x, e.y, 6, e.rotation, 30f * e.fout());
  }),
  biostonegenerate = new Effect(90, e -> {
    color(Color.valueOf("97d96f"));
    alpha(e.fslope());

    rand.setSeed(e.id);
    for(int i = 0; i < 2; i++){
      v.trns(rand.random(360f), rand.random(e.finpow() * 9f)).add(e.x, e.y);
      Fill.circle(v.x, v.y, rand.random(1.4f, 2.4f));
    }
  }).layer(Layer.bullet - 1f);
}

