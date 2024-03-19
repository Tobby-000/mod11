package cn.komonmc.Entity;

import cn.komonmc.Items.Firecracker;
import cn.komonmc.TestMod;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FCEntity extends ThrownItemEntity {
    public  FCEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType,world);
    }
    public FCEntity(World world, LivingEntity owner) {
        super(TestMod.FCE, owner, world);
    }

    public FCEntity(World world, double x, double y, double z) {
        super(TestMod.FCE, x, y, z, world);
    }
    @Override
    protected Item getDefaultItem() {                     // 使用默认物品的模型
        return Items.POLISHED_BLACKSTONE_BUTTON;
    }
    @Override
    protected void onCollision(HitResult hitResult){
        super.onCollision(hitResult);
        Vec3d hitpos=hitResult.getPos();
        if(this.getWorld().isClient){

        }
    }
}
