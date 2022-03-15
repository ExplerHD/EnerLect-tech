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
  });
  dmfCrafted = new Effect(30f, e -> {
		for(int i = 0; i < 5; i++) {
      Drawf.tri(e.x, e.y, 8, 25 * e.fout(), i * (360/5) + 90 * e.fin());
		}
    Angles.randLenVectors(e.id, 10, 40 * e.finpow(), (x, y) -> {
			Fill.circle(e.x + x, e.y + y, Interp.sine.apply(e.fin() * 2));
		});
	});
}
