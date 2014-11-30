package org.alma.gl.command

import org.alma.gl.Selection

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
