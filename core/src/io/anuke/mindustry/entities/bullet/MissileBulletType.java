package io.anuke.mindustry.entities.bullet;

import io.anuke.arc.graphics.Color;
import io.anuke.arc.math.Mathf;
import io.anuke.arc.util.Time;
import io.anuke.mindustry.content.Fx;
import io.anuke.mindustry.entities.Effects;
import io.anuke.mindustry.graphics.Pal;

public class MissileBulletType extends BasicBulletType{
    protected Color trailColor = Pal.missileYellowBack;

    protected float weaveScale = 0f;
    protected float weaveMag = -1f;

    public MissileBulletType(float speed, float damage, String bulletSprite){
        super(speed, damage, bulletSprite);
        backColor = Pal.missileYellowBack;
        frontColor = Pal.missileYellow;
        homingPower = 7f;
    }

    @Override
    public void update(Bullet b){
        super.update(b);

        if(Mathf.chance(Time.delta() * 0.2)){
            Effects.effect(Fx.missileTrail, trailColor, b.x, b.y, 2f);
        }

        if(weaveMag > 0){
            b.velocity().rotate(Mathf.sin(Time.time() + b.id * 4422, weaveScale, weaveMag));
        }
    }
}
