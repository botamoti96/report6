package jp.ac.uryukyu.ie.e205759;

/**
 * For join the game, need to implements this interface.
 * GameMaster recognize this interface.
 */
interface Participant {
    String getName();
    int tell_number(int min, int max);
}
