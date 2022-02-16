package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     * process updates entities
     *
     * GameData is events, positions, sizes
     * World is entities e.g. enemies, player and meteor
     *
     * pre: game is running
     * post: entities has been updated
     *
     * @param gameData
     * @param world
     */

    void process(GameData gameData, World world);
}
