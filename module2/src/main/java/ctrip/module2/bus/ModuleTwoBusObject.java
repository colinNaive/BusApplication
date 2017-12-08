package ctrip.module2.bus;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import ctrip.business.bus.BusObject;
import ctrip.module2.ModuleTwoActivity;

/**
 * @author Zhenhua on 2017/12/8.
 * @email zhshan@ctrip.com ^.^
 */

public class ModuleTwoBusObject extends BusObject {
    public ModuleTwoBusObject(String host) {
        super(host);
    }

    @Override
    public Object doDataJob(Context context, String bizName, Object... param) {
        if (TextUtils.equals(bizName, "module2/test")) {
            Intent intent = new Intent(context, ModuleTwoActivity.class);
            context.startActivity(intent);
        }
        return null;
    }
}
