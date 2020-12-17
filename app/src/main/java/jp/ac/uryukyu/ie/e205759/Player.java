package jp.ac.uryukyu.ie.e205759;
import java.util.Scanner;

/**
 * Player class is for human participants the game.
 *  String name; //player name
 */
public class Player implements Participant{
    private String name;
    //プレイヤーは数字を宣言することができる。
    //それしかできない。
    Player(String name){
        this.name = name;
    }
    
    /**
     * Show player's name.
     * @return player's name.
     */
    @Override
    public String getName(){
        return name;
    }

    /** Input a number within the range specified by parameters for game.
     * @param min minimum range.
     * @param max maximum range.
     * @return a number within the specified range
     */
    @Override
    public int tell_number(int min, int max){
        System.out.print(String.valueOf(min) + "-" + String.valueOf(max));
        System.out.println("の範囲で、数字を入力してください。");
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        //scan.close();
        if(min<=number && max>=number){
            return number;
        }
        else{
            System.out.println("入力に誤りがあります。");
            return 0;
        }
    }
    
}