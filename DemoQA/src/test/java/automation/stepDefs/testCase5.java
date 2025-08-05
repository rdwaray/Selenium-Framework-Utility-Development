package automation.stepDefs;

import automation.utils.driverFactory;
import automation.utils.utilities;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import automation.utils.driverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class testCase5 {

    private static final Logger log = LoggerFactory.getLogger(testCase5.class);
    private WebDriverWait wait = driverFactory.getWait();

    private WebDriver driver = driverFactory.getDriver();

    @Then("I go to Interaction test page")
    public void iGoToInteractionTestPage() {
        By widgetTest = By.xpath("//h5[normalize-space()='Interactions']");
        utilities.safeClick(driver, widgetTest);
    }

    @Given("I go to Sortable test page")
    public void iGoToSortableTestPage() {
        By widgetTest = By.xpath("//span[normalize-space()='Sortable']");
        utilities.safeClick(driver, widgetTest);

    }

    @Then("I change the order of list")
    public void iChangeTheOrderOfList() {

        WebElement source = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='One']"));
        WebElement target1 = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='Two']"));
        WebElement target2 = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='Three']"));
        WebElement target3 = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='Four']"));
        WebElement target4 = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='Five']"));
        WebElement target5 = driver.findElement(By.xpath("//div[@class='vertical-list-container mt-4']//div[@class='list-group-item list-group-item-action'][normalize-space()='Six']"));
        utilities.dragAndDrop(driver, source,target5);
        utilities.dragAndDrop(driver, target2,target3);
        utilities.dragAndDrop(driver, target4,target1);
    }

    @When("I go to Grid test")
    public void iGoToGridTest() {
        By gridTest = By.id("demo-tab-grid");
        utilities.safeClick(driver,gridTest);
    }

    @Then("I change the order of grid")
    public void iChangeTheOrderOfGrid() {
        utilities.loading(499);
        WebElement grid1 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[1]"));
        WebElement grid2 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[2]"));
        WebElement grid3 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[3]"));
        WebElement grid4 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[4]"));
        WebElement grid5 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[5]"));
        WebElement grid6 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[6]"));
        WebElement grid7 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[7]"));
        WebElement grid8 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[8]"));
        WebElement grid9 = driver.findElement(By.xpath("//*[@id=\"demo-tabpane-grid\"]/div/div/div[9]"));

        utilities.dragAndDrop(driver,grid1,grid9);
        utilities.dragAndDrop(driver,grid2,grid4);
        utilities.dragAndDrop(driver,grid3,grid6);
        utilities.dragAndDrop(driver,grid7,grid8);
        utilities.dragAndDrop(driver,grid5,grid9);

    }

    @Given("I go to Selectable test page")
    public void iGoToSelectableTestPage() {
        By widgetTest = By.xpath("//span[normalize-space()='Selectable']");
        utilities.safeClick(driver, widgetTest);
    }

    @Then("I click the order of list")
    public void iClickTheOrderOfList() {
        List<By> mutipleList = Arrays.asList(
                By.xpath("//li[normalize-space()='Cras justo odio']"),
                By.xpath("//li[normalize-space()='Dapibus ac facilisis in']"),
                By.xpath("//li[normalize-space()='Morbi leo risus']"),
                By.xpath("//li[normalize-space()='Porta ac consectetur ac']")
        );
        utilities.clickMultipleElements(driver,mutipleList);
    }

    @When("I go to Grid click test")
    public void iGoToGridClickTest() {
        By gridTest = By.id("demo-tab-grid");
        utilities.safeClick(driver,gridTest);
    }

    @Then("I click the order of grid")
    public void iClickTheOrderOfGrid() {
        List<By> mutipleGrid = Arrays.asList(
                By.xpath("//li[normalize-space()='One']"),
                By.xpath("//li[normalize-space()='Two']"),
                By.xpath("//li[normalize-space()='Three']"),
                By.xpath("//li[normalize-space()='Four']"),
                By.xpath("//li[normalize-space()='Five']"),
                By.xpath("//li[normalize-space()='Six']"),
                By.xpath("//li[normalize-space()='Seven']"),
                By.xpath("//li[normalize-space()='Eight']"),
                By.xpath("//li[normalize-space()='Nine']")
                );
        utilities.clickMultipleElements(driver,mutipleGrid);
    }

    @Given("I go to resize test page")
    public void iGoToResizeTestPage() {
        By widgetTest = By.xpath("//span[normalize-space()='Resizable']");
        utilities.safeClick(driver, widgetTest);
    }

    @Then("I resize element one")
    public void iResizeElementOne() {
        utilities.loading(1000);
        By place1 = By.cssSelector("#resizableBoxWithRestriction .react-resizable-handle-se");
        utilities.findElement(driver,place1,"center");
        WebElement box1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#resizableBoxWithRestriction .react-resizable-handle-se")));
        Actions action = new Actions(driver);
        action.clickAndHold(box1)
                .moveByOffset(250, 250)
                .release()
                .perform();
    }

    @And("I resize element two")
    public void iResizeElementTwo() {
        utilities.loading(1000);
        By place2 = By.cssSelector("#resizable .react-resizable-handle-se");
        utilities.findElement(driver,place2,"center");
        WebElement box2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#resizable .react-resizable-handle-se")));
        Actions action = new Actions(driver);
        action.clickAndHold(box2)
                .moveByOffset(300, 300)
                .release()
                .perform();
    }

    @Given("I am on droppable test Page")
    public void iAmOnDroppableTestPage() {
        By widgetTest = By.xpath("//span[normalize-space()='Droppable']");
        utilities.findElement(driver,widgetTest,"center");
        utilities.safeClick(driver, widgetTest);
    }

    @And("I do Simple drop")
    public void iDoSimpleDrop() {
        By dropElement = By.id("draggable");
        utilities.findElement(driver,dropElement,"center");
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("droppable")));
        WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("draggable")));

        utilities.loading(1000);
        utilities.dragAndDrop(driver,drop,target);
    }

    @Then("I do Accept drop")
    public void iDoAcceptDrop() {
        By acceptTab = By.id("droppableExample-tab-accept");
        utilities.safeClick(driver,acceptTab);
        utilities.loading(500);
        By dropElement = By.id("acceptable");
        utilities.findElement(driver,dropElement,"center");

        WebElement drop1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notAcceptable")));
        WebElement drop2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("acceptable")));
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#acceptDropContainer #droppable")
        ));
        utilities.dragAndDrop(driver,drop1,target);
        utilities.loading(500);
        utilities.dragAndDrop(driver,drop2,target);
    }

    @And("I do Prevent drop")
    public void iDoPreventDrop() {

        By preventTab = By.id("droppableExample-tab-preventPropogation");
        utilities.safeClick(driver,preventTab);
        utilities.loading(500);
        By dropElement = By.id("greedyDropBoxInner");
        utilities.findElement(driver,dropElement,"center");

        WebElement drop = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dragBox")));
        WebElement targeta1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notGreedyDropBox")));
        WebElement targeta2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notGreedyInnerDropBox")));
        WebElement targetb1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("greedyDropBox")));
        WebElement targetb2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("greedyDropBoxInner")));



//        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.cssSelector("#acceptDropContainer #droppable")
//        ));
        utilities.dragAndDrop(driver,drop,targeta1);
        utilities.loading(500);
        utilities.dragAndDrop(driver,drop,targeta2);
        utilities.loading(500);
        utilities.dragAndDrop(driver,drop,targetb1);
        utilities.loading(500);
        utilities.dragAndDrop(driver,drop,targetb2);
    }

    @Then("I do Revert drop")
    public void iDoRevertDrop() {
        By revertTab = By.id("droppableExample-tab-revertable");
        utilities.safeClick(driver,revertTab);
        utilities.loading(500);
        By dropElement = By.id("notRevertable");
        utilities.findElement(driver,dropElement,"center");

        WebElement drop1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("notRevertable")));
        WebElement drop2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("revertable")));
        WebElement target = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@id='revertableDropContainer']//div[@id='droppable']")
        ));
        utilities.dragAndDrop(driver,drop1,target);
        utilities.loading(500);
        utilities.dragAndDrop(driver,drop2,target);

    }

    @Given("I am on Dragabble test page")
    public void iAmOnDragabbleTestPage() {

        By dragabbleTest = By.xpath("//span[normalize-space()='Dragabble']");
        utilities.findElement(driver,dragabbleTest,"center");
        utilities.safeClick(driver, dragabbleTest);
    }

    @Then("I drag simple element")
    public void iDragSimpleElement() {
        WebElement draggable = driver.findElement(By.id("dragBox"));
        new Actions(driver)
                .clickAndHold(draggable)
                .moveByOffset(  120, 90)
                .release()
                .perform();
    }

    @And("I drag axes retristed element")
    public void iDragAxesRetristedElement() {

        By restrictedTab = By.id("draggableExample-tab-axisRestriction");
        utilities.safeClick(driver,restrictedTab);
        utilities.loading(500);

        WebElement draggablex = driver.findElement(By.id("restrictedX"));
        new Actions(driver)
                .clickAndHold(draggablex)
                .moveByOffset(  100, 1)
                .release()
                .perform();

        WebElement draggabley = driver.findElement(By.id("restrictedY"));
        new Actions(driver)
                .clickAndHold(draggabley)
                .moveByOffset(  1, 100)
                .release()
                .perform();
    }

    @And("I drag container retristed element")
    public void iDragContainerRetristedElement() {

        By containerTab = By.id("draggableExample-tab-containerRestriction");
        utilities.safeClick(driver,containerTab);
        utilities.loading(500);

        WebElement draggablex = driver.findElement(By.xpath("//div[@class='draggable ui-widget-content ui-draggable ui-draggable-handle']"));
        new Actions(driver)
                .clickAndHold(draggablex)
                .moveByOffset(  100, 1)
                .release()
                .perform();

        WebElement draggabley = driver.findElement(By.xpath("//*[@id=\"draggableExample-tabpane-containerRestriction\"]/div[2]/span"));
        new Actions(driver)
                .clickAndHold(draggabley)
                .moveByOffset(  70, 1)
                .release()
                .perform();


    }

    @And("I drag cursor style element")
    public void iDragCursorStyleElement() {
        By cursorTab = By.id("draggableExample-tab-cursorStyle");
        utilities.safeClick(driver,cursorTab);
        utilities.loading(500);

        WebElement draggablex = driver.findElement(By.id("cursorCenter"));
        new Actions(driver)
                .clickAndHold(draggablex)
                .moveByOffset(  100, 1)
                .release()
                .perform();

        WebElement draggabley = driver.findElement(By.id("cursorTopLeft"));
        new Actions(driver)
                .clickAndHold(draggabley)
                .moveByOffset(  1, 100)
                .release()
                .perform();
        By bottom = By.id("cursorBottom");
        utilities.findElement(driver,bottom, "center");
        WebElement draggablez = driver.findElement(By.id("cursorBottom"));
        new Actions(driver)
                .clickAndHold(draggablez)
                .moveByOffset(  100, 100)
                .release()
                .perform();


            }
}
