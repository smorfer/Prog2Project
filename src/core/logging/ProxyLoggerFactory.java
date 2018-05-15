package core.logging;

import java.lang.reflect.Proxy;

public class ProxyLoggerFactory {
    public static Object getProxy(Object obj, String name){
        ProxyLogger proxyLogger = new ProxyLogger(obj, name);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), proxyLogger);
    }
}
