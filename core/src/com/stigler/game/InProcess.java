package com.stigler.game;

import com.badlogic.gdx.InputProcessor;

public class InProcess implements InputProcessor
{
    Singleton single = Singleton.getInstance();

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
        System.out.println(single.screenW + " " + single.screenH);
        if (screenX < single.screenW && screenY > (single.screenH)-(single.picH))
        {
            single.x += 50;
            single.y += 50;
            return true;
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button)
    {
        return false;
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
