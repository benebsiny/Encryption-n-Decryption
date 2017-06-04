import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Beneb Siny on 2017/5/30.
 */
public class Encryption {
    public void mainEn(){
        Encryption e = new Encryption();

        System.out.print("\n請輸入想要加密的文字:");
        Scanner sca = new Scanner(System.in);
        String input = sca.nextLine();
        int[] stage1 = e.transform(input);
        String[] stage2 = e.encrypt(stage1);

        for(int i=0;i<stage2.length;i++){
            System.out.print(stage2[i]);
        }
    }


    int[] transform(String inp){
        String def = " abcdefghijklmnopqrstuvwxyz";
        int count;
        int[] result = new int[inp.length()];
        for(int i=0 ;i<inp.length();i++){
            count = def.indexOf(inp.charAt(i));
            result[i] = count;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }


    String[] encrypt(int[] inp){
        int[] result = new int[inp.length];
        int x;
        for(int i=0;i<inp.length;i++){
            x=inp[i];
            if(i==0){
                x=x*2+12;
                result[i] = x;
            }
            else{
                if(x*2+result[i-1]>=100){
                    x=result[i-1]-x*2;

                    result[i] = x;
                }
                else if(x*2+result[i-1]<100){
                    x=result[i-1]+x*2;
                    result[i] = x;
                }
            }
        }
        System.out.println(Arrays.toString(result));

        String[] resultstr = new String[result.length];
        for(int i=0;i<result.length;i++){
            resultstr[i] = String.valueOf(result[i]);
            if(resultstr[i].length()<2){
                resultstr[i] = "0"+resultstr[i];
            }
        }
        System.out.println(Arrays.toString(resultstr));

        return resultstr;
    }
}
