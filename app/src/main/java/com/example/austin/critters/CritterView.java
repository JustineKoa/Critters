package com.example.austin.critters;

import android.view.View;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Austin on 8/1/17.
 */

public class CritterView extends View implements View.OnTouchListener, Runnable{
    private final int DELAY = 50;
    private CritterController critterController;
    private boolean running = false;
    private int currentCritter = 0;

    public CritterView(Context context) {
        this(context, null);
    }

    public CritterView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);

        this.setOnTouchListener(this);

        critterController = new CritterController();

        new Thread(this).start();
    }

    @Override
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        for (Critter c : critterController.getCritters()) {
            canvas.drawRect(c.getX(), c.getY(), c.getX() + c.getLength(), c.getY() + c.getLength()
                    , c.getColor());
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent e)
    {
        if (e.getAction() == MotionEvent.ACTION_DOWN)
        {
            int x = (int)e.getX();
            int y = (int)e.getY();

            //Implement
            critterController.addCritter(x,y,currentCritter);
        }

        postInvalidate();

        return true;
    }

    @Override
    public void run()
    {
        while(true)
        {
            if (running) {
                critterController.critterInteract();

                try {
                    Thread.sleep(DELAY);
                } catch (Exception ex) {
                }

                postInvalidate();
            }
        }
    }

    public void start()
    {
        running = true;
    }

    public void stop()
    {
        running = false;
    }


    public void setCritter(int c){
        currentCritter = c;
    }
}



