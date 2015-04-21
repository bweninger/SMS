package br.mackenzie.apd3.loja.util;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
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
            T objTgt = BeanUtils.instantiate(clazz);
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
            if (sourceType != null && targetType != null
                    && src.getPropertyValue(propertyName) != null) {
                if ((source instanceof List &&
                        target instanceof List)) {
                    List collectionSrc = (List) source;
                    List collectionTgt = converterLista(collectionSrc,
                            ((ParameterizedType) target.getClass().
                                    getGenericSuperclass()).getActualTypeArguments()[0].getClass());
                    trg.setPropertyValue(propertyName, collectionTgt);
                } else if (sourceType == List.class && targetType == List.class) {
                    Field declaredField = null;
                    try {
                        declaredField = target.getClass().getDeclaredField(propertyName);
                    } catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    ParameterizedType genericType = (ParameterizedType) declaredField.getGenericType();
                    List listaTgt = converterLista((List) src.getPropertyValue(propertyName),
                            (Class<?>) genericType.getActualTypeArguments()[0]);
                    trg.setPropertyValue(propertyName, listaTgt);
                } else if (targetType == sourceType) {
                    trg.setPropertyValue(propertyName, src.getPropertyValue(propertyName));
                } else {
                    Object instance = BeanUtils.instantiate(targetType);
                    copiarPropriedades(src.getPropertyValue(propertyName), instance, obterNomesAtributos(sourceType));
                    trg.setPropertyValue(propertyName, instance);
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
