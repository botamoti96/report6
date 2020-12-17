package jp.ac.uryukyu.ie.e205759;
import java.util.Random;

public class Com implements Participant{
    private String name;
    //comは自分の判断で適当な数字を宣言してGMに伝える。
    Com(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int tell_number(int min, int max){
        System.out.print(String.valueOf(min) + "-" + String.valueOf(max));
        System.out.println("の範囲で、数字を入力してください。");
        Random rd = new Random();
        int number = rd.nextInt(max-min+1) + min;
        System.out.println(name + "は、" + String.valueOf(number) + "を宣言しました。");
        return number;
    }
}
