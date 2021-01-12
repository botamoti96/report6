package jp.ac.uryukyu.ie.e205759;
import java.util.Random;

    /**
     * Com class participates the game.
     * Instead of imput a number, generate a random number.
     * String name; //CPU name.
     */
public class Com implements Participant{
    private String name;
    //comは自分の判断で適当な数字を宣言してGMに伝える。

    Com(String name){
        this.name = name;
    }

    /**
     * Show COM's name.
     * @return COM's name.
     */
    @Override
    public String getName(){
        return name;
    }

    /**
     * Generate a random number within the range specified by parameters.
     *  @param min minimum range.
     *  @param max maximum range.
     *  @return a number within the specified range
     */
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
