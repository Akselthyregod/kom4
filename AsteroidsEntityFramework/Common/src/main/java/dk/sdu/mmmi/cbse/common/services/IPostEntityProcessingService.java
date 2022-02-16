package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

/**
 *
 * @author jcs
 */
public interface IPostEntityProcessingService  {

        /**
         * process checks for entity collision
         *
         * GameData is events, positions, sizes
         * World is entities e.g. enemies, player and meteor
         *
         * pre: game is running and IEntityProcessingService.process() has been run
         * post: entity collision has been detected
         *
         * @param gameData
         * @param world
         */

        void process(GameData gameData, World world);
}
