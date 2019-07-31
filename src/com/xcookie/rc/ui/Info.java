package com.xcookie.rc.ui;

public class Info {

    public int collectedRunes;

    public int essPh, essCount;
    public String runTime, currentTask;

/*    public Info() {
        this.essPh = 0;
        this.essCount = 0;
        this.runTime = "";
        this.currentTask = "";
    }*/

    public Info(int essPh, int collectedRunes, String runTime, String currentTask) {
        this.essPh = essPh;
        this.collectedRunes = collectedRunes;
        this.runTime = runTime;
        this.currentTask = currentTask;
    }

}
