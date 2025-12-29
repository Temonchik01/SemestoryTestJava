public class WeatherClient implements Observer {

    private final String name;

    public WeatherClient(String name) {
        this.name = name;
    }

    @Override
    public void update(WeatherData data) {
        System.out.println(
            name + " отримав оновлення: температура = "
            + data.getTemperature() + ", вологість = " + data.getHumidity()
        );
    }
}
