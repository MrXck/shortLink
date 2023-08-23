package com.shortlink.urils;

import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MurmurHashUtil {

    private static final String[] STRINGS = new String[]{
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
            "Y", "Z"
    };

    public static String getHexHashString(String url){
        HashFunction hashFunction = Hashing.murmur3_128();
        HashCode hashCode = hashFunction.hashString(url, StandardCharsets.UTF_8);
        int hash = hashCode.asInt();
        StringBuilder sb = new StringBuilder();
        while (hash / 62 >= 62){
            int divide = hash % 62;
            sb.append(STRINGS[divide]);
            hash /= 62;
        }

        return sb.toString();
    }
}
