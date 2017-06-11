package com.leetcode.heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by guangoon on 17-6-11.
 */
public class SortCharactersByFrequency {
    class CharacterFrequency{
        private Character c;
        private Integer frequency;
        public CharacterFrequency(Character c, Integer f){
            this.c = c;
            this.frequency = f;
        }

        public Integer getFrequency(){
            return frequency;
        }

        public Character getCharacter(){
            return c;
        }
    }


    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<CharacterFrequency> pq = new PriorityQueue<>(new Comparator<CharacterFrequency>() {
            @Override
            public int compare(CharacterFrequency characterFrequency, CharacterFrequency t1) {
                return t1.getFrequency().compareTo(characterFrequency.getFrequency());
            }
        });

        for(Character character : map.keySet()){
            pq.add(new CharacterFrequency(character, map.get(character)));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            CharacterFrequency cf = pq.poll();
            int f = cf.getFrequency();
            while(f > 0){
                sb.append(cf.getCharacter());
                f--;
            }
        }
        return sb.toString();
    }
}
