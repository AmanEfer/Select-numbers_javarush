package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {


    public static void main(String[] args) throws IOException {

        String inputFileName;
        String outputFileName;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFileName = bufferedReader.readLine();
            outputFileName = bufferedReader.readLine();
        }

        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            while (reader.ready())
                builder.append(reader.readLine() + " ");
        }

        String[] strings = builder.toString().split(" ");
        ArrayList<String> outputList = new ArrayList<>();

        for (String string : strings) {
            boolean isContain = true;
            char[] chars = string.toCharArray();

            for (char current : chars) {
                if (!Character.isDigit(current)) {
                    isContain = false;
                    break;
                }
            }
            if (isContain)
                outputList.add(string);
        }

        String result = String.join(" ", outputList);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(result);
        }
    }
}
