package com.company;

import ConsoleTable4java.ConsoleTable.DuplicateHeaderException;
import ConsoleTable4java.ConsoleTable.ElementSizeException;
import ConsoleTable4java.ConsoleTable.MultipleHeaderException;
import ConsoleTable4java.ConsoleTable.ct4j;

public class Table {
    public String[] [] Table;
    public Table (String[] moves){
        Table = new String [moves.length + 1] [moves.length + 1];
        Table[0][0] = "v PC\\User >";
        for (int i = 1; i <= moves.length; i++)
        {
            Table[i][0] = moves[i - 1];
            Table[0][i] = moves[i - 1];
        }
        Table[1][1] = "Draw";
        for (int i = 2; i < moves.length + 1; i++)
        {
            if (i <= (moves.length + 1) / 2) {
                Table[i][1] = "Lose";
                Table[1][i] = "Win";
            }
            else {
                Table[i][1] = "Win";
                Table[1][i] = "Lose";
            }
        }
        for (int i = 2; i <= moves.length; i++)
        {
            for (int j = 2; j <= moves.length; j++)
            {
                Table[i][j] = Table[i - 1][j - 1];
            }
        }

    }

    public void printTable() throws MultipleHeaderException, DuplicateHeaderException, ElementSizeException {

        ct4j table = new ct4j();

        table.setHeader(Table[0]);

        for (int i = 1; i < Table.length; i++)
        {
            table.addRow(Table[i]);
        }

        table.setHorizontalSeparator('-');
        table.setVerticalSeparator('|');
        table.setCornerJoint('+');
        table.setUppercaseHeaders(true);

        table.printTable();
//        int longestString = 0;
//        for (String[] row : Table) {
//            for (String cell : row) {
//                if (cell.length() > longestString) {
//                    longestString = cell.length();
//                }
//            }
//        }
//
//        int[] columnWidths = new int[Table[0].length];
//        for (int i = 0; i < Table[0].length; i++) {
//            columnWidths[i] = longestString + 4;
//        }
//
//        System.out.print("+");
//        for (int i = 0; i < columnWidths.length; i++) {
//            if (i == columnWidths.length - 1) System.out.print("-".repeat(columnWidths[i] + 2));
//            else System.out.print("-".repeat(columnWidths[i] + 3));
//        }
//        System.out.println("+");
//
//        for (String[] row : Table) {
//            System.out.printf("| %-" + columnWidths[0] + "s |", row[0]);
//            for (int i = 1; i < row.length; i++) {
//                System.out.printf(" %-" + columnWidths[i] + "s |", row[i]);
//            }
//            System.out.println();
//            System.out.print("+");
//            for (int i = 0; i < columnWidths.length; i++) {
//                if (i == columnWidths.length - 1) System.out.print("-".repeat(columnWidths[i] + 2));
//                else System.out.print("-".repeat(columnWidths[i] + 3));
//            }
//            System.out.println("+");


    }
}
