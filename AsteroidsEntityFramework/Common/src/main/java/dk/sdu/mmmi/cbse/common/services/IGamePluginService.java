package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {

    /**
     * start is used to initialize the game
     *
     * GameData is events, positions, sizes
     * World is entities e.g. enemies, player and meteor
     *
     * pre: nothing
     * post: game has been started and entities loaded
     *
     * @param gameData
     * @param world
     */
    void start(GameData gameData, World world);

    /**
     * stop is used to close the game
     *
     * GameData is events, positions, sizes
     * World is entities e.g. enemies, player and meteor
     *
     * pre: game running
     * post: game has been closed
     *
     * @param gameData
     * @param world
     */
    void stop(GameData gameData, World world);
}
