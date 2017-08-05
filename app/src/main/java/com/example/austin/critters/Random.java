package com.example.austin.critters;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by justinekoa on 8/3/17.
 */

public class Random extends Critter
{
    public Random(int x, int y, Paint color, int length)
    {
        super(x,y,color,length);
    }

    public void reactTo(Critter c)
    {
        //implement
        java.util.Random random = new java.util.Random();
        x += random.nextInt(41) - 20;
        y += random.nextInt(41) - 20;
    }

}
