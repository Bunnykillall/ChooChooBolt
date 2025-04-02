package com.Bunnykillall;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

@Singleton
@Slf4j
public class SoundclipManager {



    public enum Sound {
        RUBYSPEC("/ChooChoo.wav"),
        RUBYSPEC2("/Helicopter.wav");
        private final String fileName;

        Sound(String filename) {
            fileName = filename;
        }

        String getFileName() {
            return fileName;
        }
    }

    @Inject
    private ChooChooBoltConfig config;

    public Sound getRubySpecSound() {
        if (ThreadLocalRandom.current().nextInt(2) == 0)
            return Sound.RUBYSPEC;
        else
            return Sound.RUBYSPEC2;
    }
    public void playClip(Sound rubySpecSound) {
        try {
            // Load the sound file from resources
            InputStream soundStream = getClass().getResourceAsStream(rubySpecSound.getFileName());

            if (soundStream == null) {
                log.error("Sound file not found: " + rubySpecSound.getFileName());
                return;
            }

            // Convert InputStream to AudioInputStream
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundStream);

            // Get a clip instance
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Play the clip
            clip.start();

            // Wait for the sound to finish before continuing (optional, depends on your use case)
//            Thread.sleep(clip.getMicrosecondLength() / 1000); // Sleep in milliseconds

        } catch (Exception e) {
            log.error("Error while playing sound", e);
        }
    }
}





