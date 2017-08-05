package com.example.austin.critters;

import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

/**
 * Created by Austin on 8/1/17.
 */


public class CritterController {
    private ArrayList<Critter> critters;
    private final int LENGTH = 50;

    /** Some constants that can be used throughout the class */
    private static final int RUNNER = 0;
    private static final int CHASER = 1;
    private static final int RANDOM = 2;
    private static final int CUSTOM = 3;

    public CritterController()
    {
        critters = new ArrayList<Critter>();
    }

    public ArrayList<Critter> getCritters()
    {
        return critters;
    }

    public void critterInteract()
    {
        for(Critter c : critters)
        {
            //Implement
            Critter d = c.findClosest(critters, c);
            c.reactTo(d);
        }

    }

    public void addCritter(int x, int y, int t)
    {
        if (t == RUNNER){
            Paint green = new Paint();
            green.setStyle(Paint.Style.FILL);
            green.setColor(Color.GREEN);
            critters.add(new Runner(x,y,green,LENGTH));
        }
         else if (t == CHASER){
             Paint red = new Paint();
             red.setStyle(Paint.Style.FILL);
             red.setColor(Color.RED);
             critters.add(new Chaser(x,y,red,LENGTH));
         }
         else if (t == RANDOM){
            Paint blue = new Paint();
            blue.setStyle(Paint.Style.FILL);
            blue.setColor(Color.BLUE);
            critters.add(new Random(x,y,blue,LENGTH));
         }
         /*
        else if (t == CUSTOM){
            critters.add(new Custom());
        }*/
    }
}
