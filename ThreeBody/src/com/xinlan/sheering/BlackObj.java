package com.xinlan.sheering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BlackObj extends ThreeBodyObj
{

    public BlackObj(ThreeBodyApp mContext)
    {
        super(mContext);
        this.pos.set(4800, 3200);
        this.velocity.set(-100, 300);
    }

    @Override
    protected Texture loadTexture()
    {
        return new Texture(Gdx.files.internal("asset/black.png"));
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

        Vector2 bluePos = this.mContext.blue.pos.cpy();
        bluePos.sub(this.pos);
        if (bluePos.len() <= 1)
        {
            force.add(0, 0);
        }
        else
        {
            float len2 = bluePos.len2();
            bluePos.scl(this.mass).scl(this.mContext.blue.mass);
            bluePos.scl(G);
            bluePos.scl(1f / len2);
            force.add(bluePos);
        }

        return this.force;
    }
}// end class
