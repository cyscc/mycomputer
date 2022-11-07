package com.cyss.mycomputer.mapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.mapper
 * @Author: cyss
 * @CreatTime: 2022-09-15 09:56
 * @Description:
 */
public class TestJava {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = str.length();
        for (int i = 3; i <= str.length(); i= i+2) {
            for (int j = 0; j <= str.length()-i; j++) {
                String subStr = str.substring(j, j+i);
                if (isSatisfied(subStr)){
                    sum++;
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isSatisfied(String subStr){
        boolean res = true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < subStr.length(); i++) {
            if(!map.containsKey(subStr.charAt(i))){
                map.put(subStr.charAt(i), 1);
            }else{
                map.put(subStr.charAt(i), map.get(subStr.charAt(i))+1);
            }
        }
        int count = 0;
        for (Character ch : map.keySet()){
            if (map.get(ch) % 2 == 1){
                count++;
                if (count > 1){
                    res = false;
                    break;
                }
            }
        }
        return res;
    }
}
