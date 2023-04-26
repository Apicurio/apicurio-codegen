///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS org.reflections:reflections:0.10.2
//DEPS io.apicurio:apicurio-data-models:2.0.0.RC1

import java.util.*;
import org.reflections.*;

import static java.lang.System.*;
import static org.reflections.scanners.Scanners.*;

public class extractRegisterForReflection {

    public static void main(String... args) {
        Reflections reflections = new Reflections("io.apicurio");

        Set<Class<?>> subTypes = reflections.get(SubTypes.of(io.apicurio.datamodels.models.Node.class).asClass());

        subTypes
            .stream()
            .map(t -> t.getCanonicalName() + ".class")
            .sorted()
            .forEach(s -> out.println(s));
    }
}
