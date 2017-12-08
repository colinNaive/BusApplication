package ctrip.business.bus;

import android.content.Context;

/**
 * @author colinambitious on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public class Bus {
    public synchronized static boolean register(BusObject busObject) {
        return BusManager.register(busObject);
    }

    public static Object callData(Context context, String bizName, Object... param) {
        BusObject e = BusManager.findBusObject(BusManager.parseBizNameHost(bizName));
        try {
            if (e != null) {
                return e.doDataJob(context, bizName, param);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
