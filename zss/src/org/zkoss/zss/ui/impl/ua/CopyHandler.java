/* CopyHandler.java

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		2013/8/3 , Created by dennis
}}IS_NOTE

Copyright (C) 2013 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zss.ui.impl.ua;

import org.zkoss.zss.api.AreaRef;
import org.zkoss.zss.api.model.Sheet;
import org.zkoss.zss.ui.UserActionContext;

public class CopyHandler extends AbstractSheetHandler {
	private static final long serialVersionUID = 8610772934248693485L;

	@Override
	protected boolean processAction(UserActionContext ctx) {
		Sheet sheet = ctx.getSheet();
		AreaRef selection = ctx.getSelection();
		ctx.setClipboard(sheet,selection,false,null);
		return true;
	}

}
