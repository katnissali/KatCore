package com.katnissali.katcore.Misc;

import net.minecraft.server.v1_16_R3.*;

import java.util.List;

public class CustomWorld extends World {

    private World s;
    public CustomWorld(World world){
        super(null, null, null, null, false, false, 0, null, null);
        s = world;
    }

    @Override
    public void notify(BlockPosition blockPosition, IBlockData iBlockData, IBlockData iBlockData1, int i) {
        s.notify(blockPosition, iBlockData, iBlockData1, i);
    }

    @Override
    public void playSound(EntityHuman entityHuman, double v, double v1, double v2, SoundEffect soundEffect, SoundCategory soundCategory, float v3, float v4) {
        s.playSound(entityHuman, v, v1, v2, soundEffect, soundCategory, v3, v4);
    }

    @Override
    public void playSound(EntityHuman entityHuman, Entity entity, SoundEffect soundEffect, SoundCategory soundCategory, float v, float v1) {
        s.playSound(entityHuman, entity, soundEffect, soundCategory, v, v1);
    }

    @Override
    public Entity getEntity(int i) {
        return s.getEntity(i);
    }

    @Override
    public WorldMap a(String s) {
        return this.s.a(s);
    }

    @Override
    public void a(WorldMap worldMap) {
        s.a(worldMap);
    }

    @Override
    public int getWorldMapCount() {
        return s.getWorldMapCount();
    }

    @Override
    public void a(int i, BlockPosition blockPosition, int i1) {
        s.a(i, blockPosition, i1);
    }

    @Override
    public Scoreboard getScoreboard() {
        return s.getScoreboard();
    }

    @Override
    public CraftingManager getCraftingManager() {
        return s.getCraftingManager();
    }

    @Override
    public ITagRegistry p() {
        return s.p();
    }

    @Override
    public TickList<Block> getBlockTickList() {
        return s.getBlockTickList();
    }

    @Override
    public TickList<FluidType> getFluidTickList() {
        return s.getFluidTickList();
    }

    @Override
    public IChunkProvider getChunkProvider() {
        return s.getChunkProvider();
    }

    @Override
    public void a(EntityHuman entityHuman, int i, BlockPosition blockPosition, int i1) {
        s.a(entityHuman, i, blockPosition, i1);
    }

    @Override
    public WorldServer getMinecraftWorld() {
        return s.getMinecraftWorld();
    }

    @Override
    public IRegistryCustom r() {
        return s.r();
    }

    @Override
    public List<? extends EntityHuman> getPlayers() {
        return s.getPlayers();
    }

    @Override
    public BiomeBase a(int i, int i1, int i2) {
        return s.a(i, i1, i2);
    }
}
