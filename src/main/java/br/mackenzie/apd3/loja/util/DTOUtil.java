package br.mackenzie.apd3.loja.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by BWeninger on 11/04/2015.
 */
public final class DTOUtil {

    private DTOUtil() {

    }

    public static <T> List<T> converterLista(List<? extends Object> src, Class<T> clazz) {
        List<T> target = new ArrayList<>(src.size());
        for (Object objSrc : src) {
            T objTgt = null;
            try {
                objTgt = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                System.out.println("Ocorreu um erro ao instanciar a classe destino : ");
                e.printStackTrace();
            }
            copiarPropriedades(objSrc, objTgt, obterNomesAtributos(clazz));
            target.add(objTgt);
        }
        return target;
    }

    public static void copiarPropriedades(
            final Object source,
            final Object target,
            final Iterable<String> properties) {

        final BeanWrapper src = new BeanWrapperImpl(source);
        final BeanWrapper trg = new BeanWrapperImpl(target);

        for (final String propertyName : properties) {
            Class<?> sourceType = src.getPropertyType(propertyName);
            Class<?> targetType = trg.getPropertyType(propertyName);
            if (targetType == sourceType) {
                trg.setPropertyValue(propertyName, src.getPropertyValue(propertyName));
            } else {
                try {
                    Object instance = targetType.newInstance();
                    copiarPropriedades(src.getPropertyValue(propertyName), instance, obterNomesAtributos(sourceType));
                    trg.setPropertyValue(propertyName, instance);
                } catch (IllegalAccessException | InstantiationException ex) {
                    System.out.println("Ocorreu um erro ao copiar as propriedades dos beans: ");
                    ex.printStackTrace();
                }
            }
        }

    }

    public static <T> Iterable<String> obterNomesAtributos(Class<T> clazz) {
        List<String> fieldNames = new ArrayList<>();
        List<Field> fieldsList = Arrays.asList(clazz.getDeclaredFields());
        for (Field field : fieldsList) {
            fieldNames.add(field.getName());
        }
        return fieldNames;
    }
}
