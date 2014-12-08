package org.alma.gl.command

import org.alma.gl.{SelectionMultipleStrategy, SelectionUniqueStrategy, Invoker, Workspace}
import org.junit.{Assert, Test, Before}

/**
 * Created on 04/12/14.
 *
 * @author dralagen, thecreator
 */
class PasteTest {

  var workspace:Workspace = null

  @Before
  def setUp(): Unit = {
    workspace = new Workspace()

    workspace.setContent("Cou World!")

    // Create a clipboard with 'World'
    Invoker.invokeCommand(
      new Copy(
        new SelectionMultipleStrategy(workspace, 4, 9)
      )
    )

  }

  @Test
  def executeSelectionUniqueTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Paste(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Assert.assertEquals("Paste content with selection unique", "CouWorld World!", workspace.getContent())
    Assert.assertEquals("Paste not modified content into clipboard", "World", Invoker.getContentClipboard)

  }

  @Test
  def executeSelectionMultipleTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Paste(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Paste content with selection multiple", "World World!", workspace.getContent())
    Assert.assertEquals("Paste not modified content into clipboard", "World", Invoker.getContentClipboard)

  }

  @Test
  def undoSelectionUniqueTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Paste(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Assert.assertEquals("Paste content with selection unique", "CouWorld World!", workspace.getContent())
    Assert.assertEquals("Paste not modified content into clipboard", "World", Invoker.getContentClipboard)

    Invoker.undo()

    Assert.assertEquals("Undo Paste with selection unique", "Cou World!", workspace.getContent())
    Assert.assertEquals("Paste not modified content into clipboard", "World", Invoker.getContentClipboard)

  }

  @Test
  def undoSelectionMultipleTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Paste(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Paste content with selection multiple", "World World!", workspace.getContent())
    Assert.assertEquals("Paste not modified content into clipboard", "World", Invoker.getContentClipboard)

    Invoker.undo()

    Assert.assertEquals("Undo Paste with selection multiple", "Cou World!", workspace.getContent())
    Assert.assertEquals("Paste not modified content into clipboard", "World", Invoker.getContentClipboard)

  }

}
