package dk.sdu.mmmi.cbse.collisionsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.EntityPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.playersystem.Player;

public class CollisionPlugin implements IPostEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity entity :
                world.getEntities()) {
            for (Entity other :
                    world.getEntities()) {
                if(entity == other){
                    break;
                }
                float[] entityX = entity.getShapeX();
                float[] otherX = other.getShapeX();

                PositionPart entityPos = entity.getPart(PositionPart.class);
                PositionPart otherPos = other.getPart(PositionPart.class);

                float eX = entityPos.getX();
                float eY = entityPos.getY();
                float oX = otherPos.getX();
                float oY = otherPos.getY();

                float dX = Math.abs(eX - oX);
                float dY = Math.abs(eY - oY);

                if(dX < 25 && dY < 25){
                    System.out.println("Hit" + dX + ", " + dY);
                    world.removeEntity(checkCollision(entity, other));
                }
            }
        }
    }

    private Entity checkCollision(Entity entity, Entity other){

        if(entity.getClass() == other.getClass()){
            return new Entity();
        }

        return (Player.class == entity.getClass()) ? other : entity;

    }
}
