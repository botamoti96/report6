package jp.ac.uryukyu.ie.e205759;
import java.util.Scanner;

public class Player implements Participant{
    private String name;
    //プレイヤーは数字を宣言することができる。
    //それしかできない。
    Player(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

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