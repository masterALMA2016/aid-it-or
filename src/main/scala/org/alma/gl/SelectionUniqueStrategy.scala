package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class SelectionUniqueStrategy(ws:Workspace, cursor: Int) extends Selection {
    
    verifySelection()
    buffer = ws

    override def delete(): Unit = {
        verifySelection()

        if (start > 0 && ws.getContent().length() > 1) {
            ws.setContent(ws.getContent().substring(0, start-1) + ws.getContent().substring(end))
        }
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