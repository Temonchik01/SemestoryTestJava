public class WeatherStationProxy {

    private final WeatherStation realStation;
    private WeatherData cachedData;
    private long lastUpdateTime;

    private static final long CACHE_TTL = 10_000;

    public WeatherStationProxy(WeatherStation realStation) {
        this.realStation = realStation;
    }

    public WeatherData getWeatherData() {
        long currentTime = System.currentTimeMillis();

        if (cachedData == null || currentTime - lastUpdateTime > CACHE_TTL) {
            cachedData = realStation.getWeatherData();
            lastUpdateTime = currentTime;
            System.out.println("Proxy: отримано нові дані з джерела");
        } else {
            System.out.println("Proxy: повернено дані з кешу");
        }

        return cachedData;
    }
}
