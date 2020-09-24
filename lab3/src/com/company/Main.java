package com.company;

public class Main {

    public static void main(String[] args) {
        BootsAllTerrain boots = new BootsAllTerrain();
        Broom broom = new Broom();
        BactrianCamel camelB = new BactrianCamel();
        CamelSpeedboat camelS = new CamelSpeedboat();
        MagicCarpet carpet = new MagicCarpet();
        Mortar mortar = new Mortar();
        Centaur centaur = new Centaur();

        AirRace airRace = new AirRace(7000);
        LandRace landRace = new LandRace(6000);
        AllRace allRace = new AllRace(100);

        airRace.register(carpet, broom, mortar);
        landRace.register(boots, camelS, camelB, centaur);
        allRace.register(camelS, camelB, boots, centaur, broom, carpet, mortar);

        System.out.println(airRace.start());
        System.out.println(landRace.start());
        System.out.println(allRace.start());
    }
}
