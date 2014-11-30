package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Paste(s: Selection) extends Command(s:Selection) {
    override def execute={
        this.selection.write(this.clipboard);
    }
}
