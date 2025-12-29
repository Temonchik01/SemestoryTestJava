public class Main {
    public static void main(String[] args) throws InterruptedException {

        WeatherStation station = new WeatherStation();
        WeatherStationProxy proxy = new WeatherStationProxy(station);

        WeatherClient client1 = new WeatherClient("Клієнт 1");
        WeatherClient client2 = new WeatherClient("Клієнт 2");

        station.registerObserver(client1);
        station.registerObserver(client2);

        station.setWeatherData(22.5, 60);
        proxy.getWeatherData();

        Thread.sleep(3000);
        proxy.getWeatherData();

        Thread.sleep(8000);
        station.setWeatherData(25.0, 55);
        proxy.getWeatherData();
    }
}
