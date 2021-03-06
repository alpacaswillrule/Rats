package com.github.alexthe666.rats.client.render.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

public class LayerGlowingOverlay implements LayerRenderer<EntityLiving> {
    private final RenderLiving ratRenderer;
    private final ResourceLocation texture;

    public LayerGlowingOverlay(RenderLiving ratRendererIn, ResourceLocation texture) {
        this.ratRenderer = ratRendererIn;
        this.texture = texture;
    }

    public void doRenderLayer(EntityLiving rat, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        this.ratRenderer.bindTexture(texture);
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthFunc(514);
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, 0.0F);
        GlStateManager.enableLighting();
        Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
        this.ratRenderer.getMainModel().render(rat, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
        this.ratRenderer.setLightmap(rat);
        GlStateManager.disableBlend();
        GlStateManager.depthFunc(515);
    }

    public boolean shouldCombineTextures() {
        return true;
    }
}
