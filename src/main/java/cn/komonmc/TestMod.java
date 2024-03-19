package cn.komonmc;

import cn.komonmc.Entity.FCEntity;
import cn.komonmc.Items.Firecracker;
import cn.komonmc.Items.TNTPRO;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import net.minecraft.entity.EntityType;
import org.slf4j.LoggerFactory;
import static cn.komonmc.register.ModItem.registerItem;

public class TestMod implements ModInitializer {
	public static String ModID="testmod";

	public static final Item TNTPRO=new TNTPRO(new Item.Settings().maxDamage(100));
	public static final Item fc=new Firecracker(new Item.Settings().maxDamage(100));
	public static final EntityType<FCEntity> FCE = Registry.register(
			Registries.ENTITY_TYPE,
			new Identifier(ModID, "firecrackerentity"),
			FabricEntityTypeBuilder.<FCEntity>create(SpawnGroup.MISC, FCEntity::new)
					.dimensions(EntityDimensions.fixed(0.15F, 0.15F))
					.disableSaving().trackRangeChunks(16)
					.trackRangeBlocks(16)
					.trackedUpdateRate(8)
					.build()
	);
	public static final Logger LOGGER = LoggerFactory.getLogger("testmod");

	@Override
	public void onInitialize() {
		Registry.register(Registries.ITEM, new Identifier(ModID, "tntpro"), TNTPRO);
		Registry.register(Registries.ITEM, new Identifier(ModID, "firecracker"), fc);
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(TNTPRO);
		});
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(fc);
		});
		LOGGER.info("Hello Fabric world!");
	}
}