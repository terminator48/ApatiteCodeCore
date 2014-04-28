/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apatitecodecore;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import playerApi.ApatitePlayer;

/**
 *
 * @author Daniil
 */
public class Command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, org.bukkit.command.Command cmnd, String string, String[] strings) {
        if (cs.isOp() || cs.hasPermission("apatitecodecore.db")) {
            if (strings.length >= 2) {
                if(strings[0].equals("freeze")){
                    Player pl = (Player) cs;
                    ApatitePlayer apa = new ApatitePlayer(pl);
                            
                    apa.setCanAttackEntities(false).setCanChat(false).setCanDestroyBlocks(false).setCanGetDamage(false).setCanInteract(false).setCanMove(false).setCanPlaceBlocks(false).setCanUseCommands(false);
                }else
                if(strings[0].equals("remove")){
                    ApatiteCodeCore.kvs.removeKey(strings[1]);
                    cs.sendMessage("Key removed");
                }else 
                
                if (strings[0].equals("view")) {
                    cs.sendMessage("View command dispatched");
                    Object obj = ApatiteCodeCore.kvs.getObject(strings[1]);
                    if(obj instanceof String)
                        cs.sendMessage((String) obj);
                    else cs.sendMessage(obj.toString());
                } else if (strings[0].equals("set")) {

                    Object what;
                    if (strings[2].equals("true")) {
                        what = true;
                    } else if (strings[2].equals("false")) {
                        what = false;
                    } else {
                        what = strings[2];
                    }
                    cs.sendMessage("Set " + strings[1] + " to " + what);
                    ApatiteCodeCore.kvs.setObject(strings[1], what);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            cs.sendMessage("Not enought permissions");
        }

        return true;
    }
}
