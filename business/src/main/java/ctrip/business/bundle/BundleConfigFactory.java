package ctrip.business.bundle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Zhenhua on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public class BundleConfigFactory {
    private final static List<BundleConfigModel> bundleConfigModels = new ArrayList();

    public BundleConfigFactory() {
    }

    public static List<BundleConfigModel> getBundleConfigModels() {
        return bundleConfigModels;
    }

    public static void configBundles(List<BundleConfigModel> configModels) {
        bundleConfigModels.clear();
        bundleConfigModels.addAll(configModels);
    }

    public static BundleConfigModel getBundleConfigModelByModuleName(String moduleName) {
        Iterator it = bundleConfigModels.iterator();
        while (it.hasNext()) {
            BundleConfigModel model = (BundleConfigModel)it.next();
            if (model.moduleName.equalsIgnoreCase(moduleName)) {
                return model;
            }
        }
        return null;
    }
}
