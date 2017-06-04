import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Beneb Siny on 2017/5/30.
 */
public class EasyEncryptionAndDecryption {

    public static void main(String[] args){
        Encryption e = new Encryption();
        Decryption d = new Decryption();

        try{
            Scanner sca = new Scanner(System.in);
            System.out.print("輸入1:加密,輸入2:解密:");
            int mes = sca.nextInt();

            if(mes==1){
                e.mainEn();
            }
            else if(mes==2){
                d.mainDe();
            }
            else{
                System.out.print("少白癡了");
            }
        }catch (InputMismatchException ex){
            System.out.print("輸入1或2有那麼困難嗎?");
        }

    }
}
