package com.xcookie.rc.assets;

public class Settings {

	public int hpWarning = 10; //I use this value in class isHitpointsAboveValue, example, if hp < 10, teleport out
    public String master = "dexamphetami"; //Used in running ess
    private boolean tradeToTraverse = false; //Use item or trade player to get to the Runecrafting altar
    public String name = "RCBot";
    private boolean lunars = false; //TODO: add a checkbox in gui to toggle this
    public String[] acceptableCurrency = {"Air runes", "Mind runes", "Rune pouch"}; //for exchanging to bank to big man with bank on back
    private int rcOption = 0; // dropdown from gui, is initialised when user pressed start in gui //TODO fix

    @Override
    public String toString() {
        return "Settings{" +
                "hpWarning=" + hpWarning +
                ", master='" + master + '\'' +
                ", tradeToTraverse=" + tradeToTraverse +
                ", name='" + name + '\'' +
                '}';
    }




    public boolean isLunars() {
        return lunars;
    }

    public void setLunars(boolean lunars) {
        this.lunars = lunars;
    }

    public String getName() {
        return name;
    }

    public boolean isTradeToTraverse() {
        return tradeToTraverse;
    }

    public void setTradeToTraverse(boolean tradeToTraverse) {
        this.tradeToTraverse = tradeToTraverse;
    }

    public int getHpValue() {
        return hpWarning;
    }

    public void setHpValue(int hpValue) {
        this.hpWarning = hpWarning;
    }

    public String getMaster() {
        return master;
    }

    public void setMaster(String master) {
        this.master = master;
    }
    
    public int getRcOption() {
		return rcOption;
	}

	public void setRcOption(int rcOption) {
//        log.debug("Selected option: " + new Player().getRunecraftingTask(getRcOption()));
		this.rcOption = rcOption;
	}

}
