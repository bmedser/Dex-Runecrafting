package com.xcookie.rc.assets;

import com.runemate.game.api.hybrid.local.Rune;
import com.runemate.game.api.hybrid.location.Coordinate;

import java.util.HashMap;
import java.util.HashSet;

public enum Runecrafting {

        OURANIA_ALTAR(0, "Ourania altar", new Coordinate(3059, 5583, 0)),
        NATURE_RUNES(1, "Nature runes", new Coordinate(2398, 4841, 0)),
        LAW_ALTAR(2, "Law altar", new Coordinate(2464, 4834, 0)),
        COSMIC_ALTAR(3, "Cosmic altar", new Coordinate(2162, 4833, 0)),
        AIR_ALTAR(4, "Air altar", new Coordinate(2845, 4832, 0)),
        WATER_ALTAR(5, "Water altar", new Coordinate(2713, 4836, 0)),
        EARTH_ALTAR(6, "Earth altar", new Coordinate(2260, 4839, 0)),
        FIRE_ALTAR(7, "Fire altar", new Coordinate(2584, 4836, 0)),
        BODY_ALTAR(8, "Body altar", new Coordinate(2527, 4833, 0)),
        CHAOS_ALTAR(9, "Chaos altar", new Coordinate(2269, 4843, 0));

        Runecrafting(int id, String name, Coordinate coordinate) {
                this.id = id;
                this.name = name;
                this.coordinate = coordinate;
        }

        private final int id;
        private final String name;
        private final Coordinate coordinate;
        public int size = 9/*Runecrafting.values().length*/;

        @Override
        public String toString() {
                return name;
        }

        public int getId() {
                return id;
        }

        public int getSize() {
                return size;
        }

        public String getName() {
                return name;
        }

}