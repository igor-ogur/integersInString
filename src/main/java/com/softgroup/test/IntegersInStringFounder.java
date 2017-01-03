package com.softgroup.test;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class IntegersInStringFounder {
    private static int i = 0;
    public static void main( String[] args ) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string");
        String s = reader.readLine();

        List<Integer> listOfIntegers = new ArrayList<Integer>();

        char[] chars = s.toCharArray();

        StringBuilder number = new StringBuilder();
        while (i < chars.length){
            if (Character.isDigit(chars[i])) {
                number.append(chars[i]);
                i++;
                while (i < chars.length){
                    if (Character.isDigit(chars[i])) {
                        number.append(chars[i]);
                        i++;
                    }
                    else {
                        int a = Integer.parseInt(number.toString());
                        if ((chars[i] == '*' || chars[i] == '/' || chars[i] == '-' || chars[i] == '+') && Character.isDigit(chars[i+1])) {
                            i++;
                            a = doMath(chars[i-1], chars, a);
                        }
                        listOfIntegers.add(a);
                        number.delete(0, number.length());
                        break;
                    }
                }
            }
            i++;
        }
        try {
            listOfIntegers.add(Integer.parseInt(number.toString()));
        }catch (NumberFormatException e){

        }
        if (listOfIntegers.isEmpty()) System.out.println("Entered string has no integers");
        else {
            for (Integer integer : listOfIntegers) {
                System.out.println(integer);
            }
            System.out.println("Max: "+getMax(listOfIntegers));
            System.out.println("Min: "+getMin(listOfIntegers));
        }
    }

    public static int doMath (char c, char[] chars, int a){
        StringBuilder secondNumber = new StringBuilder();
        int b=0;
        while (i < chars.length) {
            if (Character.isDigit(chars[i])) {
                secondNumber.append(chars[i]);
                i++;
            } else {
                b = Integer.parseInt(secondNumber.toString());
                break;
            }

        }
        try {
            b = Integer.parseInt(secondNumber.toString());
        }catch (NumberFormatException e){

        }
        if (c == '*') return a*b;
        if (c == '/') return a/b;
        if (c == '+') return a+b;
        return a-b;
    }

    public static int getMin (List<Integer> list){
        int min = list.get(0);
        for (int j = 1; j < list.size(); j++) {
            if (min>list.get(j)) min = list.get(j);
        }
        return min;
    }

    public static int getMax (List<Integer> list){
        int max = list.get(0);
        for (int j = 1; j < list.size(); j++) {
            if (max<list.get(j)) max = list.get(j);
        }
        return max;
    }
}
