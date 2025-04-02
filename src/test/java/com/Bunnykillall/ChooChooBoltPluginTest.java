package com.Bunnykillall;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class ChooChooBoltPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(ChooChooBoltPlugin.class);
		RuneLite.main(args);
	}
}