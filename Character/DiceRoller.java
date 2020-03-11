package Character;

public class DiceRoller {
	static public int Dice2(int number) {
        int score = 0;
        int a = 0;
        for (int i = 0; i < (number+1); i++)
        {
            a = (int) Math.round(Math.random() + (number * (int) Math.round(Math.random())));
            if(a > 0)
                score++;
        }
        if (a > 0)
            return score;
        else
            return 0;
	}
}