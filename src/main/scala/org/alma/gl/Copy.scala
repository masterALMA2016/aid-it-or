package org.alma.gl

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Copy(s: Selection) extends Command(s:Selection) {
    override def execute = {
        //this.clipboard = this.selection.read()
    }
}
