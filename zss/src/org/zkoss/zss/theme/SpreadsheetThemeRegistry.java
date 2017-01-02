/* SpreadsheetThemeRegistry.java

	Purpose:
		
	Description:
		
	History:
		Thu, Jun 26, 2014 12:59:02 PM, Created by RaymondChao

Copyright (C) 2014 Potix Corporation. All Rights Reserved.

*/
package org.zkoss.zss.theme;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.zkoss.web.theme.Theme;

/**
 * 
 * @author RaymondChao
 * @since 3.5.0
 */
public class SpreadsheetThemeRegistry implements org.zkoss.web.theme.ThemeRegistry {

	// a mapping from theme name to Theme
	private Map<String, Theme> 
		_registry = new HashMap<String, Theme>();
	
	/**
	 * Initialize the registry with the default theme (a.k.a Breeze).
	 * 
	 */
	public SpreadsheetThemeRegistry() {
		register(new SpreadsheetStandardTheme());
	}

	/**
	 * Register a desktop theme.
	 * 
	 * @param theme an instance of StandardTheme
	 * @return true if registration is successful; false if failed
	 */
	public boolean register(Theme theme) {
		_registry.put(theme.getName(), theme);
		return true;
	}
	
	/**
	 * Remove a theme from the list of available desktop themes
	 * @param theme the theme to be removed
	 * @return true if the theme is successfully removed; false if failed
	 */
	public boolean deregister(Theme theme) {
		return (_registry.remove(theme.getName()) != null);
	}

	/**
	 * Returns a list of currently registered desktop themes
	 * @return the list of currently registered desktop themes
	 */
	public Theme[] getThemes() {
		Collection<Theme> themes = _registry.values();		
		return themes.toArray(new Theme[themes.size()]);		
	}

	/**
	 * Check if a dekstop theme with the given name is available to use
	 * @return true if theme is found; false otherwise
	 */
	public boolean hasTheme(String themeName) {		
		return _registry.containsKey(themeName);
	}
	
	/**
	 * Returns the desktop theme with the given name
	 * @param themeName theme name
	 * @return an instance of Theme with the given name 
	 * or null if the registry does not have a theme that goes by that name
	 */
	public Theme getTheme(String themeName) {
		return _registry.get(themeName);
	}
}
