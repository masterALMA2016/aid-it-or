package org.alma.gl.command

import org.alma.gl.{SelectionUniqueStrategy, Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen, thecreator
 */
class Cut(s: Selection) extends Command(s) {
    override def execute(clipboard:Clipboard):Clipboard = {
        selection.cut()
    }

    override def undo(c: Clipboard, selectContent: String): Unit = {
        val newSelect:Selection = new SelectionUniqueStrategy(selection.getWorkspace, selection.getStart)
        newSelect.write(new Clipboard(selectContent))
    }
}
