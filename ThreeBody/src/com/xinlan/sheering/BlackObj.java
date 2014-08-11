package com.xinlan.sheering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BlackObj extends ThreeBodyObj
{

    public BlackObj(ThreeBodyApp mContext)
    {
        super(mContext);
        this.pos.set(100, 60);
    }

    @Override
    protected Texture loadTexture()
    {
        return new Texture(Gdx.files.internal("asset/black.png"));
    }

    @Override
    protected Vector2 calculateForce()
    {
        return this.force;
    }
}//end class
