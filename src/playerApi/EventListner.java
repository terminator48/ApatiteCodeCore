/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playerApi;

import apatitecodecore.ApatiteCodeCore;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 *
 * @author Daniil
 */
public class EventListner implements Listener{
    @EventHandler
    public void PlayerMoveEvent(PlayerMoveEvent e) {
        
        String nodeName = "canMove";
       
        nodeName = "apatitecore."+e.getPlayer().getName()+"."+nodeName;
        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));
        if(!can)
            e.getPlayer().teleport(e.getFrom());
    }
    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e) {
        String nodeName = "canDestroyBlocks";
        
        nodeName = "apatitecore."+e.getPlayer().getName()+"."+nodeName;
        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));
    }
    
    @EventHandler
    public void BlockPlaceEvent(BlockPlaceEvent e) {
        String nodeName = "canPlaceBlocks";
        
        nodeName = "apatitecore."+e.getPlayer().getName()+"."+nodeName;
        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));
    }
    @EventHandler
    public void PlayerInteractEvent(PlayerInteractEvent e) {
        String nodeName = "canInteract";
        
        nodeName = "apatitecore."+e.getPlayer().getName()+"."+nodeName;
        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));
    }

    @EventHandler
    public void EntityDamageEvent(EntityDamageEvent e) {
        if(!(e.getEntity() instanceof Player)) return;
            Player pl = (Player) e.getEntity();
        String nodeName = "canGetDamage";
        nodeName = "apatitecore."+pl.getName()+"."+nodeName;

        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));
    }
    
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent e) {
        if(!(e.getDamager() instanceof Player)) return;
            Player pl = (Player) e.getDamager();
        String nodeName = "canAttackEntities";
        nodeName = "apatitecore."+pl.getName()+"."+nodeName;

        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));

    }
    @EventHandler
    public void AsyncPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player pl = e.getPlayer();
        String nodeName = "canChat";
        nodeName = "apatitecore."+pl.getName()+"."+nodeName;
        
        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));
    }
    @EventHandler
    public void PlayerCommandPreprocessEvent(PlayerCommandPreprocessEvent e) {
        Player pl = e.getPlayer();
        
        String nodeName = "canUseCommands";
        nodeName = "apatitecore."+pl.getName()+"."+nodeName;
        
        boolean can = calculatePermission(nodeName, true);
        e.setCancelled(decideIsCancelled(e.isCancelled(), can));
    }
    
    public boolean calculatePermission(String node, boolean default1){
        if(!ApatiteCodeCore.kvs.hasKey(node))
            return default1;
        else return ((boolean) ApatiteCodeCore.kvs.getObject(node));
    }
    
    public boolean decideIsCancelled(boolean alreadyCancelled, boolean can){
        if(alreadyCancelled) return true;
        return !can;
    }
    
}
