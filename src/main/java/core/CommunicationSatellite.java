package core;

import lombok.Getter;

@Getter
public class CommunicationSatellite extends Satellite {
    private double bandwidth;

    public CommunicationSatellite(String name, double batteryLevel, double bandwidth) {
        super(name, batteryLevel);
        this.bandwidth = bandwidth;
    }

    @Override
    public void performMission() {
        if (isActive) {
            System.out.println(name + ": Передача данных со скоростью " + bandwidth + " Мбит/сек");
            sendData(bandwidth);
            consumeBattery(0.05);
        } else {
            System.out.println("\uD83D\uDED1 Ошибка передачи данных: " + name + " неактивен.");
        }
    }

    public void sendData(double data) {
        System.out.println(name + ": Отправил " + data + " Мбит данных.");
    }

    @Override
    public String toString() {
        return "CommunicationSatellite{" +
                "bandwidth=" + bandwidth +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", batteryLevel=" + batteryLevel +
                '}';
    }
}
