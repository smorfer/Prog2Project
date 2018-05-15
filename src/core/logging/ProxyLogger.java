package core.logging;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyLogger implements InvocationHandler {

    private Object target;
    private String name;

    ProxyLogger(Object target, String name){
        this.target = target;
        this.name = name;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StringBuilder s = new StringBuilder(name + ": ");
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


        try {
            System.out.println(s);
            return method.invoke(target, args);
        } catch (Exception e) {
            System.out.println("Issue here!"); //TODO: Logger
            return null;
        }
    }
}
