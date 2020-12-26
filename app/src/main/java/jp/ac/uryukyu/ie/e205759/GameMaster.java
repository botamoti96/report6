package jp.ac.uryukyu.ie.e205759;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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
    }

    /**
     * If need to change the range, use this.
     * @param min minimum range.
     * @param max maximum range.
     */
    public void setRange(){
        System.out.println("デフォルトは1-100です。");
        Scanner scan = new Scanner(System.in);
        System.out.println("範囲の最小値を入力してください。");
        int t_min = scan.nextInt();
        System.out.println("範囲の最大値を入力してください。");
        int t_max = scan.nextInt();
        if (t_min<t_max && t_min>0){
            this.min = t_min;
            this.max = t_max;
        }
        else{
            System.out.println("不正な入力です。");
            System.out.println("設定の変更に失敗しました。");
        }
    }


    /**
    * Set up the game. Use before the beggining.
    */
    public void gameSetup(){
        Scanner scan = new Scanner(System.in);
        System.out.println("ゲームに参加する人数を選択してください。");
        System.out.println("おっと！今は二人でしか遊べません。");
        int number = 2;
        System.out.println("プレイヤー人数を入力してください。");
        int playernumber = scan.nextInt();
        boolean isSetupSuccess = true;
        if (number < playernumber){
            System.out.println("プレイヤー人数が参加者数を超えています。");
            isSetupSuccess = false;
        }
        if (playernumber < 1){
            System.out.println("プレイヤーがいません。");
            isSetupSuccess = false;
        }
        if (number > 2){
            System.out.println("参加者が多すぎます。");
            isSetupSuccess = false;
        }
        if (number < 2){
            System.out.println("参加者が少なすぎます。");
            isSetupSuccess = false;
        }
        if (isSetupSuccess){
            if (number == 2){
                if (playernumber == 1){
                    Player pl = new Player("プレイヤー");
                    participants.add(pl);
                    Com COM = new Com("COM");
                    participants.add(COM);
                }
                if (playernumber == 2){
                    Player pl1 = new Player("プレイヤー1");
                    participants.add(pl1);
                    Player pl2 = new Player("プレイヤー2");
                    participants.add(pl2);
                }
            }
        }
        else{
            System.out.println("セットアップに失敗しました。");
            System.out.println("デフォルト設定で開始します。");
            Player pl = new Player("プレイヤー");
            participants.add(pl);
            Com com = new Com("COM");
            participants.add(com);
        }
        //scan.close();

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
                    if (p.getName() == "COM"){
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