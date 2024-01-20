package listener;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import utility.Utility;

public class RetryListener implements IAnnotationTransformer {
	@Override
	public void transform (final ITestAnnotation annotation, final Class testClass, final Constructor testConstructor,
	final Method testMethod) {
//		System.out.println(testMethod.getName());
		String[] testGroups = annotation.getGroups();
		//getting the flaky test group name from configuration file
		String flakyTestGroupName = Utility.getConfigurationProperty("flaky_test_group_name") ;

		for (String groupName : testGroups) {
			if (flakyTestGroupName.equalsIgnoreCase(groupName)) {
				annotation.setRetryAnalyzer(TestRetrier.class);
			}
		}
	}
}
