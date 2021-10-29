import java.util.*;
public class StringRecursion {

    public static void printReverse(String str){
        if(str.equals("") || str == null){
            return;
        }else{
            int length = str.length();
            System.out.print(str.charAt(length-1));
            printReverse(str.substring(0,length-1));
        }
    }

    public static String trim(String str){
        if(str.equals("") || str == null){
            return " ";
        }
        String rest = trim(str.substring(1));
        if(" ".indexOf(str.charAt(0))==-1){
            return str.charAt(0) + rest;
        }else{
            return rest;
        }
    }

    public static int find(char ch, String str){
        if (str == null || str.equals("")){
            return -1;
        }
        if(str.charAt(0) == ch){
           return 0;
        }
        int count = find(ch, str.substring(1));
        if(count == -1){
            return -1;
        }
        return 1 + count;
    }

    public static String weave(String str1, String str2){
        if (str1.equals(null) || str2.equals(null)) {
            throw new IllegalArgumentException();
          }
        if(str1 == null || str1.equals("") || str2 == null || str2.equals("")){
            return str1 + str2;
        }
        return str1.substring(0, 1) + str2.substring(0, 1) + weave(str1.substring(1), str2.substring(1));
    }

    public static int indexOf(char ch, String str){
        return find(ch, str);
    }

    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nType in a word and press enter:");
        String word = userInput.nextLine();
        userInput.close();

        printReverse(word);
        System.out.println("");
        System.out.println(trim(word));
        System.out.println(find('b', "rabbit"));
        System.out.println(weave("recurse", "NOW"));
        System.out.println(indexOf('b', "rabbit"));
    }
}
