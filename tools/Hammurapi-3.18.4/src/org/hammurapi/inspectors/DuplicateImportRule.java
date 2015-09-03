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

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.hammurapi.InspectorBase;

import com.pavelvlasov.jsel.CompilationUnit;
import com.pavelvlasov.jsel.Identifier;
import com.pavelvlasov.jsel.JselException;
import com.pavelvlasov.review.SourceMarker;

/**
 * Duplicate import declaration
 * @author  Pavel Vlasov
 * @version $Revision: 1.2 $
 */
public class DuplicateImportRule extends InspectorBase {
    
    /**
     * Reviews the compilation unit (Java source file) for duplicated import
     * statements.
     * 
     * @param compilationUnit the unit to be reviewed.
     * @throws JselException error by parsing the unit.
     */
    public void visit(CompilationUnit compilationUnit) throws JselException {
    	Set imports=new HashSet();
    	Iterator it=compilationUnit.getImports().iterator();
    	while (it.hasNext()) {
    		Identifier id=(Identifier) it.next();
    		if (!imports.add(id.getValue())) {
    			context.reportViolation((SourceMarker) id);
    		}
    	}
    }       
}
