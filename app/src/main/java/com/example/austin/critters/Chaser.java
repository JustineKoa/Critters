package com.example.austin.critters;

import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by justinekoa on 8/4/17.
 */

public class Chaser extends Critter {

    public Chaser(int x, int y, Paint color, int length)
    {
        super(x,y,color,length);
    }

    public void reactTo(Critter C, double width, double height)
    {
        double distancex = C.getX() - x;
        double distancey = C.getY()- y;
        if (distancex > 0 && distancey > 0) {
            x += 5;
            y += 5;
        }
        else if (distancex < 0 && distancey < 0)
        {
            x -= 5;
            y -= 5;
        }
        else if (distancex > 0 && distancey < 0)
        {
            x += 5;
            y -= 5;
        }
        else if (distancex < 0 && distancey > 0)
        {
            x -= 5;
            y += 5;
        }

        checkBounds(width,height);

    }

}
