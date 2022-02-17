package dk.sdu.mmmi.cbse.common.util;

import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;

import java.util.*;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class SPILocator {


    private static final Map<Class, ServiceLoader> map = new HashMap<>();


    public SPILocator() {
    }

    public static <T> List<T> locateAll(Class<T> service) {


        ServiceLoader<T> loader = map.get(service);

        boolean printStatement = false;

        if(loader == null){

            loader = ServiceLoader.load(service);
            map.put(service, loader);

            printStatement = true;
        }

        List<T> list = new ArrayList<>();

        if(loader != null){

            for (T instance :
                    loader) {
                list.add(instance);
            }

        }

        if (printStatement) {
            System.out.println("Found " + list.size() + " implementations for interface: " + service.getName());
        }


        return list;
    }
}
