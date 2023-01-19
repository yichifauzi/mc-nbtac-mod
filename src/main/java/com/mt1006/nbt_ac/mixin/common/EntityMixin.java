package com.mt1006.nbt_ac.mixin.common;

import com.mt1006.nbt_ac.autocomplete.loader.typeloader.TypeLoader;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Entity.class)
public class EntityMixin
{
	@Redirect(method = "<init>", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/EntityType;getDimensions()Lnet/minecraft/entity/EntitySize;"))
	private EntitySize atConstructor(EntityType<?> entityType)
	{
		if (TypeLoader.getClasses) { TypeLoader.lastClass = this.getClass(); }
		return entityType.getDimensions();
	}
}
