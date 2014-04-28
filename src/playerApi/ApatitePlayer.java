/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playerApi;

import apatitecodecore.ApatiteCodeCore;
import org.bukkit.entity.Player;

/**
 *
 * @author Daniil
 */
public class ApatitePlayer{
    Player pl;
    public ApatitePlayer(Player pl1){
        pl = pl1;
    }
    public ApatitePlayer setCanMove(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canMove", value);
        return this;
    }
    public ApatitePlayer setCanDestroyBlocks(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canDestroyBlocks", value);
        return this;
    }
    public ApatitePlayer setCanPlaceBlocks(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canPlaceBlocks", value);
        return this;
    }
    public ApatitePlayer setCanInteract(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canInteract", value);
        return this;
    }
    public ApatitePlayer setCanGetDamage(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canGetDamage", value);
        return this;
    }
    public ApatitePlayer setCanAttackEntities(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canAttackEntities", value);
        return this;
    }
    public ApatitePlayer setCanChat(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canChat", value);
        return this;
    }
    public ApatitePlayer setCanUseCommands(boolean value){
        ApatiteCodeCore.kvs.setObject("apatitecore."+pl.getName()+".canUseCommands", value);
        return this;
    }
}
