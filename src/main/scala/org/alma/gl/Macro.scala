package org.alma.gl

import java.util.List

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Macro(s:Selection) extends Command(s:Selection) {
  var commands: List[Command] = null
}