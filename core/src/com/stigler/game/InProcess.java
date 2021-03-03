package com.stigler.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Timer;

public class InProcess implements InputProcessor
{
    Singleton single = Singleton.getInstance();
    long startTime, elapseTime;
    double multiDist;

    @Override
    public boolean keyDown(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyUp(int keycode)
    {
        return false;
    }

    @Override
    public boolean keyTyped(char character)
    {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button)
    {

        if (screenX > (single.screenW/2) - (single.picW1/2) && screenX < (single.screenW/2) + (single.picW1/2) &&
            screenY < single.screenH - (single.screenH/7) && screenY > (single.screenH - (single.screenH/7)) - single.picH)
        {
            //single.y1 += 950;
            startTime = TimeUtils.millis();
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        elapseTime = TimeUtils.timeSinceMillis(startTime);
        multiDist = elapseTime*190.0;
        single.moveTo = (int) multiDist/1000;
        if (single.moveTo <= 50)
        {
            single.moveTo = 50;
        }
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer)
    {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY)
    {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY)
    {
        return false;
    }
}
