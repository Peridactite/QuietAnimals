package me.peridactite.quietanimals;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class CommandHushAnimals implements CommandExecutor {
    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //Initialize player var
        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
            // Here we need to give items to our player
        }

        //Setup args variables
        boolean willHush = true;
        int range = -1;
        //First arg means whether animals are silenced or not
        if (args.length > 0) {
            if (args[0].equals("true")) {
                willHush = true;
            } else if (args[0].equals("false")) {
                willHush = false;
            } else {
                return false;
            }
        }

        //Second arg is range of silencing
        try{
            if (args.length > 1){
                if(Integer.parseInt(args[1]) > 0){
                    range = Integer.parseInt(args[1]);

                }else{
                    System.out.println("User failed to enter appropriate number");
                    return false;
                }
            }

        }catch(NumberFormatException  a){
            a.printStackTrace();
            return false;
        }

        switch(args.length){
            case 2:
                someAnimals(willHush, range, player);
                break;
            default:
                allAnimals(willHush);
                break;
        }

        return true;
    }

    public void someAnimals(boolean willHush, int range, Player player){

        Location location = player.getLocation();
        List<Entity> nearbyEntites = (List)location.getWorld().getNearbyEntities(location, range, range, range);
        ArrayList<Entity> animalList = new ArrayList<>();
        int animalCount = 0;
        for(Entity c : nearbyEntites){
            System.out.println("Entity: " + c);
            if(c.getType() == EntityType.CHICKEN || c.getType() == EntityType.COW || c.getType() == EntityType.PIG || c.getType() == EntityType.SHEEP){
                System.out.println("Animal Found");
                animalCount++;
                animalList.add(c);
                c.setSilent(willHush);
            }else{
                //System.out.println("Not Animals");
            }
        }
        System.out.println("Muted " + animalCount + " animals.");
    }

    public void allAnimals(boolean willHush){

        List<LivingEntity> entities = Bukkit.getWorld("world").getLivingEntities();
        ArrayList<LivingEntity> animalList = new ArrayList<>();
        int animalCount = 0;
        for(LivingEntity c : entities){
            System.out.println("Entity: " + c);
            if(c.getType() == EntityType.CHICKEN || c.getType() == EntityType.COW || c.getType() == EntityType.PIG || c.getType() == EntityType.SHEEP){
                System.out.println("Animal Found");
                animalCount++;
                animalList.add(c);
                c.setSilent(willHush);
            }else{
                //System.out.println("Not Animal");
            }
        }
        System.out.println("Muted " + animalCount + " animals.");
    }
}
