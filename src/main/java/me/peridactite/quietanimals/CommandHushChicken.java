package me.peridactite.quietanimals;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import java.util.ArrayList;
import java.util.List;

public class CommandHushChicken implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        List<LivingEntity> entities = Bukkit.getWorld("world").getLivingEntities();
        ArrayList<LivingEntity> chickenList = new ArrayList<>();
        int chickenCount = 0;
        for(LivingEntity c : entities){
            System.out.println("Entity: " + c);
            if(c.getType() == EntityType.CHICKEN){
                System.out.println("Chicken Found");
                chickenCount++;
                chickenList.add(c);
                c.setSilent(true);
            }else{
                //System.out.println("Not Chicken");
            }
            System.out.println("Muted " + chickenCount + " chickens.");
        }
        return true;
    }
}
