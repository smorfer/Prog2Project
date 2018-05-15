package core.logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProxyLogger implements InvocationHandler {

    private Object target;
    private String name;
    private static Logger logger = Logger.getLogger(ProxyLogger.class.getName());

    ProxyLogger(Object target, String name){
        this.target = target;
        this.name = name;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StringBuilder s = new StringBuilder("Invocation: " + name + ".");
        s.append(method.getName());
        s.append("(");

        if(args != null) {
            for(int i = 0; i < args.length; i++) {
                if(i > 0) {
                    s.append(", ");
                }
                s.append(args[i].toString());
            }
        }
        s.append(")");

        logger.log(Level.INFO, s.toString());


        try {
            return method.invoke(target, args);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Invocation failed! Reason: " + e.toString());
            return null;
        }
    }
}
