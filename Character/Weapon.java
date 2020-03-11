package Character;

public class Weapon implements IWeapon
{
    private String name;
    private int dmg;
    private int type;

    private int strength;
    private int magic;
    private int agility;

    public Weapon(String name, int dmg, int type, int strength, int magic,int agility)
    {
        this.name = name;
        this.dmg = dmg;
        this.type = type;
        this.strength = strength;
        this.magic = magic;
        this.agility = agility;
    }

    public String getName() {
        return this.name;
    }

    public int getDmg()
    {
	    return this.dmg;
    }
    
    public int getType()
    {
	    return this.type;
    }

    public int getStrength()
    {
	    return this.strength;
    }
    
    public int getMagic()
    {
	    return this.magic;
    }

    public int getAgility()
    {
	    return this.agility;
    }
}