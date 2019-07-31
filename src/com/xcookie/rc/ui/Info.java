package com.xcookie.rc.ui;

public class Info {

    public int[] collectedRunes;

    public int essPh, essCount;
    public String runTime, currentTask;

/*    public Info() {
        this.essPh = 0;
        this.essCount = 0;
        this.runTime = "";
        this.currentTask = "";
    }*/

    public Info(int flaxPh, int[] collectedRunes, String runTime, String currentTask) {
        this.essPh = flaxPh;
        this.collectedRunes = collectedRunes;
        this.runTime = runTime;
        this.currentTask = currentTask;
    }

}
