package com.aevi.sdk.pos.flow.config.sample;

import com.aevi.sdk.pos.flow.config.DefaultConfigProvider;

public class SampleConfigProvider extends DefaultConfigProvider {

    private static final String CURRENCY_DENOMINATIONS_KEY = "currency_denominations";

    @Override
    public boolean onCreate() {
        super.onCreate();
        addConfigKeys(CURRENCY_DENOMINATIONS_KEY);
        return true;
    }

    @Override
    public String getConfigValue(String key) {
        if (key.equals(CURRENCY_DENOMINATIONS_KEY)) {
            return readFile(R.raw.denominations);
        }
        return super.getConfigValue(key);
    }
}
