package org.alma.gl.command

import org.alma.gl.{SelectionMultipleState, Clipboard, Selection}

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Write(s: Selection, t: String) extends Command(s) {
    val text:String = t

    override def execute(clipboard:Clipboard):Clipboard={
        selection.write(new Clipboard(this.text))
        clipboard
    }

    override def undo(c: Clipboard, selectContent:String): Unit = {
        val clip:Clipboard = new Clipboard(selectContent)
        val newSelection:Selection = new SelectionMultipleState(selection.getWorkspace, selection.getStart, selection.getStart+t.size)

        newSelection.write(clip)
    }
}
