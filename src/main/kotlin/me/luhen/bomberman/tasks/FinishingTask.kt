package me.luhen.bomberman.tasks

import me.luhen.bomberman.Bomberman
import me.luhen.bomberman.game.Game
import me.luhen.bomberman.mechanics.GameFunctions
import me.luhen.bomberman.mechanics.PlayerManagement
import org.bukkit.scheduler.BukkitRunnable

class FinishingTask(val game: Game): BukkitRunnable() {

    override fun run() {

        val config = game.gameFile
        val players = game.players.toList()
        val spectators = game.spectators.toList()

        //Teleport everyone back or to the podium
        players.forEach{ PlayerManagement.removeFromArena(game, it)}
        spectators.forEach{ PlayerManagement.removeFromArena(game, it)}

        game.bombermans.clear()
        //Sets this game arena as available again
        Bomberman.instance.currentGames.remove(game)
        Bomberman.instance.gameFiles[config.getString("arena-name").toString()] = false

        //Check for players on queue
        if(Bomberman.instance.playersOnQueue.size >= 1){
            //Create new game from the same gameFile
            GameFunctions.createNewGame(config)
        }
    }
}