/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api;

import java.util.ArrayList;

/**
 *
 * @author maximusfk
 */
public class VKApi {
	public static final String METHOD_ADDR = "https://api.vk.com/method/";
	public static final String ACCESS_TOCKEN = "access_token";
	public static final String APIVER = "v";
	public static final String CURRENT_VKAPIVER = "5.56";
	
	public static final Method users_get = (new MethodBuilder("users.get")).addParameter("user_ids").addParameter("fields").build();
	
	
	
	static final class Method {
		String call_method_addres;
		String name;
		ArrayList <String> parameters;
		
		Method(String methodname) {
			name = methodname;
		}
                
        public class Parameter {
                    
        }
	}
	static class MethodBuilder {
		Method method;
			
		public MethodBuilder(String name) {
			method = new Method(name);
			method.call_method_addres = METHOD_ADDR;
		}
			
		public MethodBuilder addParameter(String name) {
			method.parameters.add(name);
			return this;
		}
		
		public Method build() {
			return method;
		}
	}
}
