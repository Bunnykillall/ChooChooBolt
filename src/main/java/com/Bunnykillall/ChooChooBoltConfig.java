package com.Bunnykillall;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;

@ConfigGroup("Choo Choo Bolt")
public interface ChooChooBoltConfig extends Config
{
	@ConfigSection(
			name = "Situations",
			description = "In which situation would you like to play a soundclip?",
			position = 1
	)
	String situationSettings = "situations";

	@ConfigItem(
			keyName = "REEEplacement",
			name = "Replace Ruby Bolts spec sound",
			description = "Replace the sound of Ruby Bolts special effect",
			section = situationSettings
	)
	default boolean replaceRubySpecSound() {return true;}

	String greeting();
}
