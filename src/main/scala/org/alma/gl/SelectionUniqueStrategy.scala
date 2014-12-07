package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class SelectionUniqueStrategy(ws:Workspace, cursor: Int) extends Selection {
    
    verifySelection()
    buffer = ws

    override def delete(): String = {
        verifySelection()

        if (start > 0 && ws.getContent().length() > 1) {
            val deleteText:String = ws.getContent().substring(start-1, end)
            ws.setContent(ws.getContent().substring(0, start-1) + ws.getContent().substring(end))
            return deleteText
        }
        ""
    }

    override def read(): Clipboard = {
        new Clipboard("")
    }

    override def cut(): Clipboard = {
        read()
    }

    override def verifySelection(): Unit = {
        start = {
            if (cursor < 0) {
                0
            } else if (cursor > ws.getContent().length()) {
                ws.getContent().length()
            } else {
                cursor
            }
        }
        end = start
    }
}