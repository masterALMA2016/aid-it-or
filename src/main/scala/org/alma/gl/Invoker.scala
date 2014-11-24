package org.alma.gl

import java.util.List

/**
 * Created on 24/11/14.
 *
 * @author dralagen
 */
class Invoker {
  private var history: List[Command] = null
  private var clipboard: Clipboard = null
  private var selection: Selection = null
}