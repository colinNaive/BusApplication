package ctrip.business.bus;

import android.text.TextUtils;

/**
 * @author colinambitious on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public class BusManager {
    private static BusObjectProvider busObjectProvider;

    public static void init(BusObjectProvider busObjectProvider) {
        BusManager.busObjectProvider = busObjectProvider;
    }

    public static boolean register(BusObject busObject) {
        return busObjectProvider.register(busObject);
    }

    public static BusObject findBusObject(String hostName) {
        return busObjectProvider.findBusObject(hostName);
    }


    public static String parseBizNameHost(String bizName) {
        if (TextUtils.isEmpty(bizName)) {
            return null;
        }

        int slashIndex = bizName.indexOf("/");
        if (slashIndex != -1) {
            return bizName.substring(0, slashIndex);
        } else {
            throw new IllegalArgumentException("bus url error " + bizName);
        }
    }
}
