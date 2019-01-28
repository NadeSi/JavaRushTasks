package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {

    private static List<Horse> horses = new ArrayList<>();
    public static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) {
        horses.add(new Horse("horse1", 3, 0));
        horses.add(new Horse("horse2", 3, 0));
        horses.add(new Horse("horse3", 3, 0));
        game = new Hippodrome(horses);
        try {
            game.run();
            game.printWinner();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void move(){
        for (Horse horse : getHorses()) {
            horse.move();
        }
    }

    public void print(){
        for (Horse horse : getHorses()) {
            horse.print();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public void run() throws InterruptedException {
        for (int i = 1; i < 101; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner(){
        Horse win = null;
        double winDistanse = 0;
        for (Horse horse : getHorses()) {
            if(horse.getDistance()>= winDistanse){
                winDistanse = horse.getDistance();
                win = horse;
            }
        }
        return win;
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }
}
