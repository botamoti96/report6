package jp.ac.uryukyu.ie.e205759;
import java.util.Random;

public class Com extends Participant{
    //comは自分の判断で適当な数字を宣言してGMに伝える。
    Com(String name){
        super(name);
    }

    public int tell_number(int min, int max){
        Random rd = new Random();
        int number = rd.nextInt(max-min+1) + min;
        return number;
    }
}
