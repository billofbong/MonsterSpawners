package org.awesomecraft.plugins.monsterspawners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public class MonsterSpawners extends JavaPlugin {
    public void onDisable() {
        System.out.println(this + " is now disabled!");
    }

    public void onEnable() {
        getCommand("MS").setExecutor(new CommandExecutor() {

            public boolean onCommand(CommandSender cs, Command cmnd, String alias, String[] args) {
                Player player = (Player)cs; //Constructs the player
                if(player.hasPermission("ms.use")) {
                if(args.length == 1) {
                    PlayerInventory inventory = player.getInventory(); //Gets the player's inventory
                    try {    
                    ItemStack ms = new ItemStack(Material.MOB_SPAWNER, Integer.parseInt(args[0])); //Constructs the stack
                    inventory.addItem(ms); //Adds the stack
                    player.sendMessage(ChatColor.GREEN + "You have been given " + args[0].toString() + " monster spawners.");
                    
                    }
                    catch(NumberFormatException e) {
                        player.sendMessage(ChatColor.RED + ("Usage: /ms (amount)")); //Error caught
                    }
                }
                else{
                     player.sendMessage(ChatColor.RED + ("Usage: /ms (amount)")); //Error caught
                    }
                }
                else{
                    player.sendMessage(ChatColor.RED + "You don't have permission for this. If you believe this is in");
                    player.sendMessage(ChatColor.RED + "error, please contact the server administrators.");
                }
                
                return true;
            }
        });
        
        System.out.println(this + " is now enabled!");
    }
}
