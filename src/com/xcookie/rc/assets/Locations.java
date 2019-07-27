package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.location.*;

import java.util.List;

public class Locations {

//    public static List<Coordinate> = new Coordinate

    public static Area ZMIBank = new Area.Rectangular(new Coordinate(3012, 5626, 0), new Coordinate(3014, 5624, 0));
    public static Coordinate ZMIWorldLadder = new Coordinate(2452 +1 , 3231, 0); // + 1 so i can walk there
    public static Coordinate ladderCoord = new Coordinate(2452 +1 , 3231, 0); // + 1 so i can walk there

    public static Area ZMIRCAltar = new Area.Rectangular(new Coordinate(3057,5581,0), new Coordinate(3058,5577, 0));
    public static Coordinate ZMIRCAltarSpot = new Coordinate(3057,5579,0);
    public static Area ZMIOutside = new Area.Rectangular(new Coordinate(2452, 3231, 0), new Coordinate(2456,3230, 0)); //contains the ladder and chaos altar, (6 x 3) box
//    public static Area ZMITeleportArea = new Area.Rectangular(new Coordinate(2453, 3248, 0), new Coordinate(2474,3238, 0)); //contains the teleport area, large rectangle
    public static Area ZMITeleportArea = new Area.Rectangular(new Coordinate(2452, 3251, 0), new Coordinate(2470,3239, 0)); //contains the teleport area, large rectangle
//    public static Area ArdoungeBank = new Area.Rectangular(new Coordinate(), new Coordinate()); //for getting runes when u run out at zmi bank
    public static Area CWBank = new Area.Rectangular(new Coordinate(2438,3091,0), new Coordinate(2443,3082,0)); //for getting runes when u run out at zmi bank
    public static Area ZMIRoom = new Area.Rectangular(new Coordinate(3009, 5630, 0), new Coordinate(3063,5575, 0)); //for getting runes when u run out at zmi bank

}
