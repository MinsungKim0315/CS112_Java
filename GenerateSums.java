public class GenerateSums {
    public static String generateSums(int n) {
        int sum = 0;
        String first="";
        String allSum="";
        for (int i = 1; i <= n; i++) {
            if(i == 1){
                sum++;
                allSum += i + "\n";
                first = "1";
            }else{
                sum += i;
                allSum += first + "+" +  i;
                first = first + "+" + i; 
            
                if(i != 1){
                    allSum += "=" + sum + "\n";
                }  
            }
        }
        return allSum;
    }

    public static void main(String[] args) {
        System.out.println(generateSums(10));
    }
}
