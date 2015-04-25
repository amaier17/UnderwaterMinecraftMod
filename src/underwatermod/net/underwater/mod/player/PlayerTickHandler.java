package net.underwater.mod.player;

import java.util.ArrayList;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;

public class PlayerTickHandler {
	private static PlayerTickHandler inst = new PlayerTickHandler();
	
	public static PlayerTickHandler instance() {
		return PlayerTickHandler.inst;
	}
	
	private ArrayList<IPlayerTick> tickers = new ArrayList<IPlayerTick>();
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) {
		if (event.player == null || event.player.worldObj == null) {
			return;
		}
		for (int i = 0; i < this.tickers.size(); i++) {
			this.tickers.get(i).Tick(event);
		}
	}
	
	public void register(IPlayerTick ticker) {
		if (!tickers.contains(ticker)) {
			tickers.add(ticker);
		}
	}
	
	public void unregister(IPlayerTick ticker) {
		int i = tickers.indexOf(ticker);
		if (i != -1) {
			tickers.remove(i);
		}
	}
	
	public interface IPlayerTick {
		public void Tick(PlayerTickEvent event);
	}
}
