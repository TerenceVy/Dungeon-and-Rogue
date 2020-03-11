package Game;

import java.util.ArrayList;
import java.util.Scanner;

import Room.Room;
public class Game {

    private static int test = 0;

    public void Dungeon(ArrayList<Room> room)
    {
            System.out.println("\nWelcome to the Room n°["+ test +"] of the Dungeon !\n");
            System.out.println("-------------------");
            System.out.println("\nYour beginning stats:");
            System.out.println("["+room.get(0).player.getName()+"] HP : "+room.get(0).player.getHp());
            System.out.println("["+room.get(0).player.getName()+"] MP : "+room.get(0).player.getMp());
            System.out.println("["+room.get(0).player.getName()+"] ARMOR : "+room.get(0).player.getArmor());
            System.out.println("["+room.get(0).player.getName()+"] STRENGTH : "+room.get(0).player.getStrength());
            System.out.println("["+room.get(0).player.getName()+"] MAGIC : "+room.get(0).player.getMagic());
            System.out.println("["+room.get(0).player.getName()+"] AGILITY : "+room.get(0).player.getAgility());
            System.out.println("["+room.get(0).player.getName()+"] WEAPON : "+room.get(0).player.getWeapon().getName()+"\n");
            while(ifRoomEmpty(room)== false)
            {
            System.out.println("\nYou are in the Room n°["+ test +"] !\n");
            int i = 0;
            int x = 0;
            System.out.println("-------------------");
            System.out.println("Your stats:");
            System.out.println("["+room.get(0).player.getName()+"] HP : "+room.get(0).player.getHp());
            System.out.println("["+room.get(0).player.getName()+"] MP : "+room.get(0).player.getMp()+"\n");

            System.out.println("There are still enemies : ");
            while(x < room.get(0).ennemies.size())
            {
                if(room.get(0).ennemies.get(x) != null)
                {
                    System.out.println("["+room.get(0).ennemies.get(x).getName()+"] with "+ room.get(0).ennemies.get(x).getHp()+" HP");
                    x++;
                }
            }
            System.out.println("\nWhich one do you want to attack ?");
            while(i < room.get(0).ennemies.size())
                {
                if(room.get(0).ennemies.get(i) != null)
                    {
                    System.out.println((i+1)+") "+room.get(0).ennemies.get(i).getName());
                    i++;
                    }
                }
            Scanner scan = new Scanner(System.in);
            int choice;
            
            while (!scan.hasNextInt())
                {
                String input = scan.next();
                System.out.printf("\"%s\" isn't in the list.\n", input);
                }
            choice = scan.nextInt();
            
            if(choice <= 0 || choice > room.get(0).ennemies.size() )
                System.out.println("\nThis ennemy doesn't exist");        
            else
                {
                    room.get(0).player.attack(room.get(0).ennemies.get(choice-1));
                if(room.get(0).ennemies.get(choice-1).isDead(room.get(0).ennemies.get(choice-1)) == true)
                room.get(0).ennemies.remove(choice-1);
                int compteur = 0;
                
                while(compteur < room.get(0).ennemies.size())
                    {
                    if(room.get(0).ennemies.get(compteur).isDead(room.get(0).ennemies.get(compteur)) == false)
                    room.get(0).ennemies.get(compteur).attack(room.get(0).player);
                    compteur++;
                    }
                if(room.get(0).player.isDead(room.get(0).player) == true)
                    {
                    System.out.println("\nYou died. \n");
                    break;
                    }
                }
            }
    }

    private boolean ifRoomEmpty(ArrayList<Room> rooms) {
        if(rooms.get(0).ennemies.isEmpty())
        {
            rooms.remove(0);
            test++;
            if(rooms.isEmpty())
            {return true;}
        }
        return false;
    }
}