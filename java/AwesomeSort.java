import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i = 0; t_i < T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            String[] arr_arr = br.readLine().split(" ");
            int[] arr = new int[N];
            for(int i_arr = 0; i_arr < arr_arr.length; i_arr++)
            {
            	arr[i_arr] = Integer.parseInt(arr_arr[i_arr]);
            }

            int[] out_ = awseomeSort(N, arr);
            System.out.print(out_[0]);
            for(int i_out_ = 1; i_out_ < out_.length; i_out_++)
            {
            	System.out.print(" " + out_[i_out_]);
            }
            
            System.out.println();
            
         }

         wr.close();
         br.close();
    }
    static int[] awseomeSort(int N, int[] arr){
       // Write down your code
        int[] result = new int[N];
        List<Integer> even5 = new ArrayList<>();
        List<Integer> evenNot5 = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for(int i = 0; i<N; i++) {
            if(arr[i] %2 == 0 && arr[i]%5 == 0){
                even5.add(arr[i]);
            } else if(arr[i] %2 == 0 && arr[i]%5 != 0){
                evenNot5.add(arr[i]);
            } else {
                odd.add(arr[i]);
            }
        }
        Collections.sort(even5, Collections.reverseOrder());
        Collections.reverse(evenNot5);
        List<Integer> ans = new ArrayList<>();
        ans.addAll(even5);
        ans.addAll(evenNot5);
        ans.addAll(odd);
        result = ans.stream().mapToInt(i -> i).toArray();
        return result;
    
    }
}