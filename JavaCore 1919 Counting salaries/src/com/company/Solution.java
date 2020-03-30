package com.company;

/*

1919 Counting salaries

In the main method, the first parameter is the name of the file.
In this file, each line has the following form:
name value
where [name] is String, [value] is double. [name] and [value] are separated by a space.
For each name, calculate the sum of all its values.
Output all data to the console, having previously sorted in ascending order by name.
Close streams.
Example input file:
Petrov 2
Sidorov 6
Ivanov 1.35
Petrov 3.1
Output Example:
Ivanov 1.35
Petrov 5.1
Sidorov 6.0

Requirements:
1. The program should NOT read data from the console.
2. The program should read the contents of the file (use FileReader).
3. The stream of reading from the file (FileReader) should be closed.
4. The program should display in the console each name and the sum of all its values, all data should be sorted in ascending order by name.


*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;




public class Solution {
    static TreeMap<String, Double> map = new TreeMap<>();
    public static void main(String[] args) throws IOException {
     String filename = args[0];
     BufferedReader file = new BufferedReader(new FileReader(filename));
     while(file.ready()) {
         String s = file.readLine();
         String[] strs = s.split(" ");
         addMap(strs[0], Double.parseDouble(strs[1]));
     }
     file.close();
     for(Map.Entry<String, Double> pair : map.entrySet()) {
         System.out.println(pair.getKey()+" "+pair.getValue());
     }
    }
    private static void addMap(String name, Double value) {
        if(!map.containsKey(name))
            map.put(name, value);
        else
            map.put(name, map.get(name)+value);
    }
}
