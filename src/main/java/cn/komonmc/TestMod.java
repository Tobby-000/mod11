package cn.komonmc;

import cn.komonmc.Items.TNTPRO;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static cn.komonmc.register.ModItem.registerItem;

public class TestMod implements ModInitializer {.
	public static String ModID="testmod";

	public static final Item TNTPRO=new TNTPRO(new Item.Settings().maxDamage(100));

	public static final Logger LOGGER = LoggerFactory.getLogger("testmod");

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier(ModID, "tntpro"), TNTPRO);
		LOGGER.info("Hello Fabric world!");
	}
}