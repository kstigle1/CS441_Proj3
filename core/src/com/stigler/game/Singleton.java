package com.stigler.game;

public class Singleton
{
    private static Singleton single = null;

    int dx=0, dy=0, x=415, y=300, picH=250, picW=250;
    int screenH, screenW;

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
