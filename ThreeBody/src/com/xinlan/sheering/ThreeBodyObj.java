package com.xinlan.sheering;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class ThreeBodyObj extends MovingObject
{
    protected Texture texture;
    protected Sprite mSprite;
    protected ThreeBodyApp mContext;
    protected Vector2 force = new Vector2();
    
    public ThreeBodyObj(ThreeBodyApp mContext)
    {
        this.mContext = mContext;
        texture = loadTexture();
        mSprite = new Sprite(texture);
        this.pos.set(100,50);
    }
    
    protected abstract Texture loadTexture();

    public void update(float delta)
    {
        Vector2 force = calculateForce();
        force.scl(1 / this.mass);
        force.scl(delta);
        this.velocity.add(force);
        this.pos.add(this.velocity.cpy().scl(delta));

        if (this.velocity.len() > 0.2f)
        {
            heading = this.velocity.cpy().nor();
            siding = this.heading.cpy().rotate90(-1).nor();
        }
        else
        {
            this.velocity.set(0, 0);
        }
        this.wapWorld();

        mSprite.setPosition(pos.x, pos.y);
    }
    
    protected abstract Vector2 calculateForce();

    public void draw(SpriteBatch batch)
    {
        mSprite.draw(batch);
    }
    
    public void dispose()
    {
        texture.dispose();
    }
}//end class
