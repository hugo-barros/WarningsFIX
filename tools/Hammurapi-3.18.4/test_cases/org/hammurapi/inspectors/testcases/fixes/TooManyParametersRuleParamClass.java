/*
 * Hammurapi
 * Automated Java code review system. 
 * Copyright (C) 2004  Hammurapi Group
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 *  (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 * URL: http://www.hammurapi.org
 * e-Mail: support@hammurapi.biz

*/
package org.hammurapi.inspectors.testcases.fixes;

/**
 * TooManyParametersRule
 * @author  Pavel Vlasov
 * @version $Revision: 1.1 $
 */
public class TooManyParametersRuleParamClass {

	private static org.apache.log4j.Logger logger =
		org.apache.log4j.Logger.getRootLogger();

	private String name;
	private int amount;
	private int price;
	private boolean available;
	private java.util.Date dateOfOrder;
	private java.util.Date dateOfDelivery;

	/** Java doc automaticaly generated by Hammurapi */
	public boolean isAvailable() {
		return available;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public java.util.Date getDateOfDelivery() {
		return dateOfDelivery;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public java.util.Date getDateOfOrder() {
		return dateOfOrder;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public String getName() {
		return name;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public int getPrice() {
		return price;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public void setAvailable(final boolean newVal) {
		available = newVal;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public void setDateOfDelivery(final java.util.Date newVal) {
		dateOfDelivery = newVal;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public void setDateOfOrder(final java.util.Date newVal) {
		dateOfOrder = newVal;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public void setName(final String newVal) {
		name = newVal;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public void setPrice(final int newVal) {
		price = newVal;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public int getAmount() {
		return amount;
	}

	/** Java doc automaticaly generated by Hammurapi */
	public void setAmount(final int newVal) {
		amount = newVal;
	}

}

