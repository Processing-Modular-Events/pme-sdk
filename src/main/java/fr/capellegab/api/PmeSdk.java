package fr.capellegab.api;

public final class PmeSdk {

    public static final String NAME = "pme-sdk";
    public static final String VERSION = "0.0.1";

    private PmeSdk() {}

    public static String info() {
        return NAME + " v" + VERSION;
    }
}
