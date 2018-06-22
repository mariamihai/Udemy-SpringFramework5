package guru.springframework.spring5webapp.transactionAppRelatedCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CurrencyUtil {

    public static Set<Currency> getAvailableCurrencies() {
        return Currency.getAvailableCurrencies();
    }

    @Deprecated
    public static ArrayList<String> getAllCurrencies() {
        ArrayList<String> currencies = new ArrayList<String>();
        Locale[] locs = Locale.getAvailableLocales();

        for(Locale loc : locs) {
            try {
                String val = getCurrencyBasedOnLocale(loc).getCurrencyCode();
                if(!currencies.contains(val))
                    currencies.add(val);
            } catch(Exception exc)
            {
                // Locale not found
            }
            Collections.sort(currencies);
        }
        return currencies;
    }

    public static TimeZone getTimeZoneBasedOnLocale(Locale locale) {
        Calendar calendar = Calendar.getInstance(locale);
        TimeZone clientTimeZone = calendar.getTimeZone();

        return clientTimeZone; // .getID()
    }

    public static Currency getCurrencyBasedOnLocale(Locale locale) {
        return Currency.getInstance(locale);
    }
}
