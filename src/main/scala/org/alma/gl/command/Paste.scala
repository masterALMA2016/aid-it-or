package org.alma.gl.command

import org.alma.gl.{SelectionMultipleStrategy, Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Paste(s: Selection) extends Command(s) {
    override def execute(clipboard:Clipboard): Clipboard={
        this.selection.write(clipboard)
        clipboard
    }

    override def undo(c: Clipboard, selectContent:String): Unit = {
        val clip:Clipboard = new Clipboard(selectContent)
        val newSelection:Selection = new SelectionMultipleStrategy(selection.getWorkspace, selection.getStart, selection.getStart+c.getContent().size)

        newSelection.write(clip)
    }
}
