package ctrip.business.utils;

import android.text.TextUtils;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author Zhenhua on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public class LogUtil {
    private static final String TAG = "Ctrip";
    private static final String dPath = "/sdcard/d.x";
    static boolean isCanShowLog = xlgEnabled();
    static boolean isReadFlagAlready = false;

    public LogUtil() {
    }

    public static void setxlgEnable(boolean enable) {
        isCanShowLog = enable;

        try {
            File e = new File("/sdcard/d.x");
            if (enable) {
                if (!e.exists()) {
                    e.createNewFile();
                }
            } else if (e.exists()) {
                e.delete();
            }
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static boolean xlgEnabled() {
        if (isReadFlagAlready) {
            return isCanShowLog;
        } else {
            isReadFlagAlready = true;
            File fp = new File("/sdcard/d.x");
            if (fp != null && fp.exists()) {
                isCanShowLog = true;
            }

            return isCanShowLog;
        }
    }

    public static void v(String msg) {
        if (isCanShowLog) {
            Log.v("Ctrip", buildMessage(msg));
        }

    }

    public static void v(String tag, String msg) {
        if (isCanShowLog) {
            Log.v(tag, buildMessage(msg));
        }

    }

    public static void v(String msg, Throwable thr) {
        if (isCanShowLog) {
            Log.e("EXCEPTION", "##异常信息##:[" + msg + "]");
            thr.printStackTrace();
        }

    }

    public static void d(String msg) {
        if (isCanShowLog) {
            Log.d("Ctrip", buildMessage(msg));
        }

    }

    public static void d(String tag, String msg) {
        if (isCanShowLog) {
            Log.d(tag, buildMessage(msg));
        }

    }

    public static void d(String tag, String msg, Throwable thr) {
        if (isCanShowLog) {
            Log.e(tag, "##异常信息##:[" + msg + "]", thr);
            thr.printStackTrace();
        }

    }

    public static void d(String msg, Throwable thr) {
        if (isCanShowLog) {
            Log.e("EXCEPTION", "##异常信息##:[" + msg + "]");
            thr.printStackTrace();
        }

    }

    public static void e(String msg) {
        if (isCanShowLog) {
            Log.e("Ctrip", buildMessage(msg));
        }

    }

    public static void e(String tag, String msg) {
        if (isCanShowLog) {
            Log.e(tag, buildMessage(msg));
        }

    }

    public static void e(String tag, String msg, Throwable thr) {
        if (isCanShowLog) {
            Log.e(tag, "##异常信息##:[" + msg + "]", thr);
            thr.printStackTrace();
        }

    }

    public static void e(String msg, Throwable thr) {
        if (isCanShowLog) {
            Log.e("EXCEPTION", "##异常信息##:[" + msg + "]");
            if (thr != null) {
                thr.printStackTrace();
            }
        }

    }

    public static void f(String tag, String msg) {
        if (!TextUtils.isEmpty(msg)) {
            if (TextUtils.isEmpty(tag)) {
                tag = "Force_Log";
            }

            Log.e(tag, msg);
        }
    }

    private static String buildMessage(String msg) {
        StackTraceElement caller = (new Throwable()).fillInStackTrace().getStackTrace()[2];
        return msg;
    }

    private static void invokeWSLogMethod(String methodName, Object obj) {
        try {
            Class e = Class.forName("ctrip.android.reactnative.tools.CRNLogClient");
            if (e != null) {
                Method method = e.getMethod(methodName, new Class[]{Object.class});
                if (method != null) {
                    method.invoke((Object) null, new Object[]{obj});
                }
            }
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static void log(Object msg) {
        if (xlgEnabled()) {
            invokeWSLogMethod("log", msg);
        }
    }

    public static void logError(Object msg) {
        if (xlgEnabled()) {
            invokeWSLogMethod("logError", msg);
        }
    }

    public static void logWarning(Object msg) {
        if (xlgEnabled()) {
            invokeWSLogMethod("logWarning", msg);
        }
    }
}