package me.BigOne.AdobeGFX.NorwayZaGa.Hat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Hat extends JavaPlugin
{
  public ChatColor red = ChatColor.RED;
  public ChatColor gray = ChatColor.GRAY;
  public ChatColor green = ChatColor.GREEN;
  String console = this.red + "Denne kommandoen kan bare bli kjørt av en spiller!";
  String permission = this.red + "Du har ikke permission til dette!";
  String message1 = this.green + "Du satt ";
  String message2 = this.green + " på hodet!";

  public void onDisable()
  {
    System.out.println("=========( BigOne Hat )=========");
    System.out.println("[BigOne Hat] is disabled!");
  }

  public void onEnable() {
    System.out.println("=========( BigOne Hat )=========");
    System.out.println("[BigOne Hat] is enabled!");
  }

  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (!(sender instanceof Player)) {
      sender.sendMessage(ChatColor.RED + this.console);
      return true;
    }
    Player p = (Player)sender;
    ItemStack helmet = p.getInventory().getItemInHand();
    if (command.getName().equalsIgnoreCase("hat")) {
      if (!p.hasPermission("BigOne.hat")) {
        p.sendMessage(this.permission);
        return true;
      }
      if (args.length >= 0);
      p.getInventory().setItemInHand(p.getInventory().getHelmet());
      p.getInventory().setHelmet(helmet);
      p.sendMessage(this.message1 + this.gray + p.getInventory().getHelmet().getType() + "(" + p.getInventory().getHelmet().getTypeId() + ")" + this.message2);
      return true;
    }
    if (p.getInventory().getItemInHand().equals("AIR")) {
      p.getInventory().setItemInHand(p.getInventory().getHelmet());
      p.getInventory().setHelmet(helmet);
      p.sendMessage(this.green + "Du fjernet hjelmen din fra hodet.");
      return true;
    }

    return false;
  }
}