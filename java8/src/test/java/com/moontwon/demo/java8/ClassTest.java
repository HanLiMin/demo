package com.moontwon.demo.java8;

import com.moontwon.demo.java8.annotation.Tree;
import com.moontwon.demo.java8.dao.StudentDAO;
import com.moontwon.demo.java8.dao.impl.StudentDAOImpl;
import com.moontwon.demo.java8.dto.CollegeDTO;
import com.moontwon.demo.java8.dto.StudentDTO;
import com.moontwon.demo.java8.dto.TeacherDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;

import java.lang.reflect.*;
import java.util.*;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/8/9
 */
public class ClassTest {
    @Test
    public void testTypeName() {
        HashMap<String, Long>[] hashMaps = new HashMap[0];
        System.err.println(hashMaps.getClass().getTypeName());
        System.err.println(hashMaps.getClass().getName());
        System.err.println(int.class.getTypeName());
        System.err.println(int.class.getName());
        int[] ints = new int[0];
        System.err.println(ints.getClass().getTypeName());
        System.err.println(ints.getClass().getName());
        System.err.println(hashMaps);

        int[][][] ints1 = new int[0][][];
        System.err.println(ints1);
        List<Integer>[] list = new ArrayList[0];
        System.err.println(list.getClass().getName());

    }

    @Test
    public void testAnnotatedElement() {
        Class<CollegeDTO> collegeDTOClass = CollegeDTO.class;
        Arrays.stream(collegeDTOClass.getDeclaredAnnotations()).sequential().forEach(System.out::println);


    }


    @Test
    public void testAnnotatedElement1() {
        Class<CollegeDTO> collegeDTOClass = CollegeDTO.class;
        Arrays.stream(collegeDTOClass.getAnnotations()).sequential().forEach(System.out::println);
    }

    @Test
    public void testAnnotatedElement2() {
        Class<CollegeDTO> collegeDTOClass = CollegeDTO.class;
        Arrays.stream(collegeDTOClass.getDeclaredAnnotationsByType(Tree.class)).sequential().forEach(System.out::println);
    }

    @Test
    public void testAnnotatedElement3() {
        Class<CollegeDTO> collegeDTOClass = CollegeDTO.class;
        System.err.println(collegeDTOClass.getAnnotation(Tree.class));
    }

    @Test
    public void testSupperClassMethond() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<CollegeDTO> collegeDTOClass = CollegeDTO.class;
        Method doSomething = collegeDTOClass.getMethod("doSomething");
        doSomething.invoke(new CollegeDTO(), null);
    }

    @Test
    public void testSupperClassStaticMethond() throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Class<CollegeDTO> collegeDTOClass = CollegeDTO.class;
        Method doSomething = collegeDTOClass.getDeclaredMethod("print");
        doSomething.setAccessible(true);
        doSomething.invoke(null);
    }

    @Test
    public void testToGenericString() {
        Map<String, Thread> map = new HashMap<>();
        System.err.println(map.getClass().getName());
        System.err.println(map.getClass().toGenericString());
    }

    @Test
    public void testGenericsInfo() {
        Type[] genericInterfaces = StudentDAOImpl.class.getGenericInterfaces();
        Type genericInterface = genericInterfaces[0];
        ParameterizedType parameterizedType = (ParameterizedType) genericInterface;
        System.err.println(parameterizedType.getOwnerType());
        System.err.println(parameterizedType.getRawType());
        System.err.println(Arrays.toString(parameterizedType.getActualTypeArguments()));
    }

    @Test
    public void testInterfaceGenericsInfo() {
        Type[] genericInterfaces = StudentDAO.class.getTypeParameters();
        for (Type genericInterface : genericInterfaces) {
            TypeVariable typeVariable = (TypeVariable) genericInterface;
            System.err.println("annotatedType:\n");
            for (AnnotatedType annotatedType : typeVariable.getAnnotatedBounds()) {
                System.err.println(ToStringBuilder.reflectionToString(annotatedType, ToStringStyle.JSON_STYLE));
                System.err.println("\n");
            }
            System.err.println(Arrays.toString(typeVariable.getBounds()));
            System.err.println(typeVariable.getGenericDeclaration());
            System.err.println(typeVariable.getName());
            System.err.println(typeVariable.getTypeName());
            System.err.println("===========================================\n");

        }
    }

    @Test
    public void testGetEnclosingMethod() {
        Class<StudentDAOImpl> studentDAOClass = StudentDAOImpl.class;
        System.err.println(Arrays.toString(studentDAOClass.getClasses()));
    }
    @Test
    public void testIsAssignableFrom(){
        System.err.println(StudentDTO.class.isAssignableFrom(CollegeDTO.class));
    }

    @Test
    public void testGetTypeParamers(){
        Map<String, Integer> map = new HashMap<>();
        Class<? extends Map> clazz = map.getClass();
        System.err.println(Arrays.toString(clazz.getTypeParameters()));
    }

    @Test
    public void testField() throws NoSuchFieldException {
        Class<TeacherDTO> teacherDTOClass = TeacherDTO.class;
        Field field = teacherDTOClass.getField("studentDTOS");
        System.err.println(field.getGenericType().getClass());
        System.err.println(field.getDeclaringClass());
        ParameterizedType genericType = (ParameterizedType) field.getGenericType();
        System.err.println(genericType.getRawType());
        System.err.println(genericType.getActualTypeArguments()[0]);
        System.err.println("================================");
        Field field2 = teacherDTOClass.getField("obj");
        System.err.println(field2.getGenericType().getClass());
        System.err.println(field2.getDeclaringClass());
        System.err.println("================================");
        Field field3 = teacherDTOClass.getField("objs");
        System.err.println(field3.getGenericType().getClass());
        System.err.println(field3.getDeclaringClass());
    }

    @Test
    public void testClassName(){
        System.err.println(StudentDAO.class.getName());
        System.err.println(StudentDAO.class.toString());
    }
}
