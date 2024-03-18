package cn.komonmc.Items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Random;

import static net.minecraft.util.math.MathHelper.nextGaussian;

public class TNTPRO extends Item{
    public  TNTPRO(Item.Settings settings) {
        super(settings);
    }
    /*@Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand)  {
        ItemStack stack = user.getStackInHand(hand);
        if (!world.isClient){

            //PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;
            //World world=context.getWorld();
            user.sendMessage(Text.literal("ok"));
            TntEntity a=new TntEntity(world,user.getX(), user.getY(), user.getZ(),null);
            //a.setPos(user.getX(), user.getEyeY(), user.getZ());
            world.spawnEntity(a);
        }
        return TypedActionResult.consume(stack);
    }*/
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            BlockPos pos = context.getBlockPos();
            PlayerEntity player= context.getPlayer();
            World world=context.getWorld();
            float yaw=player.getYaw();
            float pit=player.getPitch();
            double px=pos.getX();
            double py=pos.getY();
            double pz=pos.getZ();
            if((yaw>90&&yaw<180)||(yaw<-90&&yaw>-180))
                pz+=1;
            else if((yaw<90&&yaw>0)||(yaw>-90&&yaw<0))
                pz-=1;
            if(yaw>0&&yaw<180)
                px+=1;
            else if(yaw<0&&yaw>-180)
                px-=1;
            if(pit<0)
                py-=1;
            else if(pit>0)
                py+=1;
            Random b=new Random();
            ArrayList<TntEntity> arr=new ArrayList<>();
            for(int i=0;i<5;i++) {
                arr.add(new TntEntity(world,px,py,pz,null));
                arr.get(i).setPos(px+b.nextGaussian()*0.3,py+b.nextGaussian()*0.3,pz+b.nextGaussian()*0.3);
                world.spawnEntity(arr.get(i));
            }
            player.sendMessage(Text.literal("ok"));
        }
        return ActionResult.SUCCESS;
    }
}
