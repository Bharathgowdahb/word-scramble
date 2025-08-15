package com.example.scramble.service;

import com.example.scramble.dto.ScrambledWordDTO;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.*;

@Service
public class WordService {

    public static class WordItem {
        public final int id;
        public final String word;
        public final String hint;
        WordItem(int id, String word, String hint) {
            this.id = id; this.word = word; this.hint = hint;
        }
    }

    private final List<WordItem> words = new ArrayList<>();
    private final SecureRandom random = new SecureRandom();

    public WordService() {
        add("computer", "A machine you code on");
        add("spring", "Popular Java framework");
        add("react", "A JS library for UIs");
        add("variable", "Holds a value in code");
        add("function", "Reusable block of code");
        add("database", "Stores structured data");
        add("internet", "Global network");
        add("android", "Mobile OS by Google");
        add("python", "A popular programming language");
        add("javascript", "Language of the web");
        add("compiler", "Turns code into machine code");
        add("algorithm", "Step-by-step procedure");
        add("framework", "Provides structure to apps");
        add("backend", "Server-side of an app");
        add("frontend", "Client-side of an app");
    }

    private void add(String w, String h) {
        words.add(new WordItem(words.size() + 1, w, h));
    }

    public ScrambledWordDTO randomScramble() {
        WordItem item = words.get(random.nextInt(words.size()));
        String scrambled = scramble(item.word);
        int safety = 0;
        while (scrambled.equalsIgnoreCase(item.word) && safety++ < 10) {
            scrambled = scramble(item.word);
        }
        return new ScrambledWordDTO(item.id, scrambled, item.hint, item.word.length());
    }

    public boolean isCorrect(int id, String guess) {
        return words.stream()
                .filter(w -> w.id == id)
                .findFirst()
                .map(w -> w.word.equalsIgnoreCase(guess.trim()))
                .orElse(false);
    }

    public String getWordById(int id) {
        return words.stream().filter(w -> w.id == id).findFirst().map(w -> w.word).orElse(null);
    }

    private String scramble(String word) {
        List<Character> chars = new ArrayList<>();
        for (char c : word.toCharArray()) chars.add(c);
        Collections.shuffle(chars, random);
        StringBuilder sb = new StringBuilder();
        chars.forEach(sb::append);
        return sb.toString();
    }
}
