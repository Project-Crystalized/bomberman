package me.luhen.bomberman.events.custom

import me.luhen.bomberman.game.Game
import org.bukkit.Location
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

class DropPerkEvent(val location: Location, val game: Game): Event() {

    companion object {

        private val HANDLERS = HandlerList()

        @JvmStatic
        fun getHandlerList(): HandlerList{
            return HANDLERS
        }

    }


    override fun getHandlers(): HandlerList {
        return HANDLERS
    }

}