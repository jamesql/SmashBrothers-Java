package com.smashbros.engine;

import java.util.ArrayList;

import com.smashbros.interfaces.IDrawable;
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
	
}
