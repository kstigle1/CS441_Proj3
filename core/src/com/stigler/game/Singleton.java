package com.stigler.game;

public class Singleton
{
    private static Singleton single = null;

    int screenH, screenW; //2080, 1080
    int dx=0, dy=0, x, y, picH=250, picW=250;


    private Singleton()
    {
        //
    }

    public static Singleton getInstance()
    {
        if (Singleton.single == null)
        {
            Singleton.single = new Singleton();
        }
        return Singleton.single;
    }
}
