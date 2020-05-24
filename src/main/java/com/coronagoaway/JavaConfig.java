package com.coronagoaway;

import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {

    private Reflections scanner;
    private Map<Class, Class> ifc2ImplClass;

    public JavaConfig(String packageScan, Map<Class,Class> ifc2ImplClass) {
        this.scanner = new Reflections(packageScan);
        this.ifc2ImplClass = ifc2ImplClass;
    }

    @Override
    public <T> Class<? extends T> getInstance(Class<T> ifc) {
        //compileIfAbsent works from the Java 9 - returns value depends on a key, if could'nt find any match
        //execute the next lambda
       return ifc2ImplClass.computeIfAbsent(ifc,aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
            if (classes.size() > 2) {
                throw new RuntimeException(ifc + ": has 0 or more than one implementation");
            }
            return classes.iterator().next();
        });
    }
}
