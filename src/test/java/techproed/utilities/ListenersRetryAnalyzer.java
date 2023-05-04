package techproed.utilities;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.IAnnotation;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersRetryAnalyzer implements IAnnotationTransformer {

    // Bu ListenersRetry classı XML dosyasıyla test sınıflarıyla ilişkilendirilemediği için oluşturuldu
    // Bu class ile ListenersRetry classını XML dosyasıyl ilişkiledirebileceğiz
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod){

            annotation.setRetryAnalyzer(ListenersRetry.class);



    }
}
