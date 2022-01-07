package com.katnissali.katcore.Misc;

import org.bukkit.EntityEffect;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pose;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class CustomEntity implements Entity {

    private final Entity s;
    public CustomEntity(Entity entity){
        s = entity;
    }
    protected Entity getSuper(){ return s; }

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
        return getSuper().isOnGround();
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
        return getSuper().teleport(location, teleportCause);
    }

    @Override
    public boolean teleport(Entity entity) {
        return getSuper().teleport(entity);
    }

    @Override
    public boolean teleport(Entity entity, PlayerTeleportEvent.TeleportCause teleportCause) {
        return getSuper().teleport(entity, teleportCause);
    }

    @Override
    public List<Entity> getNearbyEntities(double v, double v1, double v2) {
        return getSuper().getNearbyEntities(v, v1, v2);
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
        getSuper().sendMessage(uuid, s);
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
    public String getName() {
        return getSuper().getName();
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
        getSuper().setGlowing(b);
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
    public Spigot spigot() {
        return getSuper().spigot();
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
        getSuper().removeMetadata(s,plugin);
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
}
