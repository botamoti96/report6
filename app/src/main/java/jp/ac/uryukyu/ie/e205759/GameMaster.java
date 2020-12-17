package jp.ac.uryukyu.ie.e205759;
import java.util.ArrayList;
import java.util.Random;

/**
 * GameMaster class. Controle the game.
 * 
 */
public class GameMaster {
    private ArrayList<Participant> participants;
    private int specified_number;
    private int min = 1;
    private int max = 100;
    //ゲームのルール
    //1. 1-100の数字をGMが秘密裏に決めてゲームスタート。
    //2. プレイヤーは1-100の範囲で数字を宣言する。
    //3. GMはその数を最小値または最大値とし、指定数を含むように範囲を狭める。
    //   例_GM指定数が50、宣言数が30なら次の宣言は30-100の範囲とする。
    //4. 指定数と宣言数が被ったらその人の負け。

    /**
     * Constracter.
     */
    public GameMaster(){
        participants = new ArrayList<>();
        Random rd = new Random();
        specified_number = rd.nextInt(100)+1;
        Player pl = new Player("プレイヤー");
        Com com = new Com("COM");
        participants.add(pl);
        participants.add(com);
    }

    /**
     * If need to change the range, use this.
     * @param min minimum range.
     * @param max maximum range.
     */
    public void setRange(int min, int max){
        if (min<max && min>0){
            this.min = min;
            this.max = max;
        }
        else{
            System.out.println("不正な入力です。");
        }
    }

    /**
     * Set up the game. Use before the beginning.
     */
    public void gameSetup(){
        
    }

    /**
     * Start the game. Loop continues while game is active.
     * All players declare a number in order.
     * If the number equals to GM's specified number, the player loses.
     * Last one player is winner.
     */
    public void game(){
        Boolean isGame = true;
        while(isGame){
            for(Participant p:participants){
                System.out.println(p.getName() + "の番です。");
                int declare_number = p.tell_number(min, max);
                while(declare_number==0){
                    declare_number = p.tell_number(min,max);
                }
                if(declare_number == specified_number){
                    System.out.println("指定数は、" + String.valueOf(specified_number) + "でした。");
                    System.out.println(p.getName() + "の負けです。");
                    if (p.getName() == "プレイヤー"){
                        System.out.println("残念！また挑戦してね。");
                    }
                    else{
                        System.out.println("あなたの勝ち！おめでとう！");
                    }
                    isGame = false;
                    break;
                }
                if(declare_number>specified_number){
                    max = declare_number-1;
                }
                else{
                    min = declare_number+1;
                }
            }
        }
    }
}