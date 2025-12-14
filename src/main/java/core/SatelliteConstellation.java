package core;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SatelliteConstellation {
    private String constellationName;
    private List<Satellite> satellites = new ArrayList<>();

    public SatelliteConstellation(String constellationName) {
        this.constellationName = constellationName;
        System.out.println("Создана спутниковая группа: " + constellationName);
    }

    public void addSatellite(Satellite satellite) {
        if (satellite != null && !satellites.contains(satellite)) {
            satellites.add(satellite);
            System.out.println(satellite.getName() + " добавлен в группу '" + constellationName + "'.");
        }
    }

    public void executeAllMissions() {
        System.out.println("ВЫПОЛНЕНИЕ МИССИЙ ГРУППЫ " + constellationName);
        System.out.println("=️".repeat(50));

        for (Satellite satellite : satellites) {
            satellite.performMission();
        }
    }
}
