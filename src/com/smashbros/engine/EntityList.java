package com.smashbros.engine;

import java.util.ArrayList;

import com.smashbros.interfaces.IDrawable;
import com.smashbros.interfaces.IHitbox;
import com.smashbros.interfaces.IRunnable;

public class EntityList implements IRunnable {
	private static ArrayList<Entity> list;
	
	public static void addEntity(Entity e) {
		list.add(e);
	}
	
	static {
		list = new ArrayList<Entity>();
		Tick.addToLoop(new EntityList());
	}

	@Override
	public void run() {
		for (Entity e : list) if (e instanceof IDrawable) ((IDrawable) e).draw();
	}
	
	public static boolean isColliding(Entity e) {
		if (!(e instanceof IHitbox)) return false; 
		
		IHitbox h = (IHitbox) e;
		
		for (Entity f : list) 
			if (!(f instanceof IHitbox) || f.eIndex == e.eIndex || f.type.equals("character")) continue;
			else if (((IHitbox) f).getHitbox().isColliding(h.getHitbox())) return true;
		
		return false;
	}
	
}
