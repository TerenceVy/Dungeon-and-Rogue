import Ennemy.Ennemy;
import Game.Game;
import Room.Room;

import java.util.ArrayList;

import Character.Player;
import Character.Weapon;

public class Main {
    public static void main(String[] args) {

        Weapon little_sword = new Weapon("little_sword", 3, 1, 1, 0, 0);
        Weapon broken_sword = new Weapon("broken_sword", 15, 1, 3, 0, 0);
        Weapon green_arrow = new Weapon("green_arrow", 4, 2, 0, 0, 0);
        Weapon firebolt = new Weapon("firebolt", 2, 2, 0, 1, 0);
        Player Player = new Player("Player", 100, 10, 4, 2, 2, 1, broken_sword);

        Ennemy Ennemy1 = new Ennemy.EnnemyBuilder(little_sword).setName("Swordman").setHp(10).setMp(0).setArmor(2)
                .setStrength(2).setMagic(0).setAgility(1).build();

        Ennemy Ennemy2 = new Ennemy.EnnemyBuilder(green_arrow).setName("Archery").setHp(10).setMp(10).setArmor(2)
                .setStrength(2).setMagic(0).setAgility(1).build();

        Ennemy Ennemy3 = new Ennemy.EnnemyBuilder(firebolt).setName("Witch").setHp(10).setMp(10).setArmor(2)
                .setStrength(2).setMagic(0).setAgility(1).build();

        Ennemy Ennemy4 = new Ennemy.EnnemyBuilder(firebolt).setName("Witch").setHp(10).setMp(10).setArmor(2)
                .setStrength(2).setMagic(0).setAgility(1).build();

        Ennemy Ennemy5 = new Ennemy.EnnemyBuilder(firebolt).setName("Witch").setHp(10).setMp(10).setArmor(2)
                .setStrength(2).setMagic(0).setAgility(1).build();        

        ArrayList<Ennemy> ennemies = new ArrayList<Ennemy>();
        ArrayList<Ennemy> ennemies2 = new ArrayList<Ennemy>();

        ennemies.add(Ennemy1);
        ennemies.add(Ennemy2);

        ennemies2.add(Ennemy3);
        ennemies2.add(Ennemy4);
        ennemies2.add(Ennemy5);


        Room room1 = new Room(ennemies,Player);

        Room room2 = new Room(ennemies2,Player);

        ArrayList<Room> rooms = new ArrayList<Room>();
        rooms.add(room1);
        rooms.add(room2);
        Game game = new Game();
        game.Dungeon(rooms);

        //game.Dungeon(ennemies, Player);
    }
}