package resources;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

//object is going to be "timeBean"
@Named(value = "timeBean")
//@ManagedBean(name = "myBean")
@RequestScoped
//property would be "time" taking from the method name without the get
public class TimeBean {
	public String getTime() {
		return new Date().toString();
	}
}
