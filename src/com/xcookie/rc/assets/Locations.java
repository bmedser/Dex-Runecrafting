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
//    public static Area ZMIOutside = new Area.Rectangular(new Coordinate(2452, 3231, 0), new Coordinate(2456,3230, 0)); //contains the ladder and chaos altar, (6 x 3) box
//    public static Area ZMITeleportArea = new Area.Rectangular(new Coordinate(2453, 3248, 0), new Coordinate(2474,3238, 0)); //contains the teleport area, large rectangle
//    public static Area ZMITeleportArea = new Area.Rectangular(new Coordinate(2452, 3251, 0), new Coordinate(2470,3239, 0)); //contains the teleport area, large rectangle
//    public static Area ArdoungeBank = new Area.Rectangular(new Coordinate(), new Coordinate()); //for getting runes when u run out at zmi bank
    public static Area CWBank = new Area.Rectangular(new Coordinate(2438,3091,0), new Coordinate(2443,3082,0)); //for getting runes when u run out at zmi bank
    public static Area ZMIRoom = new Area.Rectangular(new Coordinate(3009, 5630, 0), new Coordinate(3063,5575, 0)); //for getting runes when u run out at zmi bank

    public static Area ZMIOutside = new Area.Polygonal(
/*            new Coordinate(2453, 3238, 0),
            new Coordinate(2456, 3238, 0),
            new Coordinate(2456, 3230, 0),
            new Coordinate(2455, 3229, 0),
            new Coordinate(2454, 3229, 0),
            new Coordinate(2452, 3231, 0),
            new Coordinate(2452, 3232, 0),
            new Coordinate(2453, 3233, 0),
            new Coordinate(2453, 3237, 0)*/
            new Coordinate(2453, 3234, 0),
            new Coordinate(2456, 3234, 0),
            new Coordinate(2456, 3232, 0),
            new Coordinate(2452, 3232, 0),
            new Coordinate(2453, 3233, 0)
    );

/*    Area[] area = { //zmioutside larger
            new Area.Rectangular(new Coordinate(2451, 3232, 0), new Coordinate(2456, 3228, 0)),
            new Area.Rectangular(new Coordinate(2456, 3233, 0), new Coordinate(2453, 3240, 0))
    };*/

//    Area area = new Area.Rectangular(new Coordinate(2453, 3238, 0), new Coordinate(2456, 3232, 0)); //zmi outside infront of ladder


    public static Area ZMITeleportArea = new Area.Polygonal( //new poly using https://explv.github.io/
            new Coordinate(2452, 3229, 0),
            new Coordinate(2457, 3229, 0),
            new Coordinate(2457, 3247, 0),
            new Coordinate(2464, 3247, 0),
            new Coordinate(2471, 3238, 0),
            new Coordinate(2477, 3238, 0),
            new Coordinate(2477, 3247, 0),
            new Coordinate(2468, 3252, 0),
            new Coordinate(2465, 3251, 0),
            new Coordinate(2462, 3251, 0),
            new Coordinate(2458, 3251, 0),
            new Coordinate(2455, 3251, 0),
            new Coordinate(2453, 3248, 0),
            new Coordinate(2453, 3234, 0),
            new Coordinate(2452, 3232, 0)
    );

    public static Coordinate[] safeWalk = {
            new Coordinate(3021, 5621, 0), //bank
            new Coordinate(3025, 5613, 0),
            new Coordinate(3021, 5603, 0),
            new Coordinate(3029, 5600, 0),
            new Coordinate(3035, 5604, 0),
            new Coordinate(3042, 5601, 0),
            new Coordinate(3052, 5605, 0),
            new Coordinate(3064, 5601, 0),
            new Coordinate(3062, 5596, 0),
            new Coordinate(3035, 5596, 0),
            new Coordinate(3032, 5597, 0),
            new Coordinate(3022, 5588, 0),
            new Coordinate(3026, 5584, 0),
            new Coordinate(3038, 5590, 0),
            new Coordinate(3053, 5587, 0) //outside enter hole
    };

    Coordinate[] teleportAreaToLadder = {
            new Coordinate(2467, 3247, 0),
            new Coordinate(2467, 3247, 0),
            new Coordinate(2466, 3248, 0),
            new Coordinate(2465, 3248, 0),
            new Coordinate(2464, 3249, 0),
            new Coordinate(2463, 3249, 0),
            new Coordinate(2462, 3249, 0),
            new Coordinate(2461, 3249, 0),
            new Coordinate(2460, 3249, 0),
            new Coordinate(2459, 3249, 0),
            new Coordinate(2458, 3249, 0),
            new Coordinate(2457, 3249, 0),
            new Coordinate(2456, 3249, 0),
            new Coordinate(2455, 3249, 0),
            new Coordinate(2455, 3248, 0),
            new Coordinate(2455, 3247, 0),
            new Coordinate(2455, 3246, 0),
            new Coordinate(2454, 3245, 0),
            new Coordinate(2454, 3244, 0),
            new Coordinate(2454, 3243, 0),
            new Coordinate(2454, 3242, 0),
            new Coordinate(2454, 3241, 0),
            new Coordinate(2454, 3240, 0),
            new Coordinate(2454, 3239, 0),
            new Coordinate(2454, 3238, 0),
            new Coordinate(2454, 3237, 0),
            new Coordinate(2454, 3236, 0),
            new Coordinate(2454, 3235, 0),
            new Coordinate(2454, 3234, 0),
            new Coordinate(2454, 3233, 0),
            new Coordinate(2454, 3232, 0)
    };
}
