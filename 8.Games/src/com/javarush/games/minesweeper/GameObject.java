package com.javarush.games.minesweeper;

public class GameObject {
    public int x;
    public int y;
    public boolean isMine;
    public boolean isFlag;
    public boolean isOpen;
    
    public int countMineNeighbors;

    public GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }

    public int getCountMineNeighbors() {
        return countMineNeighbors;
    }

    public void setCountMineNeighbors(int countMineNeighbors) {
        this.countMineNeighbors = countMineNeighbors;
    }

    public boolean isMine() {
        return isMine;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public boolean isFlag() {
        return isFlag;
    }

    public void setFlag(boolean flag) {
        isFlag = flag;
    }

}
