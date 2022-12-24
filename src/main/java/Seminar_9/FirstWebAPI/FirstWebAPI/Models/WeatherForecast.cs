namespace FirstWebAPI.Models
{
    /// <summary>
    /// Прогноз погоды
    /// </summary>
    public class WeatherForecast
    {
        /// <summary>
        /// Дата измерения
        /// </summary>
        public DateTime Date { get; set; }
        
        /// <summary>
        /// Температцра в градусах Цельсия 
        /// </summary>
        public int TemperatureC { get; set; }

        public int TemperatureF
        {
            get { return 32 + (int)(TemperatureC / 0.5556); }
        }

        public WeatherForecast(DateTime date, int temperatureC) {
            Date = date;
            TemperatureC = temperatureC;
        }

    }
}
