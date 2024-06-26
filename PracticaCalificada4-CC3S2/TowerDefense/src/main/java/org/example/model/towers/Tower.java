package org.example.model.towers;

import org.example.model.Position;
import org.example.model.enemies.Enemy;

import java.util.List;

public class Tower {
    private int damage;
    private int range;
    private int fireRate; // turnos entre disparos
    private Position position;

    public Tower(int damage, int range, int fireRate) {
        this.damage = damage;
        this.range = range;
        this.fireRate = fireRate;
        this.position =  new Position(0, 0);
    }
    // Constructores, getters y setters
    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRange() {
        return this.range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFireRate() {
        return this.fireRate;
    }

    public void setFireRate(int fireRate) {
        this.fireRate = fireRate;
    }

    public void setPosition(int x, int y) {
        position.setPosition(x, y);
    }

    public void attack(List<Enemy> enemies) {
        for (Enemy enemy: enemies){
            if (Math.abs(enemy.getPosition().getX() - position.getX()) == range ||
                    Math.abs(enemy.getPosition().getY() - position.getY()) == range) {
                enemy.downHealth(damage);
            }

        }
    }
}