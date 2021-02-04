package cn.cutemc.ccopen;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class CCOpen extends JavaPlugin implements Listener {
    public Logger log = null;
    public String out = null;
    @Override
    public void onEnable() {
        log = getLogger();
        log.info(ChatColor.GOLD+"***************************");
        log.info(ChatColor.GOLD+"*欢迎使用CCOpen插件");
        log.info(ChatColor.GOLD+"*正在注册事件");
        try {
            getServer().getPluginManager().registerEvents(this, this);
        } catch (Exception e) {
            e.printStackTrace();
            out = e.getMessage();
        } finally {
            if (out != (null)) {
                log.info(ChatColor.GOLD+"*注册失败!");
                log.info(ChatColor.RED+"*原因: " + ChatColor.DARK_RED + out);
                log.info(ChatColor.GOLD+"*CCOpen启动失败");
                getServer().getPluginManager().disablePlugin(this);
            } else {
                log.info(ChatColor.GOLD+"*CCOpen已启动");
            }
            getLogger().info(ChatColor.GOLD+"*作者:路上看见 QQ:1149014559");
            getLogger().info(ChatColor.GOLD+"***************************");
        }

    }
    @Override
    public void onDisable() {
        if (out != null) {
            getLogger().info(ChatColor.GOLD+"***************************");
            getLogger().info(ChatColor.GOLD+"*感谢使用CCOpen插件");
            getLogger().info(ChatColor.GOLD+"*正在卸载插件...");
            getLogger().info(ChatColor.GOLD+"*CCOpen插件已卸载");
            getLogger().info(ChatColor.GOLD+"*作者:路上看见 QQ:1149014559");
            getLogger().info(ChatColor.GOLD+"***************************");
        }
    }
    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent e){
        if(e.getMessage().equalsIgnoreCase("/menu2")||e.getMessage().equalsIgnoreCase("/rpg")||e.getMessage().equalsIgnoreCase("/cssd")||e.getMessage().equalsIgnoreCase("/c2")){
            e.setCancelled(true);
            Bukkit.getScheduler().runTaskLater(this,() ->{
                if(e.getMessage().equalsIgnoreCase("/menu2")){
                    e.getPlayer().chat("/chestcommands open 菜单2");
                }else if(e.getMessage().equalsIgnoreCase("/rpg")){
                    e.getPlayer().chat("/chestcommands open RPG商店");
                }else if(e.getMessage().equalsIgnoreCase("/cssd")){
                    e.getPlayer().chat("/chestcommands open 出售商店");
                }else if(e.getMessage().equalsIgnoreCase("/c2")){
                    e.getPlayer().chat("/chestcommands open 商店菜单");
                }
            },5L);
        }
    }
}
