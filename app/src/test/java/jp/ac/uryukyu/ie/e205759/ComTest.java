package jp.ac.uryukyu.ie.e205759;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComTest {
    /**
     * Comは指定された範囲の中からランダムな数字を一つ返すtell_numberメソッドを持つ。
     * 条件を変えつつ5回試して、全て指定の範囲内であれば成功
     */
    @Test
    void TellNumberTest(){
        Com com = new Com("com");
        for(int i=1;i<=80;i+=20){
            int number = com.tell_number(i, i+20);
            System.out.println(number);
            assertTrue(i<=number && number<=i+20);
        }
    }
}
