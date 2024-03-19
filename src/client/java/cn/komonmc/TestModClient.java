package cn.komonmc;

import cn.komonmc.Render.fcModel;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.entity.projectile.thrown.SnowballEntity;

public class TestModClient implements ClientModInitializer {
		@Override
		public void onInitializeClient() {
			fcModel.register();
			EntityRendererRegistry.register(TestMod.FCE, FlyingItemEntityRenderer::new);
		}

}