/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.vklib.api.objects;

import java.io.Serializable;
import org.vklib.api.ObjectType;

/**
 *
 * @author maximusfk
 */
public interface IVKObject extends Serializable {
	ObjectType getType();
}
