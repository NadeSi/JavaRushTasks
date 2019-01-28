package com.javarush.games.minesweeper;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class MinesweeperGame extends Game {
    private static final int SIDE = 10;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";

    private static final Color FIELD_COLOR = Color.AQUA;
    private static final Color OPEN_FIELD_COLOR = Color.BEIGE;
    private static final Color MINE_FIELD_COLOR = Color.RED;
    private static final Color FLAG_FIELD_COLOR = Color.YELLOWGREEN;

    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int xCapacity = gameField[gameField.length - 1].length;
    private int yCapacity = gameField.length;
    private int countMinesOnField;
    private int countFlags;
    private int countClosedTiles = SIDE * SIDE;
    private int score;
    private boolean isGameStopped;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        restart();
//        showMessageDialog(Color.WHITE, "Приветствую", Color.BLACK, 50);
    }

    @Override
    public void onMouseLeftClick(int x, int y) {
//        restart();
        System.out.println("LeftClick");
        openTile(x, y);

    }

    @Override
    public void onMouseRightClick(int x, int y) {
        System.out.println("RightClick");
        markTile(x, y);
    }

    @Override
    public void onKeyReleased(Key key) {
        // При отпускании пробела, центральной клетке возвращается белый цвет
        if (key == Key.SPACE) {
            restart();
        }
    }

    private void createGame(){
        for (int y = 0; y < yCapacity; y++) {
            for (int x = 0; x < xCapacity; x++) {
                boolean isMine = getRandomNumber(8) == 0;
                if(isMine){ countMinesOnField++;}
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, FIELD_COLOR);
                setCellValue(x, y, "");
            }
        }
        countMineNeighbors();
        countFlags = countMinesOnField;
    }

    private void restart(){
        isGameStopped = false;
        countClosedTiles = SIDE * SIDE;
        countMinesOnField = 0;
        countFlags = 0;
        setScore(score = 0);
        createGame();
    }

    private void gameOver(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "       LOSER\n  Для рестарта нажмите пробел", Color.BLACK, 25);
    }

    private void win(){
        isGameStopped = true;
        showMessageDialog(Color.WHITE, "  и Вы выиграли АВТОМОБИЛЬ!\n  Для рестарта нажмите пробел", Color.BLACK, 25);
    }

    private List<GameObject> getNeighbors(GameObject field){
        List<GameObject> neighborsList = new ArrayList<>();
        int minCoordX = field.x !=0 ? field.x - 1 : 0;
        int maxCoordX = field.x != xCapacity - 1 ? field.x + 1 : xCapacity - 1;
        int minCoordY = field.y !=0 ? field.y - 1 : 0;
        int maxCoordY = field.y != yCapacity - 1 ? field.y + 1 : yCapacity - 1;

        for (int i = minCoordY; i <= maxCoordY; i++) {
            for (int j = minCoordX; j <= maxCoordX; j++) {
                if(!(i == field.y && j == field.x)) {
                    neighborsList.add(gameField[i][j]);
                }
            }
        }

        return neighborsList;
    }

    private void countMineNeighbors(){
        for (int y = 0; y < yCapacity; y++) {
            for (int x = 0; x < xCapacity; x++) {
                if(!gameField[y][x].isMine()) {
                    int countMinesNeighbors = 0;
                    for (GameObject neighbor: getNeighbors(gameField[y][x])) {
                        if(neighbor.isMine()){
                            countMinesNeighbors++;
                        }
                    }
                    gameField[y][x].setCountMineNeighbors(countMinesNeighbors);
                }
            }
        }
    }

    private void openTile(int x, int y){
        GameObject field = gameField[y][x];
        if(isGameStopped || field.isOpen() || field.isFlag()){return;}
        field.setOpen(true);
        countClosedTiles--;
        if(field.isMine()) {
            setCellValueEx(x, y, MINE_FIELD_COLOR, MINE);
            gameOver();
        }else{
            int countMineNeighbors = field.getCountMineNeighbors();
            if(countMineNeighbors != 0)
                setCellNumber(x, y, countMineNeighbors);
            else{
                setCellValue(x, y, "");
                for (GameObject neighbor: getNeighbors(field)) {
                    openTile(neighbor.x, neighbor.y);
                }
            }

            setCellColor(x, y, OPEN_FIELD_COLOR);
            setScore(score +=5);
            if(countMinesOnField == countClosedTiles){
                win();
            }
        }
    }

    private void markTile(int x, int y){
        GameObject field = gameField[y][x];
        if(isGameStopped || field.isOpen())
            return;
        if(field.isFlag()){
            field.setFlag(false);
            setCellColor(x, y, FIELD_COLOR);
            setCellValue(x, y, "");
            countFlags++;
        }else {
            System.out.println("countFlags: " + countFlags);
            if(countFlags == 0){return;}
            field.setFlag(true);
            setCellColor(x, y, FLAG_FIELD_COLOR);
            setCellValue(x, y, FLAG);
            countFlags--;
        }
    }
}
