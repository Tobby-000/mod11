package cn.komonmc.Render;


import cn.komonmc.TestMod;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.util.Identifier;

public class fcModel {
        public static void register() {

            ModelPredicateProviderRegistry.register(TestMod.fc, new Identifier(TestMod.ModID,"load"),
                    (itemStack, clientWorld, livingEntity, seed) -> {
                        if (livingEntity!=null && livingEntity.isUsingItem() && itemStack.isOf(TestMod.fc) && livingEntity.getActiveItem().equals(itemStack)) {
                            return (float)(itemStack.getMaxUseTime() - livingEntity.getItemUseTimeLeft()) / (float)itemStack.getMaxUseTime();
                        } else {
                            return 0.0F;
                        }
                    }
            );

            ModelPredicateProviderRegistry.register(TestMod.fc, new Identifier(TestMod.ModID, "loaded"),
                    (itemStack, clientWorld, livingEntity, seed) -> {
                        if (true) {
                            if (livingEntity==null) {
                                return 1.0F;
                            } else if (!livingEntity.isUsingItem() || !livingEntity.getActiveItem().isOf(TestMod.fc)) {
                                return 1.0F;
                            } else {
                                return 0.0F;
                            }
                        } else {
                            return 0.0F;
                        }
                    });
        }
    }

