package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Write(s: Selection, text: String) extends Command(s:Selection) {
    override def execute={
        clipboard = new Clipboard(text)
        selection.write(clipboard)
    }
}
