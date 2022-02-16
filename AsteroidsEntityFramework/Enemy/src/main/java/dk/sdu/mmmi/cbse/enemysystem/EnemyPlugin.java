package dk.sdu.mmmi.cbse.enemysystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.enemysystem.Enemy;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        
        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Entity createEnemyShip(GameData gameData) {

        float deacceleration = 10;
        float acceleration = 400;
        float maxSpeed = 300;
        float rotationSpeed = 0;
        float x = (float) (gameData.getDisplayWidth() * Math.random());
        float y = (float) (gameData.getDisplayHeight() * Math.random());
        float radians = 3.1415f / 2;
        
        Entity enemyShip = new Enemy();
        MovingPart movingPart = new MovingPart(deacceleration, acceleration, maxSpeed, rotationSpeed);
        movingPart.setUp(true);
        enemyShip.add(movingPart);
        PositionPart positionPart =new PositionPart(x, y, radians);
        positionPart.setRadians((float) (Math.random()*Math.PI));
        enemyShip.add(positionPart);

        
        return enemyShip;
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        world.removeEntity(enemy);
    }

}
