/**
 * 
 */
package com.sahaj.rules;

import com.sahaj.model.Floor;

/**
 * Represents the rules to satisfy a condition.
 * 
 *
 */
public interface Rules {

	/**
	 * method to determine if all the Rules {@link Floor} is met or not.
	 * 
	 * @param floor
	 * @return True or false.
	 */
	boolean isRulesApplicable(Floor floor);

}
