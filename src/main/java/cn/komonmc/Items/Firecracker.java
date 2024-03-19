package cn.komonmc.Items;
import cn.komonmc.TestMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Firecracker extends Item{
    public  Firecracker(Item.Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add(Text.literal("扔出去  然后Boom").formatted(Formatting.RED));
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (!context.getWorld().isClient) {
            BlockPos pos = context.getBlockPos();
            PlayerEntity player= context.getPlayer();
            World world=context.getWorld();
            float yaw=player.getYaw();
            float pit=player.getPitch();
            double px=player.getX();
            double py=player.getEyeY();
            double pz=player.getZ();
            player.getInventory().remove((stack1 -> stack1.isOf(TestMod.fc)), 1, player.getInventory());
        }
        return ActionResult.SUCCESS;
    }
}
