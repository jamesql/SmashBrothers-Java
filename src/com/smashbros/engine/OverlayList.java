package com.smashbros.engine;
import java.util.ArrayList;

import com.smashbros.interfaces.IDrawable;
import com.smashbros.interfaces.IRunnable;
import com.smashbros.objects.HealthBar;

public class OverlayList implements IRunnable{
    private static ArrayList<Overlay> list = new ArrayList<>();
    
    public static Overlay addOverlay(Overlay o) {
        list.add(o);
        return o;
    }

    public static HealthBar removeHealthBar(HealthBar h) {
        list.remove(h);
        return h;
    }

    @Override
    public void run() {
        for (Overlay o : list) if (o instanceof IDrawable) ((IDrawable) o ).draw();
        
    }

    static{
		Tick.addToLoop(new OverlayList());
    }
}

