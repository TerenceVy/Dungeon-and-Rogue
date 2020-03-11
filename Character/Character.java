package Character;

public class Character implements ICharacter
{
    protected String name;
    protected int hp;
    protected int mp;
    protected int armor;
    protected int strength;
    protected int magic;
    protected int agility;
    protected Weapon weapon;

    public Character(String name, int hp, int mp, int armor,int strength,int magic,int agility, Weapon weapon)
    {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.armor = armor;
        this.strength = strength;
        this.magic = magic;
        this.agility = agility;
        this.weapon = weapon;
    }

    public String getName() {
        return this.name;
    }

    public int getHp()
    {
	    return this.hp;
    }
    
    public int getMp()
    {
	    return this.mp;
    }

    public int getArmor()
    {
	    return this.armor;
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

    public void setMp(int mp)
    {
	    this.mp = mp;
    }

    public void setHp(int hp)
    {
	    this.hp = hp;
    }

    @Override
    public IWeapon getWeapon() {
        return weapon;
    }

    @Override
    public void equip(IWeapon weapon) {

    }

    @Override
    public void attack(ICharacter target)
    {
       
	    int dmg = 0;
        int target_hp = 0;
        boolean calculdamage = true;
        int mp = getMp();
	    
	    if(getWeapon() != null)
		{
		    System.out.println("\n["+getName()+"] attack ["+target.getName()+"] with "+weapon.getName());
		    if(weapon.getType() == 1)
			{
			    dmg = DiceRoller.Dice2(getStrength());
			    if(dmg != 0 && dmg+weapon.getDmg() > target.getArmor())
				{
                    dmg = (dmg + (weapon.getDmg())) - target.getArmor();
				    if(dmg <= 0)
					    System.out.println("["+target.getName()+ "] lose 0 hp");
				}
                else
                {
                    System.out.println("Strength attack failed !");
                    calculdamage = false;
                }
			}
		    else if(weapon.getType() == 2)
			{
                dmg = DiceRoller.Dice2(getMagic());
                if (dmg+weapon.getDmg() < getMp())
                    if(dmg != 0)
                    {
                        dmg = dmg + weapon.getDmg();
                        mp = getMp() - dmg;
                        setMp(mp+2);
                    }
                    else
                    {
                        System.out.println("Magic attack failed !");
                        mp = getMp() - weapon.getDmg();
                        calculdamage = false;
                        setMp(mp+2);				
                    }
                else
                    {
                    System.out.println("Not Enough mp");
                    calculdamage = false;
                    setMp(mp+2);
                    }
			}
		    else if(weapon.getType() == 3)
			{
			    dmg = DiceRoller.Dice2(getAgility());
			    if(dmg != 0 && dmg+weapon.getDmg() > target.getArmor() )
				{
                    dmg = (dmg + (weapon.getDmg())) - target.getArmor();
				    if(dmg <= 0)
					    System.out.println("["+target.getName()+ "] lose 0 hp");
				}
                else
                    {
                    System.out.println("Agility attack failed!");
                    calculdamage = false;    
                    }
			}
		}
	    else
		{
		    System.out.println("["+getName()+"] don't have weapon");
		    dmg = getStrength();
        }
        if(calculdamage == true)
        {
	    dmg = defend(dmg, getAgility());
	    System.out.println("["+getName()+"] deals "+dmg+" damages\n");
	    target_hp = target.getHp() - dmg;
        target.setHp(target_hp);
        if (target_hp <= 0)
            System.out.println("["+target.getName()+ "] is dead !\n");
        }
        else
        System.out.println("["+getName()+"] deals 0 damages");
	
    }

    @Override
    public int defend(int dmg, int agility) {
        if (agility < dmg)
        {
            return dmg - getArmor();
        }
        else if (agility == dmg)
        {
            dmg = dmg /2;
            dmg = dmg - getArmor();
            return dmg;
        }
        else
            return 0;
    }

    public boolean isDead(Character character)
    {
        if(character.getHp() <= 0)
            return true;
        return false;
    }
}