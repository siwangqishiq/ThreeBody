package com.xinlan.sheering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class RedObj extends ThreeBodyObj
{

    public RedObj(ThreeBodyApp mContext)
    {
        super(mContext);
        this.pos.set(800,400);
    }

    @Override
    protected Texture loadTexture()
    {
        return new Texture(Gdx.files.internal("asset/red.png"));
    }

    @Override
    protected Vector2 calculateForce()
    {
        return force;
    }
}//end class
