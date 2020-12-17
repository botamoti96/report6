package jp.ac.uryukyu.ie.e205759;

abstract class Participant {
    private String name;
    
    Participant(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
