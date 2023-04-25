package filterutility;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class FilterUtility{
	
	private class Filter {
		String attribute;
		String filter;
		String value;
	}
	
	public <T> List<T> filter(List<T> listToFilter, List<String> filterStrings) {	
		Class<?> listClass = listToFilter.get(0).getClass();
		List<T> filteredList = new ArrayList<T>();
		
		for(String filterString : filterStrings) {
			Filter filter = parseFilterString(filterString, listClass);
			Method getAttributeMethod = getMethodFromClass("get" + filter.attribute, listClass);

			for(T obj : listToFilter) {
				Object getMethodReturnValue = null;
				try {
					getMethodReturnValue = getAttributeMethod.invoke(obj);
				} catch(IllegalArgumentException | IllegalAccessException | InvocationTargetException err) {
					System.err.println("Couldn't invoke function " + getAttributeMethod.getName() + ". Error: " + err.getMessage());
				}
				if(getMethodReturnValue.toString().equals(filter.value)) {
					filteredList.add(obj);
				}
			}
		}
		
		System.out.println(filteredList);
		
		return filteredList;
	}
	
	private Method getMethodFromClass(String methodName, Class<?> listClass) {
		Method classMethod = null;
		try {
			classMethod = listClass.getMethod(methodName);
		} catch(NoSuchMethodException err) {
			System.err.println("Method " + methodName + " could not be found. Error: " + err.getMessage());
			return null;
		}
		return classMethod;
	}
	
	private Filter parseFilterString(String filterString, Class<?> filterClass) {
		Filter filter = new Filter();
		String fieldName = filterString.substring(0, filterString.indexOf(":"));
		filter.attribute = "";
		filter.attribute += fieldName.charAt(0);
		filter.attribute = filter.attribute.toUpperCase();
		filter.attribute += fieldName.substring(1);
		filter.filter = filterString.substring(filterString.indexOf(":") + 1, filterString.lastIndexOf(":"));
		filter.value = filterString.substring(filterString.lastIndexOf(":") + 1);
		return filter;
	}
}
