package Ennemy;

import java.util.List;

import Character.Character;
import Character.Weapon;

public class Ennemy extends Character
{
    public List<Ennemy> ennemies;

    private Ennemy(EnnemyBuilder ennemyBuilder) {
        super(ennemyBuilder.name, ennemyBuilder.hp, ennemyBuilder.mp, ennemyBuilder.armor, ennemyBuilder.strength, ennemyBuilder.magic, ennemyBuilder.agility, ennemyBuilder.weapon);
        }

    public void removeEnnemy(Ennemy ennemy_name)
    {
	    ennemies.remove(ennemy_name);
    }

    public List<Ennemy> getEnnemy()
    {
	    return ennemies;
    }

    public static class EnnemyBuilder {
        private String name;
        private int hp;
        private int mp;
        private int armor;
        private int strength;
        private int magic;
        private int agility;
        private final Weapon weapon;

        public EnnemyBuilder(Weapon weapon)
        {
            this.weapon = weapon;
        }

        public EnnemyBuilder setName(String name)
        {
            this.name = name;
            return this;   
        }

        public EnnemyBuilder setHp(int hp)
        {
            this.hp = hp;
            return this;   
        }

        public EnnemyBuilder setMp(int mp)
        {
            this.mp = mp;
            return this;   
        }

        public EnnemyBuilder setArmor(int armor)
        {
            this.armor = armor;
            return this;   
        }

        public EnnemyBuilder setStrength(int strength)
        {
            this.strength = strength;
            return this;   
        }

        public EnnemyBuilder setMagic(int magic)
        {
            this.magic = magic;
            return this;   
        }

        public EnnemyBuilder setAgility(int agility)
        {
            this.agility = agility;
            return this;   
        }

        public Ennemy build() {
            return new Ennemy(this);
        }
    }
}