package org.example.enemies;

public class BasicEnemyFactory implements EnemyFactory {
    @Override
    public Enemy createEnemy() {
        return new BasicEnemy();
    }
}
