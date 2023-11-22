package org.lucky.leetcode.arrays;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello world";
        System.out.println(reverseUsingStringBuilder(str));
        System.out.println(reverseManually2(str));
        System.out.println(reverseManually(str));
    }

   public static String reverseUsingStringBuilder(String str){
       return new StringBuilder(str).reverse().toString();
   }

   public static String reverseManually(String str){
       StringBuilder sbt = new StringBuilder();
       for(int i = str.length()-1; i >= 0; i--){
           sbt.append(str.charAt(i));
       }
       return sbt.toString();
   }

    public static String reverseManually2(String str){
        char[] chars = new char[str.length()];
        int index=0;
        for(int i = str.length()-1; i >= 0; i--){
            chars[index++]=str.charAt(i);
        }
        return new String(chars);
    }
}
