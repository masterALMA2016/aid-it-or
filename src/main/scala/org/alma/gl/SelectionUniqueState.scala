package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class SelectionUniqueState(ws:Workspace, cursor: Int) extends Selection {
    
    start = cursor
    end = cursor
    buffer = ws
}