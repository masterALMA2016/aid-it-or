package org.alma.gl.command

import org.alma.gl.{SelectionUniqueStrategy, SelectionMultipleStrategy, Invoker, Workspace}
import org.junit.{Assert, Test, Before}

/**
 * Created on 04/12/14.
 *
 * @author dralagen, thecreator
 */
class CutTest {

  var workspace:Workspace = null

  @Before
  def setUp(): Unit = {
    workspace = new Workspace()

    workspace.setContent("Cou World!")

  }

  @Test
  def executeSelectionUniqueTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Cut(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Assert.assertEquals("Cut content with selection unique", "Cou World!", workspace.getContent())
    Assert.assertEquals("Cut add content into clipboard", "", Invoker.getContentClipboard)
  }

  @Test
  def executeSelectionMultipleTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Cut content with selection multiple", " World!", workspace.getContent())
    Assert.assertEquals("Cut add content into clipboard", "Cou", Invoker.getContentClipboard)

    Invoker.invokeCommand(
      new Cut(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Assert.assertEquals("Cut content with selection unique", " World!", workspace.getContent())
    Assert.assertEquals("Cut add content into clipboard", "", Invoker.getContentClipboard)
  }

  @Test
  def executeSelectionMultipleAndUnique():Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Cut content with selection multiple", " World!", workspace.getContent())
    Assert.assertEquals("Cut add content into clipboard", "Cou", Invoker.getContentClipboard)



  }

  @Test
  def doubleExecuteSelectionMultiple():Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Assert.assertEquals("Cut content with selection multiple", " World!", workspace.getContent())
    Assert.assertEquals("Cut add content into clipboard", "Cou", Invoker.getContentClipboard)

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 1, 6)
      )
    )

    Assert.assertEquals("Cut content with selection multiple", " !", workspace.getContent())
    Assert.assertEquals("Cut add content into clipboard", "World", Invoker.getContentClipboard)
  }

  @Test
  def undoSelectionUniqueTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Invoker.invokeCommand(
      new Cut(
        new SelectionUniqueStrategy(workspace, 3)
      )
    )

    Invoker.undo()

    Assert.assertEquals("Undo Cut with selection unique", " World!", workspace.getContent())
    Assert.assertEquals("Cut undo content into clipboard", "Cou", Invoker.getContentClipboard)


  }

  @Test
  def undoSelectionMultipleTest(): Unit = {

    Assert.assertEquals("Init workspace", "Cou World!", workspace.getContent())

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Invoker.invokeCommand(
      new Cut(
        new SelectionMultipleStrategy(workspace, 0, 3)
      )
    )

    Invoker.undo()

    Assert.assertEquals("Undo Cut with selection multiple", " World!", workspace.getContent())
    Assert.assertEquals("Cut undo content into clipboard", "Cou", Invoker.getContentClipboard)

  }

}
