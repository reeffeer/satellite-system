package core;

import lombok.Getter;

@Getter
public abstract class Satellite {
    protected String name;
    protected boolean isActive;
    protected double batteryLevel;

    public Satellite(String name, double batteryLevel) {
        this.name = name;
        this.isActive = false;
        this.batteryLevel = Math.max(0.0, Math.min(1.0, batteryLevel));
        System.out.println("Создан спутник: " + name + " (заряд: " + (int)(batteryLevel * 100) + "%)");
    }

    boolean activate() {
        if (batteryLevel > 0.2 && !isActive) {
            isActive = true;
            System.out.println("✅ " + name + ": Активация успешна");
            return true;
        }
        System.out.println("\uD83D\uDD34 " + name + ": Ошибка активации (заряд: " + (int)(batteryLevel * 100) + "%)");
        return false;
    }
    void deactivate() {
        if (isActive) {
            isActive = false;
            System.out.println("\uD83D\uDFE1 " + name + ": Деактивирован");
        }
    }
    protected abstract void performMission();

    void consumeBattery(double energy) {
        batteryLevel -= energy;
        if (energy > 0) {
            batteryLevel = Math.max(0.0, batteryLevel - energy);
            if (batteryLevel < 0.2 && isActive) {
                System.out.println("\uD83D\uDD34 НИЗКИЙ ЗАРЯД!" + name + " деактивируется...");
                deactivate();
            }
        }
    }
}
