package ctrip.business.bus;

import android.content.Context;

/**
 * @author colinambitious on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public abstract class BusObject {
    private String prefixAndHost;

    public BusObject(String host) {
        this.prefixAndHost = host;
    }

    public String getHost() {
        return this.prefixAndHost;
    }

    public abstract Object doDataJob(Context var1, String var2, Object... var3);


}
