package ctrip.business;

import android.app.Application;
import android.content.Context;

import ctrip.business.bundle.BaseLibsInit;

/**
 * @author Zhenhua on 2017/12/8.
 * @email zhshan@ctrip.com ^.^
 */

public class BaseApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        BaseLibsInit.init(this);
    }
}
