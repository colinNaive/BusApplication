package ctrip.business.bundle;

import android.app.Application;
import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ctrip.business.bus.BusInit;
import ctrip.business.bus.BusManager;

/**
 * @author Zhenhua on 2017/7/12.
 * @email zhshan@ctrip.com ^.^
 */
public class BaseLibsInit {

    public static void init(Application application) {
        initBusAndBundle(application);
    }

    private static void initBusAndBundle(Application application) {
        BusInit busInit = new BusInit();

        //Bus manager init
        BusManager.init(busInit);

        //all bundles setted
        configBundles(application, busInit);
    }

    private static void configBundles(Context context, BusInit busInit) {
        List<BundleConfigModel> bundleConfigModels = new ArrayList<>();

        //Module1
        bundleConfigModels.add(new BundleConfigModel(
                "module1",
                "ctrip.module1",
                "ctrip.module1.bus.ModuleOneBusObject",
                BundleConfigModel.BundleLoadType.AutoLoad
        ));
        //Module2
        bundleConfigModels.add(new BundleConfigModel(
                "module2",
                "ctrip.module2",
                "ctrip.module2.bus.ModuleTwoBusObject",
                BundleConfigModel.BundleLoadType.AutoLoad
        ));

        BundleConfigFactory.configBundles(bundleConfigModels);
    }
}
