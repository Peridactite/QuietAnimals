package me.peridactite.quietanimals;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;

public class CommandHushChicken implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        EntityType chickenType = EntityType.CHICKEN;
        for(EntityType c : chickenType.values()){
            System.out.println("Chicken: " + c);
        }
        return true;
    }
}
