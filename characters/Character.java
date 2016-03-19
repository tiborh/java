/**
 * Main class of the Java program.
 * This code allows you to represent a character to be used in a simple game. We
 * will learn better ways to do this when we have learned how to create objects.
 * 
 */

public class Character
{

    /* variables to describe the character */
    private String name;
    /** more info about the character */
    private String description;
    //to do: create a new String variable description
    /** health points */
    private int health;
    /** strength of secret weapon */
    private int secretWeapon;
    private static final int 健康 = 10;
    private static final int MAX_HEALTH = 健康 * 2;
    /* constants to describe possible values of secret Weapon */
    public static final int CLEVERNESS = 7; // cleverness-5 mainly used by heros 
    public static final int SPELL = 6; // spell-4 mainly used by wizards and witches
    public static final int SWORD = 5; // sword-3 mainly used by warriors
    public static final int TEETH = 4;  // teeth-2 mainly used by vampires
    public static final int CHAINS = 3; // chains-1 mainly used by ghosts
    public static final int NOWEAPON = 0;
    public static final int UNDEFINED = -1; // default value for weapon

    // Constructors
    public Character(String otherName){
        /* all this sentences are equivalent to make a call to the previous constructor
        (with all parameters) using this, and providing a default value for 
        all these variables for which we don't know its values. 
        name = otherName;
        description = "Undefined description";
        resetHealth();
        setSecretWeapon(UNDEFINED);
         */
        this(otherName, "Undefined description", 健康, UNDEFINED);
    }

    public Character(String なまえ, int ひみつへいき)
    {
        name = なまえ;
        description = "";
        health = 健康;
        setSecretWeapon(ひみつへいき);
    }

    public Character(String なまえ, int けんこう, int ひみつへいき)
    {
        name = なまえ;
        description = "";
        health = けんこう;
        setSecretWeapon(ひみつへいき);
    }

    public Character(String なまえ, String めいじょう, int ひみつへいき)
    {
        name = なまえ;
        description = めいじょう;
        health = 健康;
        setSecretWeapon(ひみつへいき);
    }

    public Character(String なまえ, String めいじょう, int けんこう, int ひみつへいき)
    {
        name = なまえ;
        description = めいじょう;
        health = けんこう;
        setSecretWeapon(ひみつへいき);
    }

    /** Summary information about the character */
    public void printInfo()
    {
        String result =  
            "*************************************"+ "\n" +  
            "Name: " + getName() + "\n" +
            "Description: " + getDescription() + "\n" +
            "Secret weapon: " + getSecretWeapon() + "\n" +
            "Health: " + getHealth() + "\n" +
            "Is alive? " + isAlive() + "\n" +
            "*************************************";
        System.out.println(result);
    }

    // methods
    public void setDescription(String めいじょう) { description = めいじょう; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getHealth() { return health; }

    public void setHealth(int けんこう) { health = けんこう; }

    private void resetHealth() { health = 健康; }

    public int getSecretWeapon() { return secretWeapon; }

    public void setSecretWeapon(int sw)
    {
        if(sw == CLEVERNESS || sw == SPELL || sw == SWORD ||
        sw == TEETH || sw == CHAINS){
            secretWeapon = sw;
        }else{
            secretWeapon = UNDEFINED;
        }
    }

    private void upgradeSecretWeapon(int winpoints)
    {
        secretWeapon += winpoints / 2;
    }

    // health of the enemy is not invluenced
    private  int  fight (int enemyWeapon)
    {
        int result= secretWeapon-enemyWeapon;
        health = health + result;
        return result;
    }

    public void fight (Character enemy)
    {
        int result = secretWeapon - enemy.getSecretWeapon();
        health = health + result;
        enemy.setHealth(enemy.getHealth() - result);
        if (!enemy.isAlive())
        {
            upgradeSecretWeapon(enemy.getSecretWeapon());
            enemy.setSecretWeapon(NOWEAPON);
        }
        if (!this.isAlive())
        {
            enemy.upgradeSecretWeapon(this.getSecretWeapon());
            this.setSecretWeapon(NOWEAPON);
        }
    }

    /*
    public void fight (Character character1, Character character2){
        int result = character1.getSecretWeapon() - character2.getSecretWeapon();
        character1.setHealth(character1.getHealth() + result);
        character2.setHealth(character2.getHealth() - result);
    }
    */

    public boolean isAlive() { return(health > 0); }
}