package me.imthelion.craftabletrolls.util;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import me.imthelion.craftabletrolls.trolls.Troll;

public class PlayerChoosePlayerEvent extends PlayerEvent implements Cancellable{
	
	private boolean isCancelled;
	private final Player selector;
	private static final HandlerList HANDLERS = new HandlerList();
	private final Troll troll;

	public PlayerChoosePlayerEvent(Player who, Player selector, Troll troll) {
		super(who);
		this.selector = selector;
		this.troll = troll;
	}
	
	public Player getSelector() {
		return selector;
	}
	
	public Troll getTroll() {
		return troll;
	}

	@Override
	public HandlerList getHandlers() {
		return HANDLERS;
	}
	
	public static HandlerList getHandlerList() {
		return HANDLERS;
	}

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean arg) {
		isCancelled = arg;
	}
	
	

}
