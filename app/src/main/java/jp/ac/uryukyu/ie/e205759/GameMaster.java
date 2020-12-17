package jp.ac.uryukyu.ie.e205759;
import java.util.ArrayList;

public class GameMaster {
    ArrayList<Participant> participants;
    //ゲームのルール
    //1. 1-100の数字をGMが秘密裏に決めてゲームスタート。
    //2. プレイヤーは1-100の範囲で数字を宣言する。
    //3. GMはその数を最小値または最大値とし、指定数を含むように範囲を狭める。
    //   例_GM指定数が50、宣言数が30なら次の宣言は30-100の範囲とする。
    //4. 指定数と宣言数が被ったらその人の負け。
    public GameMaster(){
        participants = new ArrayList<>();
        Player pl = new Player("プレイヤー");
        Com com = new Com("COM");
        participants.add(pl);
        participants.add(com);
    }
}
