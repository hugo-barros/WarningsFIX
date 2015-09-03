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

import java.util.Iterator;

import org.hammurapi.InspectorBase;

import com.pavelvlasov.jsel.statements.CasesGroup;
import com.pavelvlasov.jsel.statements.DefaultCase;
import com.pavelvlasov.jsel.statements.Statement;
import com.pavelvlasov.jsel.statements.SwitchStatement;
import com.pavelvlasov.review.SourceMarker;

/**
 *
 * @author  Pavel Vlasov
 * @version $Revision: 1.2 $
 */
public class SwitchDefaultRule extends InspectorBase {
    
    /**
     * Reviews the switch statement.
     * 
     * @param statement the statement to review.
     */
    public void visit(SwitchStatement statement) {
    	Iterator it=statement.getCasesGroups().iterator();
    	while (it.hasNext()) {
    		CasesGroup group = (CasesGroup) it.next();
			Iterator cit=(group).getCases().iterator();
    		while (cit.hasNext()) {
    			if (cit.next() instanceof DefaultCase) {
    				Iterator sit=group.getStatements().iterator();
    				while (sit.hasNext()) {
    					if (!isEmpty((Statement) sit.next())) {
    						return;
    					}
    				}
    				context.reportViolation((SourceMarker) statement, "Default case is present but empty");
    				return;
    			}
    		}
    	}
    	context.reportViolation((SourceMarker) statement);
    }
}
