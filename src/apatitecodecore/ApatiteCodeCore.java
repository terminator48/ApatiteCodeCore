/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apatitecodecore;

import apatitecodecore.keyValueStorage.keyValueStorage;
import java.io.File;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import playerApi.EventListner;

/**
 *
 * @author Daniil
 */
public class ApatiteCodeCore  extends JavaPlugin implements Listener {

    public static final Logger _log = Logger.getLogger("Minecraft");
    public static keyValueStorage kvs = null;

    /**
     * @param args the command line arguments
     */
    
    @Override
    public void onEnable() {
        _log.info("[ApatiteCodeCore] Enabled!"); //вывод произвольного текста в консоль сервера
        Bukkit.getPluginManager().registerEvents(new EventListner(), this);
        kvs = new keyValueStorage(this.getDataFolder().getAbsolutePath()+File.separator+"database.db");
        getCommand("database").setExecutor(new Command());
    }
    
    @Override
    public void onDisable(){
        _log.info("[ApatiteCodeCore] Disabling!");
        _log.info("[ApatiteCodeCore] Saving database!");
        kvs.save(); 
    }
}
