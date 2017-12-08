package ctrip.business.bus;

import android.text.TextUtils;

import java.lang.reflect.Constructor;
import java.util.HashMap;

import ctrip.business.bundle.BundleConfigFactory;
import ctrip.business.bundle.BundleConfigModel;
import ctrip.business.utils.LogUtil;

/**
 * @author Zhenhua on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public class BusInit implements BusObjectProvider {

    private HashMap<String, BusObject> hashMap = new HashMap<>();

    @Override
    public boolean register(BusObject busObject) {
        if (busObject == null) {
            return false;
        }

        String host = busObject.getHost().toLowerCase();
        if (hashMap.containsKey(host)) {
            LogUtil.f("BusManager", host + "已存在 请勿重复注册");
        }
        hashMap.put(host, busObject);
        return true;
    }

    public static BusObject registerBusObjectWithHost(String host) {
        if (TextUtils.isEmpty(host)) {
            return null;
        }
        BundleConfigModel bundleConfigModel = BundleConfigFactory.getBundleConfigModelByModuleName(host);
        if (null == bundleConfigModel) {
            return null;
        }
        BusObject retObj = null;
        try {
            String className = bundleConfigModel.busObjectName;
            Class<BusObject> clazz = (Class<BusObject>) Class.forName(className);
            Constructor<BusObject> constructor = clazz.getConstructor(String.class);
            BusObject tmpRetObj = constructor.newInstance(host);
            if (Bus.register(tmpRetObj)) {
                retObj = tmpRetObj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retObj;
    }

    @Override
    public BusObject findBusObject(String host) {
        if (TextUtils.isEmpty(host)) {
            return null;
        }

        BusObject object = hashMap.get(host.toLowerCase());
        if (object == null) {
            object = registerBusObjectWithHost(host);
        }
        return object;
    }
}
