package designmodde.dynamicproxy;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Author Huang Guojun
 * @Date 2019/7/8
 * @Discription
 */
public class Proxy {
    public static Object newProxyInstance(Class inf) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy").addSuperinterface(inf);
        FieldSpec fieldSpec = FieldSpec.builder(Flyable.class, "flyable", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(Flyable.class, "flyable")
                .addStatement("this.flyable = flyable")
                .build();

        Method[] methods = inf.getDeclaredMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())
                    .addStatement("long start = $T.currentTimeMillis()", System.class)
                    .addCode("\n")
                    .addStatement("this.flyable." + method.getName() + "()")
                    .addCode("\n")
                    .addStatement("long end = $T.currentTimeMillis()", System.class)
                    .addStatement("$T.out.println(\"Fly time = \" +(end -start))", System.class)
                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile.builder("com.huang.proxy", typeSpecBuilder.build()).build();
        String sourcePath = "C:\\Users\\magic-h\\Desktop\\";
        javaFile.writeTo(new File(sourcePath));
        // 生成java文件之后 编译
        JavaCompiler.complie(new File(sourcePath+"com\\huang\\proxy\\TimeProxy.java"));
        // 加载到内存中并创建对象
        URL[] urls = {new URL("file:/" + sourcePath)};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class<?> aClass = urlClassLoader.loadClass("com.huang.proxy.TimeProxy");
        Constructor<?> constructor = aClass.getConstructor(Flyable.class);
        Flyable flyable = (Flyable) constructor.newInstance(new Bird());
        flyable.fly();
        return null;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

    }
}
