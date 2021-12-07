package com.smashbros.engine;
import java.util.ArrayList;

import com.smashbros.interfaces.IRunnable;

public class OverlayList implements IRunnable {
	private static ArrayList<Overlay> list = new ArrayList<Overlay>();
	
	public static void addOverlay(Overlay o) {
		list.add(o);
	}
	
	public void removeOverlay(Overlay o) {
		list.remove(o);
	}
	
	@Override
	public void run() {
		for (Overlay o : list) o.render();
	}
	
	static {
		Tick.addToLoop(new OverlayList());
	}
}
