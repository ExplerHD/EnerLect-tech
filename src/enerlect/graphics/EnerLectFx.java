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
    Lines.poly(e.x, e.y, 6, e.rotation + e.fin());
  }).followParent(true);
}
