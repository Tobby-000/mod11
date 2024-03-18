package cn.komonmc.register;

import cn.komonmc.TestMod;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;


public class ModItem {
    public static Item registerItem(String name, Item item, RegistryKey<ItemGroup>... itemGroups){
        Item registereditem= Registry.register(Registries.ITEM,new Identifier(TestMod.ModID,name),item);
        for(RegistryKey<ItemGroup> itemGroup : itemGroups) {
            ItemGroupEvents.modifyEntriesEvent(itemGroup).register(entries -> entries.add(registereditem));
        }
        return registereditem;
    }
}
