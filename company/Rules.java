package com.company;

import java.util.HashSet;
import java.util.Set;

public class Rules {

    public static boolean ArgsChecker (String[] args)
    {
        if (args.length < 3 || args.length % 2 == 0) return false;
        Set<String> set = new HashSet<>();
        for (String arg : args) {
            if (!set.add(arg)) return false;
        }
        return true;
    }

    public static boolean moveChecker (String move, int size)
    {
        if (!move.equals("0") && !move.equals("?"))
        {
            return Integer.parseInt(move) >= 1 && Integer.parseInt(move) <= size;
        }
        return true;
    }
}
