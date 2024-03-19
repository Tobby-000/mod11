package cn.komonmc.Items;

import cn.komonmc.TestMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static net.minecraft.util.math.MathHelper.nextGaussian;

public class TNTPRO extends Item{
    public  TNTPRO(Item.Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.literal("右键方块即可生成8个TNT").formatted(Formatting.RED));
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos pos = context.getBlockPos();
        PlayerEntity player= context.getPlayer();
        World world=context.getWorld();
        float yaw=player.getYaw();
        float pit=player.getPitch();
        double px=pos.getX();
        double py=pos.getY();
        double pz=pos.getZ();
        if (!context.getWorld().isClient) {
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
            for(int i=0;i<8;i++) {
                arr.add(new TntEntity(world,px,py,pz,null));
                arr.get(i).setPos(px+b.nextGaussian()*0.3,py+b.nextGaussian()*0.3,pz+b.nextGaussian()*0.3);
                world.spawnEntity(arr.get(i));
            }
            player.getInventory().remove((stack1 -> stack1.isOf(TestMod.TNTPRO)), 1, player.getInventory());
        }else{
            for(int i=0;i<10;i++) {
                world.addParticle(ParticleTypes.CLOUD,
                        px, py , pz, 0.0D, 0.0D, 0.0D);
            }
        }
        return ActionResult.SUCCESS;
    }
}
