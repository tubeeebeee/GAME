/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bth2;

import java.util.Objects;

/**
 *
 * @author lebao
 */
public class KinematicSteeringOuput {
    private Vector2D velocity;
    private float rotation;

    public KinematicSteeringOuput() {
    }

    public KinematicSteeringOuput(Vector2D velocity, float rotation) {
        this.velocity = velocity;
        this.rotation = rotation;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    public float getRotation() {
        return rotation;
    }

    public void setVelocity(Vector2D velocity) {
        this.velocity = velocity;
    }

    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    @Override
    public String toString() {
        return "KinematicSteeringOuput{" + "velocity=" + velocity + ", rotation=" + rotation + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.velocity);
        hash = 83 * hash + Float.floatToIntBits(this.rotation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KinematicSteeringOuput other = (KinematicSteeringOuput) obj;
        if (Float.floatToIntBits(this.rotation) != Float.floatToIntBits(other.rotation)) {
            return false;
        }
        if (!Objects.equals(this.velocity, other.velocity)) {
            return false;
        }
        return true;
    }
    
}
