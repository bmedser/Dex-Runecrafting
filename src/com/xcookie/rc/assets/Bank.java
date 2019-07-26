package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.location.Coordinate;

public enum Bank {

    APE_ATOLL_SOUTH("Ape Atoll", Type.DEPOSIT, new Coordinate(3047, 3237, 0)),
    ARDOUGNE_EAST("Ardougne East", Type.FULL, new Coordinate(2655, 3283, 0)),
    BARBARIAN_OUTPOST("Barbarian Outpost", Type.FULL, new Coordinate(2535, 3572, 0)),
    BURGH_DE_ROTT("Burgh de Rott", Type.FULL, new Coordinate(3494, 3211, 0)),
    CASTLE_WARS("Castle Wars", Type.FULL, new Coordinate(2443, 3083, 0)),
    CATHERBY("Catherby", Type.FULL, new Coordinate(2809, 3440, 0)),
    CORSAIR_COVE("Corsair Cove", Type.FULL, new Coordinate(2569, 2864, 0)),
    DRAYNOR_VILLAGE("Draynor Village", Type.FULL, new Coordinate(3093, 3243, 0)),
    DUEL_ARENA("Duel Arena", Type.SPECIAL, new Coordinate(3349, 3238, 0)),
    EDGEVILLE("Edgeville", Type.FULL, new Coordinate(3094, 3491, 0)),
    FALADOR_EAST("Falador East", Type.FULL, new Coordinate(3009, 3355, 0)),
    FISHING_GUILD("Fishing Guild", Type.FULL, new Coordinate(2587, 3419, 0)),
    GRAND_EXCHANGE("Grand Exchange", Type.FULL, new Coordinate(3165, 3487, 0)),
    KARAMJA("Stiles", Type.SPECIAL, new Coordinate(3045, 3234, 0)),
    LUMBRIDGE_CASTLE("Lumbridge Castle", Type.FULL, new Coordinate(3208, 3219, 2)),
    PISCARILIUS("Piscarilius (Zeah)", Type.FULL, new Coordinate(1804, 3790, 0)),
    PISCATORIS("Piscatoris", Type.FULL, new Coordinate(2330, 3690, 0)),
    PORT_PHASMATYS("Port Phasmatys", Type.FULL, new Coordinate(3690, 3466, 0)),
    PORT_SARIM("Port Sarim", Type.DEPOSIT, new Coordinate(3045, 3234, 0)),
    PRIFDDINAS_WOODCUTTING("Prifdinna's Woodcutting Area", Type.FULL, new Coordinate(2237, 3385, 1)),
    SEERS_VILLAGE("Seer's Village", Type.FULL, new Coordinate(2725, 3492, 0)),
    SHILO_VILLAGE("Shilo Village", Type.FULL, new Coordinate(2853, 2955, 0)),
    VARROCK_EAST("Varrock East", Type.FULL, new Coordinate(3253, 3420, 0)),
    VARROCK_WEST("Varrock West", Type.FULL, new Coordinate(3210, 3424, 0)), //fix
    WOODCUTTING_GUILD("Woodcutting Guild", Type.FULL, new Coordinate(1592, 3476, 0)),
    KOUREND_ARCEUS("Kourend Arceus District", Type.FULL, new Coordinate(1635, 3740, 0));

    Bank(String name, Type type, Coordinate coordinate) {
        this.name = name;
        this.type = type;
        this.coordinate = coordinate;
    }

    private String name;
    private Type type;
    private Coordinate coordinate;

    enum Type {
        DEPOSIT, FULL, SPECIAL
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", coordinate=" + coordinate +
                '}';
    }
}
