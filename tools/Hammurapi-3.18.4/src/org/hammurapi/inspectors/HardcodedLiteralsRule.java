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
package org.hammurapi.inspectors;

import org.hammurapi.InspectorBase;

import com.pavelvlasov.jsel.LanguageElement;
import com.pavelvlasov.jsel.VariableDefinition;


/**
 * ER-010
 * Avoid hardwired character literals. 
 * Usage of literals in static final fields is allowed.
 * @author  Pavel Vlasov
 * @version $Revision: 1.3 $
 */
public class HardcodedLiteralsRule extends InspectorBase  {
	
	private VariableDefinition currentStaticFinalField;

	public void visit(VariableDefinition vd) {
		if (currentStaticFinalField==null && vd.getModifiers().contains("static") && vd.getModifiers().contains("final")) {
			currentStaticFinalField = vd;
		}		
	}
	
	public void leave(VariableDefinition vd) {
		currentStaticFinalField=null;
	}
	
	protected void analyze(LanguageElement element) {
		if (currentStaticFinalField==null) {
			context.reportViolation(element);
		}
	}	
}
