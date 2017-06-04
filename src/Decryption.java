import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Beneb Siny on 2017/5/30.
 */
public class Decryption {
    public void mainDe(){
        Decryption d = new Decryption();

        System.out.print("\n請輸入想要解密的文字:");
        Scanner sca = new Scanner(System.in);
        String inp = sca.nextLine();


        if(inp.length()%2==0){
            String[] stage1 = d.analyze(inp);
            char[] stage2 = d.decrypt(stage1);

            /****輸出****/
            for (int i=0;i<stage2.length;i++){
                System.out.print(stage2[i]);
            }
            /****結束****/
        }
        else{
            System.out.print("輸入錯誤");
            System.exit(0);
        }
    }


    /*****************分析*****************/

    String[] analyze(String str){
        String[] strs=null;
        try {
            int m=str.length()/2; //總共幾個項目
            strs=new String[m];
            int j=0;
            for(int i=0;i<str.length();i++){
                if(i%2==0){
                    strs[j]=""+str.charAt(i);
                }else{
                    strs[j]=strs[j]+""+str.charAt(i);
                    j++;
                }
            }
            System.out.println(Arrays.toString(strs));

        }catch (Exception e){
            System.out.print("輸入錯誤");
        }
        return strs;
    }


    /*****************解密*****************/

    char[] decrypt(String[] inp){
        String def = " abcdefghijklmnopqrstuvwxyz";
        char[] result = new char[inp.length];
        int[] val = new int[inp.length];
        try{
            for(int i=0 ;i<inp.length;i++) {
                val[i] = Integer.valueOf(inp[i]); //String to int

                if(i==0){ //第1個數字
                    if(val[i]%2!=0){ //第1個數必須為偶數
                        System.out.print("輸入錯誤");
                        System.exit(0);
                    }
                    result[i] = def.charAt((val[i] - 12) / 2);
                }

                else { //第n個數字

                    if(val[i-1]>val[i]){ //這個數字比前一個小
                        if((val[i-1]-val[i])%2!=0){ //必須整除
                            System.out.print("輸入錯誤");
                            System.exit(0);
                        }
                        result[i] = def.charAt((val[i-1]-val[i])/2);
                    }

                    else if(val[i-1]<val[i]){ //這個數字比前一個大
                        if((val[i]-val[i-1])%2!=0) { //必須整除
                            System.out.print("輸入錯誤");
                            System.exit(0);
                        }
                        result[i] = def.charAt((val[i]-val[i-1])/2);
                    }

                    else if(val[i]==val[i-1]){
                        System.out.print(" ");
                    }
                }
            }
        }catch (Exception e){
            System.out.print("輸入錯誤");
            System.exit(0);
        }
        return result;
    }

}
