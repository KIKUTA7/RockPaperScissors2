package com.company;

import java.util.*;


public class RPS {

    public static void main(String[] args) {
        if (!Rules.ArgsChecker(args))
        {
            System.out.println("You should write odd number of arguments and they shouldn't be repetitive");
            return;
        }
        Random random = new Random();
        Table table = new Table(args);
        String firstHMAC = "";
        String secondHMAC = "";
        String move = "";
        while(!move.equals("0")) {
            firstHMAC = HMAC.HMAC();
            System.out.println("HMAC: " + firstHMAC);
            System.out.println("Available moves:");
            for (int i = 0; i < args.length; i++) {
                System.out.println((i + 1) + " - " + args[i]);
            }
            System.out.println("0 - Exit");
            System.out.println("? - Help");
            System.out.print("Enter your move: ");
            Scanner scanner = new Scanner(System.in);
            move = scanner.next();
            while (!Rules.moveChecker(move, args.length))
            {
                System.out.println("Incorrect Move");
                System.out.print("Enter your move: ");
                scanner = new Scanner(System.in);
                move = scanner.next();
            }
            if (!move.equals("0") && !move.equals("?"))
            {
                System.out.println("Your move: " + args[Integer.parseInt(move) - 1]);
                int compMove = random.nextInt(args.length) + 1;
                System.out.println("Computer move: " + args[compMove - 1]);
                switch (table.Table[Integer.parseInt(move)][compMove]) {
                    case "Draw" -> System.out.println("It's a draw");
                    case "Win" -> System.out.println("You win");
                    case "Lose" -> System.out.println("You Lose");
                }
                try {
                    assert firstHMAC != null;
                    secondHMAC = HMACKEY.computeHMAC(firstHMAC, move);
                    System.out.println("HMAC key: " + secondHMAC);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            if (move.equals("?"))
            {
                try {
                    table.printTable();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
            System.out.println();
        }
    }

}
