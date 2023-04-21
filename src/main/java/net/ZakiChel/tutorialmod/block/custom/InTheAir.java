package net.ZakiChel.tutorialmod.block.custom;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class InTheAir extends Block {

    public InTheAir(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
        if(!pLevel.isClientSide()){
            if(pHand == InteractionHand.MAIN_HAND){
                pPlayer.sendMessage(new TextComponent("Helllooooooooo!!"), Util.NIL_UUID);

            }

    }
        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pLevel.isClientSide){
            if(pEntity instanceof LivingEntity){
                LivingEntity entity = ((LivingEntity) pEntity);
                entity.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 200,1));
            }
        }


        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
