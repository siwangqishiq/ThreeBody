package com.xinlan.sheering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class RedObj extends ThreeBodyObj
{

    public RedObj(ThreeBodyApp mContext)
    {
        super(mContext);
        this.pos.set(6400, 4000);
        this.velocity.set(400,-110);
    }

    @Override
    protected Texture loadTexture()
    {
        return new Texture(Gdx.files.internal("asset/red.png"));
    }

    @Override
    protected Vector2 calculateForce()
    {
        this.force.set(0,0);
        Vector2 blackPos = this.mContext.black.pos.cpy();
        blackPos.sub(this.pos);
        if(blackPos.len()<=0)
        {
            force.add(0,0);
        }else{
            float len2 = blackPos.len2();
            blackPos.scl(this.mass).scl(this.mContext.black.mass);
            blackPos.scl(G);
            blackPos.scl(1f/len2);
            force.add(blackPos);
        }
        
        Vector2 bluePos = this.mContext.black.pos.cpy();
        bluePos.sub(this.pos);
        if(bluePos.len()<=0)
        {
            force.add(0,0);
        }else{
            float len2 = bluePos.len2();
            bluePos.scl(this.mass).scl(this.mContext.blue.mass);
            bluePos.scl(G);
            bluePos.scl(1f/len2);
            force.add(bluePos);
        }
        
        return force;
    }
}//end class
