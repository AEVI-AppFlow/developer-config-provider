package com.aevi.sdk.pos.flow.config.sample;

import com.aevi.sdk.pos.flow.PaymentApi;
import com.aevi.sdk.pos.flow.config.BaseConfigProviderApplication;

import static com.aevi.sdk.pos.flow.config.ConfigComponentProvider.getSettingsProvider;

public class SampleConfigProviderApplication extends BaseConfigProviderApplication {

    @Override
    protected void onComponentsReady() {
        getSettingsProvider().updateAutoGenerateConfig(true);
        getSettingsProvider().setOverwriteConfigsOnReinstall(true);
    }

    @Override
    public int[] getFlowConfigs() {
        // TODO temporary hack to avoid sending fulfilled check to FPS 2.0.X
        String fpsVersion = PaymentApi.getProcessingServiceVersion(this);
        int saleFlow = fpsVersion.startsWith("2.0") ? R.raw.flow_sale : R.raw.flow_sale_with_fulfilled_check;

        return new int[]{saleFlow,
                         R.raw.flow_refund,
                         R.raw.flow_reversal,
                         R.raw.flow_tokenisation,
                         R.raw.flow_receipt_delivery,
                         R.raw.flow_basket_status_update};
    }
}
