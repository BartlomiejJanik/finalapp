package pl.sda.finalapp.app;

public enum Country {
    POLAND("Polska","pl"),
    ENGLAND("Anglia","gb"),
    GERMANY("Niemcy","de"),
    USA("Stany Zjednoczone","us");


    private final String countryName;
    private final String symbol;

    Country(String countryName, String symbol) {

        this.countryName = countryName;
        this.symbol = symbol;
    }

    public String getCountryName() {
        return countryName;
    }

    public String getSymbol() {
        return symbol;
    }
}
