package ctrip.business.bundle;

import java.util.ArrayList;

/**
 * @author Zhenhua on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public class BundleConfigModel {
    public String moduleName;
    public String packageName;
    public String busObjectName;
    public BundleConfigModel.BundleLoadType bundleLoadType;
    public ArrayList<String> dependenceList;
    public boolean isMain;
    public boolean isLoadInBackground;

    public BundleConfigModel(String moduleName, String packageName, String busObjectName, BundleConfigModel.BundleLoadType bundleLoadType) {
        this(moduleName, packageName, busObjectName, bundleLoadType, false);
    }

    public BundleConfigModel(String moduleName, String packageName, String busObjectName, BundleConfigModel.BundleLoadType bundleLoadType, boolean isMain) {
        this(moduleName, packageName, busObjectName, bundleLoadType, isMain, false);
    }

    public BundleConfigModel(String moduleName, String packageName, String busObjectName, BundleConfigModel.BundleLoadType bundleLoadType, boolean isMain, boolean isLoadInBackground) {
        this(moduleName, packageName, busObjectName, bundleLoadType, isMain, isLoadInBackground, (ArrayList)null);
    }

    public BundleConfigModel(String moduleName, String packageName, String busObjectName, BundleConfigModel.BundleLoadType bundleLoadType, boolean isMain, boolean isLoadInBackground, ArrayList<String> dependenceList) {
        this.moduleName = moduleName;
        this.packageName = packageName;
        this.busObjectName = busObjectName;
        this.bundleLoadType = bundleLoadType;
        this.dependenceList = dependenceList;
        this.isMain = isMain;
        this.isLoadInBackground = isLoadInBackground;
    }

    public static enum BundleLoadType {
        RemoteLoad(1),
        AutoLoad(1),
        LazyLoad(2);

        private int value;

        private BundleLoadType(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }
}
