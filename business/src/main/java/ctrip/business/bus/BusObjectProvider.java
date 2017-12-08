package ctrip.business.bus;

/**
 * @author colinambitious on 2017/7/11.
 * @email zhshan@ctrip.com ^.^
 */
public interface BusObjectProvider {
    boolean register(BusObject var1);
    BusObject findBusObject(String var1);
}
