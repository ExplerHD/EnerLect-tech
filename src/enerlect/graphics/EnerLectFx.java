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
  private static final Rand rand = new Rand();
  private static final Vec2 v = new Vec2();

  public static final Effect

  none = new Effect(0, 0f, e -> {}),
  implosion = new Effect(60f, 70f, e -> {
    color(Color.blue);
    stroke(3f * e.fout());
    Fill.poly(e.x, e.y, 6, e.rotation, e.fin());
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

