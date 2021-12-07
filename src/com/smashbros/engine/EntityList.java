package com.smashbros.engine;

import java.util.ArrayList;

import com.smashbros.enums.Direction;
import com.smashbros.interfaces.IDrawable;
import com.smashbros.interfaces.IHitbox;
import com.smashbros.interfaces.IRunnable;
import com.smashbros.objects.Hitbox;
import com.smashbros.objects.Character;

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
	
	public static Entity getById(int eId) {
		return list.get(eId-1);
	}
	
	public static boolean isColliding(Entity e) {
		if (!(e instanceof IHitbox)) return false; 
		
		IHitbox h = (IHitbox) e;
		
		for (Entity f : list)  {
			if (!(f instanceof IHitbox) || f.eIndex == e.eIndex || f.type.equals("character")) continue;
			else if (((IHitbox) f).getHitbox().isColliding(h.getHitbox())) {
				if (e.type.equals("character") && f.type.equals("platform")) 
					((Character) e).resetJump();
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean isCollidingGhostBox(int entityId, Hitbox h, int v) {
		for (Entity e : list) {
			if (!(e instanceof IHitbox) || e.eIndex == entityId || e.type.equals("character")) continue;
			else if (((IHitbox) e).getHitbox().isColliding(h)) {
				if (e.type.equals("platform")) {
					((Character) getById(entityId)).resetJump();
					if (v == 3) {
						h.changeY(-3);
						continue;
					}
				}
				return true;
			}
		}
		
		return false;
	}
	
	public static boolean checkAttackingHits(Character r) {
		for (Entity e : list) {
			if (!(e instanceof Character) || e.eIndex == r.eIndex) continue;
			Character c = (Character) e;
			if (c.getHitbox().isColliding(r.getHitbox())) {
				c.setHealth(c.getHealth() + 1);
				c.knockback(Direction.RIGHT);
			}
			
		}
		return false;
	}
	
}
