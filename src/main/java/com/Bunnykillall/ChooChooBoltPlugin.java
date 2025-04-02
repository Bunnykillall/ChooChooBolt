package com.Bunnykillall;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.*;
import net.runelite.api.Client;
import net.runelite.api.events.GameStateChanged;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.api.events.SoundEffectPlayed;
import net.runelite.client.eventbus.Subscribe;

@Slf4j
@PluginDescriptor(
	name = "Choo Choo Bolt"
)
public class ChooChooBoltPlugin extends Plugin {
	@Inject
	private Client client;

	@Inject
	private ChooChooBoltConfig config;

	@Inject
	private com.Bunnykillall.SoundclipManager soundclipManager;


	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Example says " + config.greeting(), null);
		}
	}

	@Provides
	ChooChooBoltConfig provideConfig(ConfigManager configManager) {
		return configManager.getConfig(ChooChooBoltConfig.class);
	}

	@Subscribe
	public void onSoundEffectPlayed(SoundEffectPlayed event) {
		if (!config.replaceRubySpecSound())
			return;

		if (event.getSoundId() == 2911) {
			event.consume();

			soundclipManager.playClip(soundclipManager.getRubySpecSound());

		}
	}
}