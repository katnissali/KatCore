package com.katnissali.katcore.Misc;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.MinecraftServer;
import net.minecraft.server.v1_16_R3.WorldServer;
import org.bukkit.*;
import org.bukkit.advancement.Advancement;
import org.bukkit.advancement.AdvancementProgress;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.data.BlockData;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.*;
import org.bukkit.entity.memory.MemoryKey;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.*;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.RayTraceResult;
import org.bukkit.util.Vector;

import java.net.InetSocketAddress;
import java.util.*;

public class CustomPlayer implements Player {
    private Player player;

    protected CustomPlayer(Player player) {
        this.player = player;
    }

    protected Player getSuper(){
        return player;
    }

    //  CUSTOM
    public CraftPlayer getCraftPlayer(){ return (CraftPlayer) player; }
    public EntityPlayer getEntityPlayer(){ return getCraftPlayer().getHandle(); }
    public GameProfile getGameProflie(){
        return new GameProfile(getUniqueId(), getName());
    }
    public WorldServer getWorldServer(){ return ((CraftWorld)player.getWorld()).getHandle(); }
    public MinecraftServer getMinecraftServer(){ return ((CraftServer)Bukkit.getServer()).getServer(); }

    //  OVERRIDES
    @Override
    public String getDisplayName() {
        return getSuper().getDisplayName();
    }

    @Override
    public void setDisplayName(String s) {
        getSuper().setDisplayName(s);
    }

    @Override
    public String getPlayerListName() {
        return getSuper().getPlayerListName();
    }

    @Override
    public void setPlayerListName(String s) {
        getSuper().setPlayerListName(s);
    }

    @Override
    public String getPlayerListHeader() {
        return getSuper().getPlayerListHeader();
    }

    @Override
    public String getPlayerListFooter() {
        return getSuper().getPlayerListFooter();
    }

    @Override
    public void setPlayerListHeader(String s) {
        getSuper().setPlayerListHeader(s);
    }

    @Override
    public void setPlayerListFooter(String s) {
     getSuper().setPlayerListFooter(s);
}

    @Override
    public void setPlayerListHeaderFooter(String s, String s1) {
     getSuper().setPlayerListHeaderFooter(s, s1);
}

    @Override
    public void setCompassTarget(Location location) {
     getSuper().setCompassTarget(location);
}

    @Override
    public Location getCompassTarget() {
        return getSuper().getCompassTarget();
    }

    @Override
    public InetSocketAddress getAddress() {
        return getSuper().getAddress();
    }

    @Override
    public boolean isConversing() {
        return getSuper().isConversing();
    }

    @Override
    public void acceptConversationInput(String s) {
     getSuper().acceptConversationInput(s);
}

    @Override
    public boolean beginConversation(Conversation conversation) {
        return getSuper().beginConversation(conversation);
    }

    @Override
    public void abandonConversation(Conversation conversation) {
     getSuper().abandonConversation(conversation);
}

    @Override
    public void abandonConversation(Conversation conversation, ConversationAbandonedEvent conversationAbandonedEvent) {
     getSuper().abandonConversation(conversation, conversationAbandonedEvent);
}

    @Override
    public void sendRawMessage(String s) {
     getSuper().sendRawMessage(s);
}

    @Override
    public void sendRawMessage(UUID uuid, String s) {
     getSuper().sendRawMessage(uuid,s);
}

    @Override
    public void kickPlayer(String s) {
     getSuper().kickPlayer(s);
}

    @Override
    public void chat(String s) {
     getSuper().chat(s);
}

    @Override
    public boolean performCommand(String s) {
        return getSuper().performCommand(s);
    }

    @Override
    public Location getLocation() {
        return getSuper().getLocation();
    }

    @Override
    public Location getLocation(Location location) {
        return getSuper().getLocation(location);
    }

    @Override
    public void setVelocity(Vector vector) {
     getSuper().setVelocity(vector);
}

    @Override
    public Vector getVelocity() {
        return getSuper().getVelocity();
    }

    @Override
    public double getHeight() {
        return getSuper().getHeight();
    }

    @Override
    public double getWidth() {
        return getSuper().getWidth();
    }

    @Override
    public BoundingBox getBoundingBox() {
        return getSuper().getBoundingBox();
    }

    @Override
    public boolean isOnGround() {
        return getSuper().isOnline();
    }

    @Override
    public boolean isInWater() {
        return getSuper().isInWater();
    }

    @Override
    public World getWorld() {
        return getSuper().getWorld();
    }

    @Override
    public void setRotation(float v, float v1) {
     getSuper().setRotation(v, v1);
}

    @Override
    public boolean teleport(Location location) {
        return getSuper().teleport(location);
    }

    @Override
    public boolean teleport(Location location, PlayerTeleportEvent.TeleportCause teleportCause) {
        return getSuper().teleport(location,teleportCause);
    }

    @Override
    public boolean teleport(Entity entity) {
        return getSuper().teleport(entity);
    }

    @Override
    public boolean teleport(Entity entity, PlayerTeleportEvent.TeleportCause teleportCause) {
        return getSuper().teleport(entity,teleportCause);
    }

    @Override
    public List<Entity> getNearbyEntities(double v, double v1, double v2) {
        return getSuper().getNearbyEntities(v,v1,v2);
    }

    @Override
    public int getEntityId() {
        return getSuper().getEntityId();
    }

    @Override
    public int getFireTicks() {
        return getSuper().getFireTicks();
    }

    @Override
    public int getMaxFireTicks() {
        return getSuper().getMaxFireTicks();
    }

    @Override
    public void setFireTicks(int i) {
     getSuper().setFireTicks(i);
}

    @Override
    public void remove() {
     getSuper().remove();
}

    @Override
    public boolean isDead() {
        return getSuper().isDead();
    }

    @Override
    public boolean isValid() {
        return getSuper().isValid();
    }

    @Override
    public void sendMessage(String s) {
     getSuper().sendMessage(s);
}

    @Override
    public void sendMessage(String[] strings) {
     getSuper().sendMessage(strings);
}

    @Override
    public void sendMessage(UUID uuid, String s) {
     getSuper().sendMessage(uuid,s);
}

    @Override
    public void sendMessage(UUID uuid, String[] strings) {
     getSuper().sendMessage(uuid, strings);
}

    @Override
    public Server getServer() {
        return getSuper().getServer();
    }

    @Override
    public boolean isPersistent() {
        return getSuper().isPersistent();
    }

    @Override
    public void setPersistent(boolean b) {
     getSuper().setPersistent(b);
}

    @Override
    public Entity getPassenger() {
        return getSuper().getPassenger();
    }

    @Override
    public boolean setPassenger(Entity entity) {
        return getSuper().setPassenger(entity);
    }

    @Override
    public List<Entity> getPassengers() {
        return getSuper().getPassengers();
    }

    @Override
    public boolean addPassenger(Entity entity) {
        return getSuper().addPassenger(entity);
    }

    @Override
    public boolean removePassenger(Entity entity) {
        return getSuper().removePassenger(entity);
    }

    @Override
    public boolean isEmpty() {
        return getSuper().isEmpty();
    }

    @Override
    public boolean eject() {
        return getSuper().eject();
    }

    @Override
    public float getFallDistance() {
        return getSuper().getFallDistance();
    }

    @Override
    public void setFallDistance(float v) {
     getSuper().setFallDistance(v);
}

    @Override
    public void setLastDamageCause(EntityDamageEvent entityDamageEvent) {
     getSuper().setLastDamageCause(entityDamageEvent);
}

    @Override
    public EntityDamageEvent getLastDamageCause() {
        return getSuper().getLastDamageCause();
    }

    @Override
    public UUID getUniqueId() {
        return getSuper().getUniqueId();
    }

    @Override
    public int getTicksLived() {
        return getSuper().getTicksLived();
    }

    @Override
    public void setTicksLived(int i) {
     getSuper().setTicksLived(i);
}

    @Override
    public void playEffect(EntityEffect entityEffect) {
     getSuper().playEffect(entityEffect);
}

    @Override
    public EntityType getType() {
        return getSuper().getType();
    }

    @Override
    public boolean isInsideVehicle() {
        return getSuper().isInsideVehicle();
    }

    @Override
    public boolean leaveVehicle() {
        return getSuper().leaveVehicle();
    }

    @Override
    public Entity getVehicle() {
        return getSuper().getVehicle();
    }

    @Override
    public void setCustomNameVisible(boolean b) {
     getSuper().setCustomNameVisible(b);
}

    @Override
    public boolean isCustomNameVisible() {
        return getSuper().isCustomNameVisible();
    }

    @Override
    public void setGlowing(boolean b) {
     getSuper().setGlowing(b);
}

    @Override
    public boolean isGlowing() {
        return getSuper().isGlowing();
    }

    @Override
    public void setInvulnerable(boolean b) {
     getSuper().setInvulnerable(b);
}

    @Override
    public boolean isInvulnerable() {
        return getSuper().isInvulnerable();
    }

    @Override
    public boolean isSilent() {
        return getSuper().isSilent();
    }

    @Override
    public void setSilent(boolean b) {
     getSuper().setSilent(b);
}

    @Override
    public boolean hasGravity() {
        return getSuper().hasGravity();
    }

    @Override
    public void setGravity(boolean b) {
     getSuper().setGravity(b);
}

    @Override
    public int getPortalCooldown() {
        return getSuper().getPortalCooldown();
    }

    @Override
    public void setPortalCooldown(int i) {
     getSuper().setPortalCooldown(i);
}

    @Override
    public Set<String> getScoreboardTags() {
        return getSuper().getScoreboardTags();
    }

    @Override
    public boolean addScoreboardTag(String s) {
        return getSuper().addScoreboardTag(s);
    }

    @Override
    public boolean removeScoreboardTag(String s) {
        return getSuper().removeScoreboardTag(s);
    }

    @Override
    public PistonMoveReaction getPistonMoveReaction() {
        return getSuper().getPistonMoveReaction();
    }

    @Override
    public BlockFace getFacing() {
        return getSuper().getFacing();
    }

    @Override
    public Pose getPose() {
        return getSuper().getPose();
    }

    @Override
    public boolean isSneaking() {
        return getSuper().isSneaking();
    }

    @Override
    public void setSneaking(boolean b) {
     getSuper().setSneaking(b);
}

    @Override
    public boolean isSprinting() {
        return getSuper().isSprinting();
    }

    @Override
    public void setSprinting(boolean b) {
     getSuper().setSprinting(b);
}

    @Override
    public void saveData() {
     getSuper().saveData();
}

    @Override
    public void loadData() {
     getSuper().loadData();
}

    @Override
    public void setSleepingIgnored(boolean b) {
     getSuper().setSleepingIgnored(b);
}

    @Override
    public boolean isSleepingIgnored() {
        return getSuper().isSleepingIgnored();
    }

    @Override
    public boolean isOnline() {
        return getSuper().isOnline();
    }

    @Override
    public boolean isBanned() {
        return getSuper().isBanned();
    }

    @Override
    public boolean isWhitelisted() {
        return getSuper().isWhitelisted();
    }

    @Override
    public void setWhitelisted(boolean b) {
     getSuper().setWhitelisted(b);
}

    @Override
    public Player getPlayer() {
        return getSuper().getPlayer();
    }

    @Override
    public long getFirstPlayed() {
        return getSuper().getFirstPlayed();
    }

    @Override
    public long getLastPlayed() {
        return getSuper().getLastPlayed();
    }

    @Override
    public boolean hasPlayedBefore() {
        return getSuper().hasPlayedBefore();
    }

    @Override
    public Location getBedSpawnLocation() {
        return getSuper().getBedSpawnLocation();
    }

    @Override
    public void incrementStatistic(Statistic statistic) throws IllegalArgumentException {
     getSuper().incrementStatistic(statistic);
}

    @Override
    public void decrementStatistic(Statistic statistic) throws IllegalArgumentException {
     getSuper().decrementStatistic(statistic);
}

    @Override
    public void incrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {
     getSuper().incrementStatistic(statistic, i);
}

    @Override
    public void decrementStatistic(Statistic statistic, int i) throws IllegalArgumentException {
     getSuper().decrementStatistic(statistic, i);
}

    @Override
    public void setStatistic(Statistic statistic, int i) throws IllegalArgumentException {
     getSuper().setStatistic(statistic, i);
}

    @Override
    public int getStatistic(Statistic statistic) throws IllegalArgumentException {
        return getSuper().getStatistic(statistic);
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
     getSuper().incrementStatistic(statistic, material);
}

    @Override
    public void decrementStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
     getSuper().decrementStatistic(statistic, material);
}

    @Override
    public int getStatistic(Statistic statistic, Material material) throws IllegalArgumentException {
        return getSuper().getStatistic(statistic, material);
    }

    @Override
    public void incrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
     getSuper().incrementStatistic(statistic, material, i);
}

    @Override
    public void decrementStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
     getSuper().decrementStatistic(statistic, material, i);
}

    @Override
    public void setStatistic(Statistic statistic, Material material, int i) throws IllegalArgumentException {
     getSuper().setStatistic(statistic, material, i);
}

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
     getSuper().incrementStatistic(statistic, entityType);
}

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
     getSuper().decrementStatistic(statistic, entityType);
}

    @Override
    public int getStatistic(Statistic statistic, EntityType entityType) throws IllegalArgumentException {
        return getSuper().getStatistic(statistic, entityType);
    }

    @Override
    public void incrementStatistic(Statistic statistic, EntityType entityType, int i) throws IllegalArgumentException {
     getSuper().incrementStatistic(statistic, entityType, i);
}

    @Override
    public void decrementStatistic(Statistic statistic, EntityType entityType, int i) {
     getSuper().decrementStatistic(statistic, entityType, i);
}

    @Override
    public void setStatistic(Statistic statistic, EntityType entityType, int i) {
     getSuper().setStatistic(statistic, entityType, i);
}

    @Override
    public void setBedSpawnLocation(Location location) {
     getSuper().setBedSpawnLocation(location);
}

    @Override
    public void setBedSpawnLocation(Location location, boolean b) {
     getSuper().setBedSpawnLocation(location, b);
}

    @Override
    public void playNote(Location location, byte b, byte b1) {
     getSuper().playNote(location, b, b1);
}

    @Override
    public void playNote(Location location, Instrument instrument, Note note) {
     getSuper().playNote(location, instrument, note);
}

    @Override
    public void playSound(Location location, Sound sound, float v, float v1) {
     getSuper().playSound(location, sound, v, v1);
}

    @Override
    public void playSound(Location location, String s, float v, float v1) {
     getSuper().playSound(location, s, v, v1);
}

    @Override
    public void playSound(Location location, Sound sound, SoundCategory soundCategory, float v, float v1) {
        getSuper().playSound(location, sound, soundCategory, v, v1);
}

    @Override
    public void playSound(Location location, String s, SoundCategory soundCategory, float v, float v1) {
        getSuper().playSound(location, s, soundCategory, v, v1);
}

    @Override
    public void stopSound(Sound sound) {
     getSuper().stopSound(sound);
}

    @Override
    public void stopSound(String s) {
        getSuper().stopSound(s);
}

    @Override
    public void stopSound(Sound sound, SoundCategory soundCategory) {
        getSuper().stopSound(sound, soundCategory);
}

    @Override
    public void stopSound(String s, SoundCategory soundCategory) {
        stopSound(s, soundCategory);
    }

    @Override
    public void playEffect(Location location, Effect effect, int i) {
     getSuper().playEffect(location, effect, i);
}

    @Override
    public <T> void playEffect(Location location, Effect effect, T t) {
     getSuper().playEffect(location, effect, t);
}

    @Override
    public void sendBlockChange(Location location, Material material, byte b) {
     getSuper().sendBlockChange(location, material, b);
}

    @Override
    public void sendBlockChange(Location location, BlockData blockData) {
     getSuper().sendBlockChange(location, blockData);
}

    @Override
    public boolean sendChunkChange(Location location, int i, int i1, int i2, byte[] bytes) {
        return getSuper().sendChunkChange(location, i, i1, i2, bytes);
    }

    @Override
    public void sendSignChange(Location location, String[] strings) throws IllegalArgumentException {
     getSuper().sendSignChange(location, strings);
}

    @Override
    public void sendSignChange(Location location, String[] strings, DyeColor dyeColor) throws IllegalArgumentException {
     getSuper().sendSignChange(location, strings, dyeColor);
}

    @Override
    public void sendMap(MapView mapView) {
     getSuper().sendMap(mapView);
}

    @Override
    public void updateInventory() {
     getSuper().updateInventory();
}

    @Override
    public void setPlayerTime(long l, boolean b) {
     getSuper().setPlayerTime(l, b);
}

    @Override
    public long getPlayerTime() {
        return getSuper().getPlayerTime();
    }

    @Override
    public long getPlayerTimeOffset() {
        return getSuper().getPlayerTimeOffset();
    }

    @Override
    public boolean isPlayerTimeRelative() {
        return getSuper().isPlayerTimeRelative();
    }

    @Override
    public void resetPlayerTime() {
     getSuper().resetPlayerTime();
}

    @Override
    public void setPlayerWeather(WeatherType weatherType) {
     getSuper().setPlayerWeather(weatherType);
}

    @Override
    public WeatherType getPlayerWeather() {
        return getSuper().getPlayerWeather();
    }

    @Override
    public void resetPlayerWeather() {
     getSuper().resetPlayerWeather();
}

    @Override
    public void giveExp(int i) {
     getSuper().giveExp(i);
}

    @Override
    public void giveExpLevels(int i) {
     getSuper().giveExpLevels(i);
}

    @Override
    public float getExp() {
        return getSuper().getExp();
    }

    @Override
    public void setExp(float v) {
     getSuper().setExp(v);
}

    @Override
    public int getLevel() {
        return getSuper().getLevel();
    }

    @Override
    public void setLevel(int i) {
     getSuper().setLevel(i);
}

    @Override
    public int getTotalExperience() {
        return getSuper().getTotalExperience();
    }

    @Override
    public void setTotalExperience(int i) {
     getSuper().setTotalExperience(i);
}

    @Override
    public void sendExperienceChange(float v) {
     getSuper().sendExperienceChange(v);
}

    @Override
    public void sendExperienceChange(float v, int i) {
     getSuper().sendExperienceChange(v, i);
}

    @Override
    public float getExhaustion() {
        return getSuper().getExhaustion();
    }

    @Override
    public void setExhaustion(float v) {
     getSuper().setExhaustion(v);
}

    @Override
    public float getSaturation() {
        return getSuper().getSaturation();
    }

    @Override
    public void setSaturation(float v) {
     getSuper().setSaturation(v);
}

    @Override
    public int getFoodLevel() {
        return getSuper().getFoodLevel();
    }

    @Override
    public void setFoodLevel(int i) {
     getSuper().setFoodLevel(i);
}

    @Override
    public boolean getAllowFlight() {
        return getSuper().getAllowFlight();
    }

    @Override
    public void setAllowFlight(boolean b) {
     getSuper().setAllowFlight(b);
}

    @Override
    public void hidePlayer(Player player) {
     getSuper().hidePlayer(player);
}

    @Override
    public void hidePlayer(Plugin plugin, Player player) {
     getSuper().hidePlayer(plugin, player);
}

    @Override
    public void showPlayer(Player player) {
     getSuper().showPlayer(player);
}

    @Override
    public void showPlayer(Plugin plugin, Player player) {
     getSuper().showPlayer(plugin, player);
}

    @Override
    public boolean canSee(Player player) {
        return getSuper().canSee(player);
    }

    @Override
    public boolean isFlying() {
        return getSuper().isFlying();
    }

    @Override
    public void setFlying(boolean b) {
     getSuper().setFlying(b);
}

    @Override
    public void setFlySpeed(float v) throws IllegalArgumentException {
     getSuper().setFlySpeed(v);
}

    @Override
    public void setWalkSpeed(float v) throws IllegalArgumentException {
     getSuper().setWalkSpeed(v);
}

    @Override
    public float getFlySpeed() {
        return getSuper().getFlySpeed();
    }

    @Override
    public float getWalkSpeed() {
        return getSuper().getWalkSpeed();
    }

    @Override
    public void setTexturePack(String s) {
     getSuper().setTexturePack(s);
}

    @Override
    public void setResourcePack(String s) {
     getSuper().setResourcePack(s);
}

    @Override
    public void setResourcePack(String s, byte[] bytes) {
     getSuper().setResourcePack(s, bytes);
}

    @Override
    public Scoreboard getScoreboard() {
        return getSuper().getScoreboard();
    }

    @Override
    public void setScoreboard(Scoreboard scoreboard) throws IllegalArgumentException, IllegalStateException {
     getSuper().setScoreboard(scoreboard);
}

    @Override
    public boolean isHealthScaled() {
        return getSuper().isHealthScaled();
    }

    @Override
    public void setHealthScaled(boolean b) {
     getSuper().setHealthScaled(b);
}

    @Override
    public void setHealthScale(double v) throws IllegalArgumentException {
     getSuper().setHealthScale(v);
}

    @Override
    public double getHealthScale() {
        return getSuper().getHealthScale();
    }

    @Override
    public Entity getSpectatorTarget() {
        return getSuper().getSpectatorTarget();
    }

    @Override
    public void setSpectatorTarget(Entity entity) {
     getSuper().setSpectatorTarget(entity);
}

    @Override
    public void sendTitle(String s, String s1) {
     getSuper().sendTitle(s, s1);
}

    @Override
    public void sendTitle(String s, String s1, int i, int i1, int i2) {
     getSuper().sendTitle(s, s1, i, i1, i2);
}

    @Override
    public void resetTitle() {
     getSuper().resetTitle();
}

    @Override
    public void spawnParticle(Particle particle, Location location, int i) {
     getSuper().spawnParticle(particle, location, i);
}

    @Override
    public void spawnParticle(Particle particle, double v, double v1, double v2, int i) {
     getSuper().spawnParticle(particle, v, v1, v2, i);
}

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int i, T t) {
     getSuper().spawnParticle(particle, location, i, t);
}

    @Override
    public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, T t) {
     getSuper().spawnParticle(particle, v, v1, v2, i, t);
}

    @Override
    public void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2) {
     getSuper().spawnParticle(particle, location, i, v, v1, v2);
}

    @Override
    public void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5) {
     getSuper().spawnParticle(particle, v, v1, v2, i , v3, v4, v5);
}

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, T t) {
     getSuper().spawnParticle(particle, location, i, v, v1, v2, t);
}

    @Override
    public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, T t) {
     getSuper().spawnParticle(particle, v, v1, v2, i, v3, v4, v5, t);
}

    @Override
    public void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, double v3) {
     getSuper().spawnParticle(particle, location, i, v, v1, v2, v3);
}

    @Override
    public void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6) {
        getSuper().spawnParticle(particle, v, v1, v2, i, v3, v4, v5, v6);
}

    @Override
    public <T> void spawnParticle(Particle particle, Location location, int i, double v, double v1, double v2, double v3, T t) {
        getSuper().spawnParticle(particle, location, i, v, v1, v2, v3, t);

    }

    @Override
    public <T> void spawnParticle(Particle particle, double v, double v1, double v2, int i, double v3, double v4, double v5, double v6, T t) {
     getSuper().spawnParticle(particle, v, v1, v2, i, v3, v4, v5, v6, t);
}

    @Override
    public AdvancementProgress getAdvancementProgress(Advancement advancement) {
        return getSuper().getAdvancementProgress(advancement);
    }

    @Override
    public int getClientViewDistance() {
        return getSuper().getClientViewDistance();
    }

    @Override
    public String getLocale() {
        return getSuper().getLocale();
    }

    @Override
    public void updateCommands() {
     getSuper().updateCommands();
}

    @Override
    public void openBook(ItemStack itemStack) {
     getSuper().openBook(itemStack);
}

    @Override
    public Spigot spigot() {
        return getSuper().spigot();
    }

    @Override
    public Map<String, Object> serialize() {
        return getSuper().serialize();
    }

    @Override
    public String getName() {
        return getSuper().getName();
    }

    @Override
    public PlayerInventory getInventory() {
        return getSuper().getInventory();
    }

    @Override
    public Inventory getEnderChest() {
        return getSuper().getEnderChest();
    }

    @Override
    public MainHand getMainHand() {
        return getSuper().getMainHand();
    }

    @Override
    public boolean setWindowProperty(InventoryView.Property property, int i) {
        return getSuper().setWindowProperty(property, i);
    }

    @Override
    public InventoryView getOpenInventory() {
        return getSuper().getOpenInventory();
    }

    @Override
    public InventoryView openInventory(Inventory inventory) {
        return getSuper().openInventory(inventory);
    }

    @Override
    public InventoryView openWorkbench(Location location, boolean b) {
        return getSuper().openWorkbench(location, b);
    }

    @Override
    public InventoryView openEnchanting(Location location, boolean b) {
        return getSuper().openEnchanting(location, b);
    }

    @Override
    public void openInventory(InventoryView inventoryView) {
     getSuper().openInventory(inventoryView);
}

    @Override
    public InventoryView openMerchant(Villager villager, boolean b) {
        return getSuper().openMerchant(villager, b);
    }

    @Override
    public InventoryView openMerchant(Merchant merchant, boolean b) {
        return getSuper().openMerchant(merchant, b);
    }

    @Override
    public void closeInventory() {
     getSuper().closeInventory();
}

    @Override
    public ItemStack getItemInHand() {
        return getSuper().getItemInHand();
    }

    @Override
    public void setItemInHand(ItemStack itemStack) {
     getSuper().setItemInHand(itemStack);
}

    @Override
    public ItemStack getItemOnCursor() {
        return getSuper().getItemOnCursor();
    }

    @Override
    public void setItemOnCursor(ItemStack itemStack) {
     getSuper().setItemOnCursor(itemStack);
}

    @Override
    public boolean hasCooldown(Material material) {
        return getSuper().hasCooldown(material);
    }

    @Override
    public int getCooldown(Material material) {
        return getSuper().getCooldown(material);
    }

    @Override
    public void setCooldown(Material material, int i) {
     getSuper().setCooldown(material, i);
}

    @Override
    public int getSleepTicks() {
        return getSuper().getSleepTicks();
    }

    @Override
    public boolean sleep(Location location, boolean b) {
        return getSuper().sleep(location, b);
    }

    @Override
    public void wakeup(boolean b) {
     getSuper().wakeup(b);
}

    @Override
    public Location getBedLocation() {
        return getSuper().getBedLocation();
    }

    @Override
    public GameMode getGameMode() {
        return getSuper().getGameMode();
    }

    @Override
    public void setGameMode(GameMode gameMode) {
     getSuper().setGameMode(gameMode);
}

    @Override
    public boolean isBlocking() {
        return getSuper().isBlocking();
    }

    @Override
    public boolean isHandRaised() {
        return getSuper().isHandRaised();
    }

    @Override
    public int getExpToLevel() {
        return getSuper().getExpToLevel();
    }

    @Override
    public float getAttackCooldown() {
        return getSuper().getAttackCooldown();
    }

    @Override
    public boolean discoverRecipe(NamespacedKey namespacedKey) {
        return getSuper().discoverRecipe(namespacedKey);
    }

    @Override
    public int discoverRecipes(Collection<NamespacedKey> collection) {
        return getSuper().discoverRecipes(collection);
    }

    @Override
    public boolean undiscoverRecipe(NamespacedKey namespacedKey) {
        return getSuper().undiscoverRecipe(namespacedKey);
    }

    @Override
    public int undiscoverRecipes(Collection<NamespacedKey> collection) {
        return getSuper().undiscoverRecipes(collection);
    }

    @Override
    public boolean hasDiscoveredRecipe(NamespacedKey namespacedKey) {
        return getSuper().hasDiscoveredRecipe(namespacedKey);
    }

    @Override
    public Set<NamespacedKey> getDiscoveredRecipes() {
        return getSuper().getDiscoveredRecipes();
    }

    @Override
    public Entity getShoulderEntityLeft() {
        return getSuper().getShoulderEntityLeft();
    }

    @Override
    public void setShoulderEntityLeft(Entity entity) {
     getSuper().setShoulderEntityLeft(entity);
}

    @Override
    public Entity getShoulderEntityRight() {
        return getSuper().getShoulderEntityRight();
    }

    @Override
    public void setShoulderEntityRight(Entity entity) {
     getSuper().setShoulderEntityRight(entity);
}

    @Override
    public boolean dropItem(boolean b) {
        return getSuper().dropItem(b);
    }

    @Override
    public double getEyeHeight() {
        return getSuper().getEyeHeight();
    }

    @Override
    public double getEyeHeight(boolean b) {
        return getSuper().getEyeHeight(b);
    }

    @Override
    public Location getEyeLocation() {
        return getSuper().getEyeLocation();
    }

    @Override
    public List<Block> getLineOfSight(Set<Material> set, int i) {
        return getSuper().getLineOfSight(set, i);
    }

    @Override
    public Block getTargetBlock(Set<Material> set, int i) {
        return getSuper().getTargetBlock(set, i);
    }

    @Override
    public List<Block> getLastTwoTargetBlocks(Set<Material> set, int i) {
        return getSuper().getLastTwoTargetBlocks(set, i);
    }

    @Override
    public Block getTargetBlockExact(int i) {
        return getSuper().getTargetBlockExact(i);
    }

    @Override
    public Block getTargetBlockExact(int i, FluidCollisionMode fluidCollisionMode) {
        return getSuper().getTargetBlockExact(i, fluidCollisionMode);
    }

    @Override
    public RayTraceResult rayTraceBlocks(double v) {
        return getSuper().rayTraceBlocks(v);
    }

    @Override
    public RayTraceResult rayTraceBlocks(double v, FluidCollisionMode fluidCollisionMode) {
        return getSuper().rayTraceBlocks(v, fluidCollisionMode);
    }

    @Override
    public int getRemainingAir() {
        return getSuper().getRemainingAir();
    }

    @Override
    public void setRemainingAir(int i) {
     getSuper().setRemainingAir(i);
}

    @Override
    public int getMaximumAir() {
        return getSuper().getMaximumAir();
    }

    @Override
    public void setMaximumAir(int i) {
     getSuper().setMaximumAir(i);
}

    @Override
    public int getArrowCooldown() {
        return getSuper().getArrowCooldown();
    }

    @Override
    public void setArrowCooldown(int i) {
     getSuper().setArrowCooldown(i);
}

    @Override
    public int getArrowsInBody() {
        return getSuper().getArrowsInBody();
    }

    @Override
    public void setArrowsInBody(int i) {
     getSuper().setArrowsInBody(i);
}

    @Override
    public int getMaximumNoDamageTicks() {
        return getSuper().getMaximumNoDamageTicks();
    }

    @Override
    public void setMaximumNoDamageTicks(int i) {
     getSuper().setMaximumNoDamageTicks(i);
}

    @Override
    public double getLastDamage() {
        return getSuper().getLastDamage();
    }

    @Override
    public void setLastDamage(double v) {
     getSuper().setLastDamage(v);
}

    @Override
    public int getNoDamageTicks() {
        return getSuper().getNoDamageTicks();
    }

    @Override
    public void setNoDamageTicks(int i) {
     getSuper().setNoDamageTicks(i);
}

    @Override
    public Player getKiller() {
        return getSuper().getKiller();
    }

    @Override
    public boolean addPotionEffect(PotionEffect potionEffect) {
        return getSuper().addPotionEffect(potionEffect);
    }

    @Override
    public boolean addPotionEffect(PotionEffect potionEffect, boolean b) {
        return getSuper().addPotionEffect(potionEffect, b);
    }

    @Override
    public boolean addPotionEffects(Collection<PotionEffect> collection) {
        return getSuper().addPotionEffects(collection);
    }

    @Override
    public boolean hasPotionEffect(PotionEffectType potionEffectType) {
        return getSuper().hasPotionEffect(potionEffectType);
    }

    @Override
    public PotionEffect getPotionEffect(PotionEffectType potionEffectType) {
        return getSuper().getPotionEffect(potionEffectType);
    }

    @Override
    public void removePotionEffect(PotionEffectType potionEffectType) {
     getSuper().removePotionEffect(potionEffectType);
}

    @Override
    public Collection<PotionEffect> getActivePotionEffects() {
        return getSuper().getActivePotionEffects();
    }

    @Override
    public boolean hasLineOfSight(Entity entity) {
        return getSuper().hasLineOfSight(entity);
    }

    @Override
    public boolean getRemoveWhenFarAway() {
        return getSuper().getRemoveWhenFarAway();
    }

    @Override
    public void setRemoveWhenFarAway(boolean b) {
     getSuper().setRemoveWhenFarAway(b);
}

    @Override
    public EntityEquipment getEquipment() {
        return getSuper().getEquipment();
    }

    @Override
    public void setCanPickupItems(boolean b) {
     getSuper().setCanPickupItems(b);
}

    @Override
    public boolean getCanPickupItems() {
        return getSuper().getCanPickupItems();
    }

    @Override
    public boolean isLeashed() {
        return getSuper().isLeashed();
    }

    @Override
    public Entity getLeashHolder() throws IllegalStateException {
        return getSuper().getLeashHolder();
    }

    @Override
    public boolean setLeashHolder(Entity entity) {
        return getSuper().setLeashHolder(entity);
    }

    @Override
    public boolean isGliding() {
        return getSuper().isGliding();
    }

    @Override
    public void setGliding(boolean b) {
     getSuper().setGliding(b);
}

    @Override
    public boolean isSwimming() {
        return getSuper().isSwimming();
    }

    @Override
    public void setSwimming(boolean b) {
     getSuper().setSwimming(b);
}

    @Override
    public boolean isRiptiding() {
        return getSuper().isRiptiding();
    }

    @Override
    public boolean isSleeping() {
        return getSuper().isSleeping();
    }

    @Override
    public void setAI(boolean b) {
     getSuper().setAI(b);
}

    @Override
    public boolean hasAI() {
        return getSuper().hasAI();
    }

    @Override
    public void attack(Entity entity) {
     getSuper().attack(entity);
}

    @Override
    public void swingMainHand() {
     getSuper().swingMainHand();
}

    @Override
    public void swingOffHand() {
     getSuper().swingOffHand();
}

    @Override
    public void setCollidable(boolean b) {
     getSuper().setCollidable(b);
}

    @Override
    public boolean isCollidable() {
        return getSuper().isCollidable();
    }

    @Override
    public Set<UUID> getCollidableExemptions() {
        return getSuper().getCollidableExemptions();
    }

    @Override
    public <T> T getMemory(MemoryKey<T> memoryKey) {
        return getSuper().getMemory(memoryKey);
    }

    @Override
    public <T> void setMemory(MemoryKey<T> memoryKey, T t) {
     getSuper().setMemory(memoryKey, t);
}

    @Override
    public EntityCategory getCategory() {
        return getSuper().getCategory();
    }

    @Override
    public void setInvisible(boolean b) {
     getSuper().setInvisible(b);
}

    @Override
    public boolean isInvisible() {
        return getSuper().isInvisible();
    }

    @Override
    public AttributeInstance getAttribute(Attribute attribute) {
        return getSuper().getAttribute(attribute);
    }

    @Override
    public void damage(double v) {
     getSuper().damage(v);
}

    @Override
    public void damage(double v, Entity entity) {
     getSuper().damage(v, entity);
}

    @Override
    public double getHealth() {
        return getSuper().getHealth();
    }

    @Override
    public void setHealth(double v) {
     getSuper().setHealthScale(v);
}

    @Override
    public double getAbsorptionAmount() {
        return getSuper().getAbsorptionAmount();
    }

    @Override
    public void setAbsorptionAmount(double v) {
     getSuper().setAbsorptionAmount(v);
}

    @Override
    public double getMaxHealth() {
        return getSuper().getMaxFireTicks();
    }

    @Override
    public void setMaxHealth(double v) {
     getSuper().setMaxHealth(v);
}

    @Override
    public void resetMaxHealth() {
     getSuper().resetMaxHealth();
}

    @Override
    public String getCustomName() {
        return getSuper().getCustomName();
    }

    @Override
    public void setCustomName(String s) {
     getSuper().setCustomName(s);
}

    @Override
    public void setMetadata(String s, MetadataValue metadataValue) {
     getSuper().setMetadata(s, metadataValue);
}

    @Override
    public List<MetadataValue> getMetadata(String s) {
        return getSuper().getMetadata(s);
    }

    @Override
    public boolean hasMetadata(String s) {
        return getSuper().hasMetadata(s);
    }

    @Override
    public void removeMetadata(String s, Plugin plugin) {
     getSuper().removeMetadata(s, plugin);
}

    @Override
    public boolean isPermissionSet(String s) {
        return getSuper().isPermissionSet(s);
    }

    @Override
    public boolean isPermissionSet(Permission permission) {
        return getSuper().isPermissionSet(permission);
    }

    @Override
    public boolean hasPermission(String s) {
        return getSuper().hasPermission(s);
    }

    @Override
    public boolean hasPermission(Permission permission) {
        return getSuper().hasPermission(permission);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        return getSuper().addAttachment(plugin, s, b);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        return getSuper().addAttachment(plugin);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        return getSuper().addAttachment(plugin, s, b, i);
    }

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        return getSuper().addAttachment(plugin, i);
    }

    @Override
    public void removeAttachment(PermissionAttachment permissionAttachment) {
     getSuper().removeAttachment(permissionAttachment);
}

    @Override
    public void recalculatePermissions() {
     getSuper().recalculatePermissions();
}

    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return getSuper().getEffectivePermissions();
    }

    @Override
    public boolean isOp() {
        return getSuper().isOp();
    }

    @Override
    public void setOp(boolean b) {
     getSuper().setOp(b);
}

    @Override
    public PersistentDataContainer getPersistentDataContainer() {
        return getSuper().getPersistentDataContainer();
    }

    @Override
    public void sendPluginMessage(Plugin plugin, String s, byte[] bytes) {
     getSuper().sendPluginMessage(plugin, s, bytes);
}

    @Override
    public Set<String> getListeningPluginChannels() {
        return getSuper().getListeningPluginChannels();
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> aClass) {
        return getSuper().launchProjectile(aClass);
    }

    @Override
    public <T extends Projectile> T launchProjectile(Class<? extends T> aClass, Vector vector) {
        return getSuper().launchProjectile(aClass, vector);
    }
}
