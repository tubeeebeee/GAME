package bth2;

import java.util.Objects;

public class KinematicWander {

    Character character;
    private float maxSpeed;
    private float maxRotation;

    public KinematicWander() {
        super();
    }

    public KinematicWander(Character character, float maxSpeed, float maxRotation) {
        super();
        this.character = character;
        this.maxSpeed = maxSpeed;
        this.maxRotation = maxRotation;
    }

    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public float getMaxRotation() {
        return maxRotation;
    }

    public void setMaxRotation(float maxRotation) {
        this.maxRotation = maxRotation;
    }

    @Override
    public String toString() {
        return "KinematicWander [character=" + character + ", maxSpeed=" + maxSpeed + ", maxRotation=" + maxRotation
                + "]";
    }

    @Override
    public boolean equals(Object obj) {
        // TODO Auto-generated method stub
        return super.equals(obj);
    }

    public static int getBinomial(int n, double p) {
        double log_q = Math.log(1.0 - p);
        int x = 0;
        double sum = 0;
        for (;;) {
            sum += Math.log(Math.random()) / (n - x);
            if (sum < log_q) {
                return x;
            }
            x++;
        }
    }

    public KinematicSteeringOuput generateKinematicSteeringOuput() {
        Vector2D orientation = new Vector2D();
        orientation.setZ((float) Math.cos(character.getOrientation()));
        orientation.setX((float) Math.sin(character.getOrientation()));
        Vector2D velocity = new Vector2D();
        velocity = orientation.mulConstant(maxSpeed);
        float rotation = getBinomial(100, 5.0) * maxRotation;
        return new KinematicSteeringOuput(velocity, rotation);
    }
    
    public static void main(String[] args) {
        Character character = new Character();
        character.setPosition(new Vector2D(2, 1));


        KinematicWander kinematicWander = new KinematicWander(character, 1, 1);
        KinematicSteeringOuput kinematicOutput = kinematicWander.generateKinematicSteeringOuput();
        System.out.println(kinematicOutput);

//        character.update(kinematicOutput, 1);
        character.applyNewOrientation();

        System.out.println(character.getPosition());
        System.out.println(character.getOrientation());
    }
}
