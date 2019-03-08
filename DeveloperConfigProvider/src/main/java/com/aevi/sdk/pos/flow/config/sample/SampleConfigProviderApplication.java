package com.aevi.sdk.pos.flow.config.sample;

import com.aevi.sdk.pos.flow.config.BaseConfigProviderApplication;

import static com.aevi.sdk.pos.flow.config.ConfigComponentProvider.getSettingsProvider;

public class SampleConfigProviderApplication extends BaseConfigProviderApplication {

    @Override
    protected void onComponentsReady() {
        getSettingsProvider().setOverwriteConfigsOnReinstall(true);
        getSettingsProvider().setInitialAutoGenerateConfigsValue(true);
        // We want the samples to be as we have pre-defined it in the flows here - so we ignore them for the "auto" management
        getSettingsProvider().setAppsToIgnoreForAutoGeneration("com.aevi.sdk.pos.flow.flowservicesample",
                                                               "com.aevi.sdk.pos.flow.paymentservicesample");
    }

    @Override
    protected int[] getFlowConfigs() {
        return new int[]{R.raw.flow_sale,
                         R.raw.flow_refund,
                         R.raw.flow_reversal,
                         R.raw.flow_tokenisation,
                         R.raw.flow_receipt_delivery,
                         R.raw.flow_basket_status_update};
    }
}
