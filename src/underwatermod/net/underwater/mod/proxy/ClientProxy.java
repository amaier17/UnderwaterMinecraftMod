package net.underwater.mod.proxy;

import net.underwater.mod.init.UnderwaterModBlocks;
import net.underwater.mod.init.UnderwaterModItems;

public class ClientProxy extends CommonProxy{

	@Override
	public void registerRenders() {
		UnderwaterModItems.registerRenders();
		UnderwaterModBlocks.registerRenders();
	}
}
