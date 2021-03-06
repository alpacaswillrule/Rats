package com.github.alexthe666.rats.server.items;

import com.github.alexthe666.rats.RatsMod;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ItemHat extends ItemArmor {
    private int modelIndex;
    private String name;

    public ItemHat(String name, int modelIndex) {
        super(RatsItemRegistry.HAT_ARMOR_MATERIAL, 0, EntityEquipmentSlot.HEAD);
        this.setCreativeTab(RatsMod.TAB);
        this.setTranslationKey("rats." + name);
        this.setRegistryName(RatsMod.MODID, name);
        this.modelIndex = modelIndex;
        this.name = name;
    }

    public ItemHat(ArmorMaterial mat, String name, int modelIndex) {
        super(mat, 0, EntityEquipmentSlot.HEAD);
        this.setCreativeTab(RatsMod.TAB);
        this.setTranslationKey("rats." + name);
        this.setRegistryName(RatsMod.MODID, name);
        this.modelIndex = modelIndex;
        this.name = name;
    }

    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (stack.getItem() == RatsItemRegistry.ARCHEOLOGIST_HAT) {
            tooltip.add(I18n.format("item.rats.archeologist_hat.desc"));
        }
        if (stack.getItem() == RatsItemRegistry.PLAGUE_DOCTOR_MASK) {
            tooltip.add(I18n.format("item.rats.plague_doctor_mask.desc"));
        }
        if (stack.getItem() == RatsItemRegistry.BLACK_DEATH_MASK) {
            tooltip.add(I18n.format("item.rats.plague_doctor_mask.desc"));
            tooltip.add(I18n.format("item.rats.black_death_mask.desc"));
        }
        if (stack.getItem() == RatsItemRegistry.RAT_FEZ) {
            tooltip.add(I18n.format("item.rats.rat_fez.desc0"));
            tooltip.add(I18n.format("item.rats.rat_fez.desc1"));
        }
    }

    @SideOnly(Side.CLIENT)
    public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot, ModelBiped _default) {
        return (ModelBiped) RatsMod.PROXY.getArmorModel(modelIndex);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        return "rats:textures/model/" + name + ".png";
    }
}
