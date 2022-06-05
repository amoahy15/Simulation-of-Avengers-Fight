import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints;
    private int lightATK;
    private int heavyATK;



    public Hero(){
        this.name = "unknown";
        this.hitPoints = 0;
        this.lightATK = 0;
        this.heavyATK = 0;


    }
    public Hero(String name, int hitPoints, int lightATK, int heavyATK){
        this.name = name;
        this.hitPoints = hitPoints;
        this.lightATK = lightATK;
        this.heavyATK = heavyATK;

    }
    public boolean isAlive(){
        if(this.hitPoints > 0){
          return true;
        }else{
            return false;
        }
    }
    public int attack(){
        Random rand = new Random();
        int n = rand.nextInt(4);
        if(n <= 2){
          return this.lightATK;
        }else{
            return this.heavyATK;
        }

    }

    public void takeDamage(int damage){
        this.hitPoints = this.hitPoints - damage;

    }
    public void displayHealth(){
        System.out.print(this.hitPoints);

    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getLightATK() {
        return lightATK;
    }

    public void setLightATK(int lightATK) {
        this.lightATK = lightATK;
    }

    public int getHeavyATK() {
        return heavyATK;
    }

    public void setHeavyATK(int heavyATK) {
        this.heavyATK = heavyATK;
    }
}

