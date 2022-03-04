package enerlect;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;
import enerlect.*;
import enerlect.content.*;

public class EnerLect extends Mod{
	public EnerLect(){}
	// load mod contents
	@Override
	public void loadContent(){
    new EnerLectItems().load();
    new EnerLectBlocks().load();
	}
}
class Kacang extends Mod{
	public Kacang(){}
	// a
	@Override
	public void loadContent(){
	new KacangBlocks().load();
	}
}
