package me.Adrenalize.TrialTwo;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Events implements Listener{
	@EventHandler
	public void onRightClick(PlayerInteractEvent event) {
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getItem() != null) {
				if (event.getItem().getItemMeta().equals(ItemManager.thor.getItemMeta())) {
					Player player = event.getPlayer();
					event.getClickedBlock().getWorld().strikeLightning(event.getClickedBlock().getLocation());
					player.sendMessage("BOY! EVERY USE HAS A COST...");
					for(int i = 0; i < 3; i++) {
					player.getWorld().spawnEntity(player.getLocation(), EntityType.ENDERMAN);
					
					}
				}
			}
		}
	}
	@EventHandler
	public void onShoot(EntityShootBowEvent event) {
		if (event.getEntity() instanceof Player) {
			if (event.getBow() != null) {
				if (event.getBow().hasItemMeta() && event.getBow().getItemMeta().equals(ItemManager.wBow.getItemMeta())) {
					Player play = (Player) event.getEntity();
					event.setCancelled(true);
					play.launchProjectile(WitherSkull.class).setVelocity(play.getEyeLocation().getDirection().multiply(event.getForce() * .4));
				}
			}
		}
	}
}
