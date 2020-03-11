package Character;

public interface ICharacter {
    String getName();
    int getHp();
    int getMp();
    int getArmor();

    int getStrength();
    int getMagic();
    int getAgility();

    void setHp(int character_hp);

    IWeapon getWeapon();
    void equip(IWeapon weapon);

    void attack(ICharacter target);
	int defend(int dmg, int agility);
}