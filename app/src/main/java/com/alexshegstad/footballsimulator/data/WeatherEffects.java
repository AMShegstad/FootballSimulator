package com.alexshegstad.footballsimulator.data;

import com.alexshegstad.footballsimulator.model.enumerations.Weather;

public class WeatherEffects {
    
    /**
     * Get the weather modifier for a specific stat
     * Returns 0 for CLEAR weather (no penalties)
     * Returns negative values for adverse weather
     */
    public static int getStatModifier(String statName, Weather weather) {
        if (weather == Weather.CLEAR) {
            return 0; // No penalties in clear weather
        }
        
        switch (weather) {
            case SNOWY:
                switch (statName) {
                    case "speed": return -5;
                    case "acceleration": return -5;
                    case "routeRunning": return -8;
                    case "elusiveness": return -6;
                    case "pursuit": return -4;
                    case "carrying": return -3; // Ball harder to hold
                    default: return 0;
                }
                
            case FOGGY:
                switch (statName) { 
                    case "shortAccuracy": return -3;
                    case "mediumAccuracy": return -6;
                    case "deepAccuracy": return -10;
                    case "kickAccuracy": return -8;
                    case "ballCarrierVision": return -5;
                    case "catching": return -4; // Hard to see ball
                    default: return 0;
                }
                
            case RAINY:
                switch (statName) {
                    case "catching": return -6;
                    case "carrying": return -4;
                    case "speed": return -3;
                    case "routeRunning": return -4;
                    case "throwPower": return -2;
                    case "shortAccuracy": return -2;
                    case "mediumAccuracy": return -3;
                    case "deepAccuracy": return -4;
                    default: return 0;
                }
                
            case SWELTERING:
                switch (statName) {
                    case "speed": return -3;
                    case "acceleration": return -2;
                    case "hitPower": return -3;
                    case "pursuit": return -2;
                    default: return 0;
                }
                
            case OVERCAST:
                switch (statName) {
                    case "deepAccuracy": return -2;
                    case "ballCarrierVision": return -1;
                    default: return 0;
                }
                
            default:
                return 0;
        }
    }
    
    /**
     * Apply weather modifier to a stat value
     * Ensures result stays within 1-99 range
     */
    public static int applyWeatherToStat(int baseStat, String statName, Weather weather) {
        int modifier = getStatModifier(statName, weather);
        return Math.max(1, Math.min(99, baseStat + modifier));
    }
}