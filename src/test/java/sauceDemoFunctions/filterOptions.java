package sauceDemoFunctions;

public enum filterOptions {
	NAME_AZ("az"),
    NAME_ZA("za"),
    PRICE_LOW_HIGH("lohi"),
    PRICE_HIGH_LOW("hilo");

    private final String value;

    filterOptions(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
