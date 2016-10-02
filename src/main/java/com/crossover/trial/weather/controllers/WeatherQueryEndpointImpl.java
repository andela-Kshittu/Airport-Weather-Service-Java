package com.crossover.trial.weather.controllers;

import com.crossover.trial.weather.services.WeatherService;
import com.google.gson.Gson;

import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;


/**
 * The Weather App REST endpoint allows clients to query, update and check health stats. Currently, all data is
 * held in memory. The end point deploys to a single container
 *
 * @author code test administrator
 */
@Path("/query") public class WeatherQueryEndpointImpl implements WeatherQueryEndpoint {

    public final static Logger LOGGER = Logger.getLogger("WeatherQuery");

    /**
     * shared gson json to object factory
     */
    public static final Gson gson = new Gson();

    private WeatherService mWeatherService;

    @Inject public void setWeatherService(final WeatherService weatherService) {
        this.mWeatherService = weatherService;
    }

    /**
     * Retrieve service health including total size of valid data points and request frequency information.
     *
     * @return health stats for the service as a string
     */
    @Override public String ping() {
        return gson.toJson(mWeatherService.getPingData());
    }

    /**
     * Given a query in json format {'iata': CODE, 'radius': km} extracts the requested airport information and
     * return a list of matching atmosphere information.
     *
     * @param iata the iataCode
     * @param radiusString the radius in km
     * @return a list of atmospheric information
     */
    @Override public Response weather(String iata, String radiusString) {
        return Response.status(Response.Status.OK)
            .entity(mWeatherService.getWeather(iata, radiusString)).build();
    }
}