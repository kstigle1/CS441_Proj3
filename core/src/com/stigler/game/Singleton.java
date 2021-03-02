package com.stigler.game;

public class Singleton
{
    private static Singleton single = null;

    int screenH, screenW; //2080, 1080 -> Pixel 3 API 30
    int dx1=0, dy1=0, x1, y1, picH=250, picW1=300, picW2=250, x2, y2;
    int moveTo, starting;
    boolean moving = false;
    int groundY, skyY;


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
