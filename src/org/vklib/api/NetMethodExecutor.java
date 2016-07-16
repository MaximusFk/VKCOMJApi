/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api;

import java.util.Queue;
import org.vklib.api.VKApi.Method;

/**
 *
 * @author maximusfk
 */
public class NetMethodExecutor {
	Method currentMethod;
	Queue<Method> queue;
}
