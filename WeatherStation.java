import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private WeatherData currentData;

    public void setWeatherData(double temperature, double humidity) {
        this.currentData = new WeatherData(temperature, humidity);
        notifyObservers();
    }

    public WeatherData getWeatherData() {
        return currentData;
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(currentData);
        }
    }
}
