package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class SelectionUniqueStrategy(ws:Workspace, cursor: Int) extends Selection {
    
    start = {
        if (cursor > ws.getContent().length()) {
            ws.getContent().length()
        } else {
            cursor
        }
    }
    end = start
    buffer = ws

    override def delete(): String = {
        if (start > 0 && ws.getContent().length() > 1) {
            start -= 1
            val deleteText:String = getContent
            write(new Clipboard(""))
            start += 1
            return deleteText
        }
        ""
    }

    override def read: Clipboard = {
        new Clipboard("")
    }

    override def cut(): Clipboard = {
        read
    }
}