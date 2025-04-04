package due.giuaky221121514233.day3.model;
import due.giuaky221121514233.day3.model.Temperature;
import com.google.gson.annotations.SerializedName;

public class Weather {
    @SerializedName("DateTime")
    private String dateTime;

    @SerializedName("WeatherIcon")
    private int weatherIcon;

    @SerializedName("IconPhrase")
    private String iconPhrase;

    @SerializedName("Temperature")
    private Temperature temperature;

    public String getDateTime() { return dateTime; }
    public int getWeatherIcon() { return weatherIcon; }
    public String getIconPhrase() { return iconPhrase; }
    public Temperature getTemperature() { return temperature; }
}
