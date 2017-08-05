package com.example.austin.critters;

import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Austin on 8/1/17.
 */

public abstract class Critter {
    protected int x;
    protected int y;
    protected int length;
    protected Paint color;

    public Critter(int x, int y, Paint color, int length)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.length = length;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public Paint getColor()
    {
        return color;
    }

    public int getLength()
    {
        return length;
    }

    public Critter findClosest(ArrayList<Critter> critters, Critter critter1)
    {
        double close = Math.sqrt(Math.pow((critters.get(0).getX() - critter1.getX()),2) + Math.pow((critters.get(0).getY()-critter1.getY()),2));
        Critter closest = critters.get(0);

        if (close == 0)
        {
            close = Math.sqrt(Math.pow((critters.get(1).getX() - critter1.getX()),2) + Math.pow((critters.get(1).getY()-critter1.getY()),2));
            closest = critters.get(1);
        }

        for (int i = 0; i < critters.size(); i++) {
            if (Math.sqrt(Math.pow((critters.get(i).getX() - critter1.getX()),2) + Math.pow((critters.get(i).getY() - critter1.getY()), 2)) != 0)
            {
                if (Math.sqrt(Math.pow((critters.get(i).getX() - critter1.getX()), 2) + Math.pow((critters.get(i).getY() - critter1.getY()), 2)) < close)
                {
                    close = Math.sqrt(Math.pow((critters.get(i).getX() - critter1.getX()), 2) + Math.pow((critters.get(i).getY() - critter1.getY()), 2));
                    closest = critters.get(i);
                }
            }
        }
        return closest;
    }

    /*
    * Method for how the Critter will react to the parameter Critter
    * */
    public abstract void reactTo(Critter c);

}
