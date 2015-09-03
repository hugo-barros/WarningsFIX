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

import org.hammurapi.inspectors.testcases.HammurapiTestCasesException;

/**
 * ForLoopControlVariablesRule
 * @author  Pavel Vlasov
 * @version $Revision: 1.2 $
 */
public class ForLoopControlVariablesRuleFixTestCase {

	private static org.apache.log4j.Logger logger =
		org.apache.log4j.Logger.getRootLogger();

	/** Java doc automaticaly generated by Hammurapi */
	public void searchObj(final java.util.Iterator iter, final Object anObj)
		throws HammurapiTestCasesException {
		if (iter.hasNext()) {

			// --- FIX ---
			for (Object obj = iter.next(); iter.hasNext(); obj = iter.next()) {
				if (obj.equals(anObj)) {
					throw new HammurapiTestCasesException(obj.toString());
				}
			}
			// --- END FIX ---
			
			for (int i=9, j=100; i<j; i++, j-=i) {
				int z=j*i;
			}
			
			int i=300;
			String gga;
			for (i=28, gga="Internationalization"; i>gga.length(); i--, gga+="X") {
				String gogo=gga.substring(gga.length()-5);
			}

		}
	}
}

