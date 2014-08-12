package com.xinlan.sheering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BlueObj extends ThreeBodyObj
{

    public BlueObj(ThreeBodyApp mContext)
    {
        super(mContext);
        this.pos.set(7000, 2200);
        this.velocity.set(-300,0);
    }

    @Override
    protected Texture loadTexture()
    {
        return new Texture(Gdx.files.internal("asset/blue.png"));
    }

    @Override
    protected Vector2 calculateForce()
    {
        this.force.set(0, 0);
        Vector2 redPos = this.mContext.red.pos.cpy();
        redPos.sub(this.pos);
        if (redPos.len() <= 1)
        {
            force.add(0, 0);
        }
        else
        {
            float len2 = redPos.len2();
            redPos.scl(this.mass).scl(this.mContext.red.mass);
            redPos.scl(G);
            redPos.scl(1f / len2);
            force.add(redPos);
        }

        Vector2 blackPos = this.mContext.black.pos.cpy();
        blackPos.sub(this.pos);
        if (redPos.len() <= 1)
        {
            force.add(0, 0);
        }
        else
        {
            float len2 = blackPos.len2();
            blackPos.scl(this.mass).scl(this.mContext.black.mass);
            blackPos.scl(G);
            blackPos.scl(1f / len2);
            force.add(blackPos);
        }

        return this.force;
    }
}// end class
