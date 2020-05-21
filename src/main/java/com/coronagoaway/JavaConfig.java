package com.coronagoaway;

import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config {

    private Reflections scanner;

    public JavaConfig(String packageScan) {
        this.scanner = new Reflections(packageScan);
    }

    @Override
    public <T> Class<? extends T> getInstance(Class<T> ifc) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(ifc);
        if (ifc.isInterface()) {
            if (classes.size() != 1) {
                throw new RuntimeException(ifc+ " There is 0 or more than one implementations");
            }
        }
        return classes.iterator().next();
    }
}
