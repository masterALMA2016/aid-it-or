package org.alma.gl.command

import org.alma.gl.{SelectionMultipleStrategy, SelectionUniqueStrategy, Invoker, Workspace}
import org.junit.{Assert, Test, Before}

/**
 * Created on 04/12/14.
 *
 * @author dralagen, thecreator
 */
class DeleteTest {

  var workspace:Workspace = null

  @Before
  def setUp(): Unit = {
    workspace = new Workspace()

    workspace.setContent("Cou World!")

  }

  @Test
  def executeSelectionUniqueTest(): Unit = {
    Invoker.invokeCommand(
      new Delete(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Assert.assertEquals("Delete content with selection unique", "Co World!", workspace.getContent())
  }

  @Test
  def executeSelectionMultipleTest(): Unit = {

    Invoker.invokeCommand(
      new Delete(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Delete content with selection multiple", " World!", workspace.getContent())

  }

  @Test
  def undoSelectionUniqueTest(): Unit = {
    Invoker.invokeCommand(
      new Delete(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Invoker.undo()

    Assert.assertEquals("Undo Delete with selection unique", "Cou World!", workspace.getContent())


  }

  @Test
  def undoSelectionMultipleTest(): Unit = {
    Invoker.invokeCommand(
      new Delete(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Invoker.undo()

    Assert.assertEquals("Undo Delete with selection multiple", "Cou World!", workspace.getContent())

  }


}
