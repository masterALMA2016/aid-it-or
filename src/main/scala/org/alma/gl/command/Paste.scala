package org.alma.gl.command

import org.alma.gl.{SelectionUniqueStrategy, SelectionMultipleStrategy, Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Paste(s: Selection) extends Command(s) {
    override def execute(clipboard:Clipboard): Clipboard={
        if (clipboard != null) {
            selection.write(clipboard)
        } else {
            selection.write(new Clipboard(""))
        }

        clipboard
    }

    override def undo(c: Clipboard, selectContent:String): Unit = {
        val clip:Clipboard = new Clipboard(selectContent)
        var newSelection:Selection = null
        if (c == null) {
            newSelection = new SelectionUniqueStrategy(selection.getWorkspace, selection.getStart)
        }
        else {
            newSelection = new SelectionMultipleStrategy(selection.getWorkspace, selection.getStart, selection.getStart + c.getContent().size)
        }
        newSelection.write(clip)
    }
}
