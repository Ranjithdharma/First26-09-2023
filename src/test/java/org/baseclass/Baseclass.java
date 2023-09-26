package org.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Baseclass {
	
	

			public static WebDriver driver;

			public static void browserLaunch(String browser) {
				if (browser.equals("chrome")) {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
				} else if (browser.equals("edge")) {
					WebDriverManager.edgedriver().setup();
					driver = new EdgeDriver();
				} else if (browser.equals("firefox")) {
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
				} else {
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					System.out.println("Opening Chrome browser instead of " + browser);
				}
		
			}

			// URL
			public static void loadUrl(String url) {
				driver.get(url);
			}

			// Find WebElement
			public static WebElement findingElement(String locator, String value) {
				if (locator.equals("id")) {
					WebElement element = driver.findElement(By.id(value));
					return element;
				} else if (locator.equals("name")) {
					WebElement element = driver.findElement(By.name(value));
					return element;
				} else if (locator.equals("className")) {
					WebElement element = driver.findElement(By.className(value));
					return element;
				} else if (locator.equals("tagName")) {
					WebElement element = driver.findElement(By.tagName(value));
					return element;
				} else if (locator.equals("linkText")) {
					WebElement element = driver.findElement(By.linkText(value));
					return element;
				} else if (locator.equals("partialLinkText")) {
					WebElement element = driver.findElement(By.partialLinkText(value));
					return element;
				} else if (locator.equals("xpath")) {
					WebElement element = driver.findElement(By.xpath(value));
					return element;
				} else if (locator.equals("cssSelector")) {
					WebElement element = driver.findElement(By.cssSelector(value));
					return element;
				} else {
					System.out.println("Give a valid Locator");
					return null;
				}
			}

			// Send Keys
			public static void passValue(WebElement element, String value) {
				element.sendKeys(value);
			}

			// Click
			public static void clickIt(WebElement element) {
				element.click();
			}

			// Get Attribute Value
			public static String getAttributeValue(WebElement element, String attributeName) {
				String attributeValue = element.getAttribute(attributeName);
				return attributeValue;
			}

			// [Manage]
			// Maximize Window
			public static void maximizeWindow() {
				driver.manage().window().maximize();
			}

			// Resize Window
			public static void minimizeToSize(int length, int height) {
				Dimension targetSize = new Dimension(length, height);
				driver.manage().window().setSize(targetSize);
			}

			// Repositioning Window
			public static void windowPosition(int x, int y) {
				Point targetPosition = new Point(x, y);
				driver.manage().window().setPosition(targetPosition);
			}

			// [Navigation Commands]
			// Navigate url
			public static void navigateUrl(String url) {
				driver.navigate().to(url);
			}

			// Forward
			public static void nextPage() {
				driver.navigate().forward();
			}

			// Backward
			public static void previousPage() {
				driver.navigate().back();
			}

			// Refresh
			public static void reloadPage() {
				driver.navigate().refresh();
			}

			// [Javascript Executor]
			// Scroll page using Pixel
			public static void scrollPage(int x, int y) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(" + x + "," + y + ")");
			}

			// Scroll upto particular WebElement
			public static void scrollPageUpto(String upORdown, WebElement element) {
				if (upORdown.equals("up")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(true)", element);
				} else if (upORdown.equals("down")) {
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView(false)", element);
				}
			}

			// Actions
			public static void clickMousePointer(WebElement element) {
				Actions actions = new Actions(driver);
				actions.click(element).perform();
			}

			public static void doubleClickMousePointer(WebElement element) {
				Actions actions = new Actions(driver);
				actions.doubleClick(element).perform();
			}

			public static void rightClickMousePointer(WebElement element) {
				Actions actions = new Actions(driver);
				actions.contextClick(element).perform();
			}

			public static void moveToAnElement(WebElement element) {
				Actions actions = new Actions(driver);
				actions.moveToElement(element).perform();
			}

			public static void holdDragAndDrop(WebElement source, WebElement target) {
				Actions actions = new Actions(driver);
				actions.dragAndDrop(source, target).perform();
			}

			// [Frames]
			public static void switchFrameByIndex(int index) {
				driver.switchTo().frame(index);
			}

			public static void switchFrameByNameOrId(String value) {
				driver.switchTo().frame(value);
			}

			public static void switchFrameByWebElement(WebElement element) {
				driver.switchTo().frame(element);
			}

			public static void switchBackFrame() {
				driver.switchTo().defaultContent();
			}

			// [Alerts]
			public static void clickOk() {
				driver.switchTo().alert().accept();
			}

			public static void clickCancel() {
				driver.switchTo().alert().dismiss();
			}

			public static void sendTextAndClickOK(String value) throws InterruptedException {
				Alert promptAlert = driver.switchTo().alert();
				promptAlert.sendKeys(value);
				promptAlert.accept();
			}

			// [Robot Class]
			public static void contextOption(int optionNumber) throws AWTException {
				Robot robot = new Robot();
				for (int i = 0; i < optionNumber - 1; i++) {
					robot.keyPress(KeyEvent.VK_PAGE_DOWN);
					robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				}
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
			}

			public static void selectAll() throws AWTException {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_A);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}

			public static void cut() throws AWTException {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_X);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}

			public static void paste() throws AWTException {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
			}

			public static void tab() throws AWTException {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_TAB);
				robot.keyRelease(KeyEvent.VK_TAB);
			}

			// [Windows Handling]
			public static WebDriver switchWindow() {
				String parentWindow = driver.getWindowHandle();
				Set<String> allWindows = driver.getWindowHandles();
				for (String window : allWindows) {
					if (!window.equals(parentWindow)) {
						WebDriver newWindow = driver.switchTo().window(window);
						return newWindow;
					}
				}
				return null;
			}

			// [Web Table]
			// No.of Tables in a page
			public static void numberOfTables() {
				List<WebElement> allTables = driver.findElements(By.tagName("table"));
				System.out.println("Total Table in page:" + allTables.size());
			}

			// Accessing All data in a table
			public static void datasOfTable(WebElement elementOfTable) {
				List<WebElement> allData = elementOfTable.findElements(By.tagName("td"));
				int size = allData.size();
				System.out.println("No.of Data in a List:" + size);
				for (WebElement data : allData) {
					System.out.println(data.getText());
				}
			}

			// Accessing data in a row
			public static void datasOfRow(WebElement elementOfTable, int rowNumber) {
				List<WebElement> tableRows = elementOfTable.findElements(By.tagName("tr"));
				WebElement rowElement = tableRows.get(rowNumber);
				List<WebElement> rowData = rowElement.findElements(By.tagName("td"));
				System.out.println("Total Data in a Row:" + rowData.size());
				for (WebElement data : rowData) {
					System.out.println(data.getText());
				}
			}

			// [ScreenShot]
			public static void takeScreenShot(String targetlocation) throws IOException {
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File source = screenshot.getScreenshotAs(OutputType.FILE);
				File target = new File(targetlocation);
				FileHandler.copy(source, target);
				
			}

			// [Drop Down]
			// Single Select Dropdown
			public static void dropDownByIndex(WebElement elementOfSelect, int index) {
				Select select = new Select(elementOfSelect);
				select.selectByIndex(index);
			}

			public static void dropDownByVisibleText(WebElement elementOfSelect, String value) {
				Select select = new Select(elementOfSelect);
				select.selectByVisibleText(value);
			}

			public static void dropDownByValue(WebElement elementOfSelect, String value) {
				Select select = new Select(elementOfSelect);
				select.selectByValue(value);
			}

			// Multi Select
			// is Multiple?
			public static void multipleOrNot(WebElement elementOfSelect) {
				Select select = new Select(elementOfSelect);
				boolean multiple = select.isMultiple();
				System.out.println("Multiple: " + multiple);
			}

			// Select Two Options
			public static void multiSelectTwo(WebElement elementOfSelect, int index1, int index2) {
				Select select = new Select(elementOfSelect);
				select.selectByIndex(index1);
				select.selectByIndex(index2);
			}

			// Deselect
			public static void deSelectEntire(WebElement elementOfSelect) {
				Select select = new Select(elementOfSelect);
				select.deselectAll();
			}

			// [Data Driven]
			// Accessing Input Stream from a file
			public static FileInputStream accessFileStream(String filePath) throws FileNotFoundException {
				File file = new File(filePath);
				FileInputStream inputStream = new FileInputStream(file);
				return inputStream;
			}

			// Passing Output Stream to a file
			public static FileOutputStream outputStreamFile(String filePath) throws FileNotFoundException {
				File file = new File(filePath);
				FileOutputStream outputstream = new FileOutputStream(file);
				return outputstream;
			}

			// Access the workbook by InputStream
			public static Workbook accessWorkBook(String format, FileInputStream fileStream) throws IOException {
				if (format.equals("xlx")) {
					Workbook workbook = new HSSFWorkbook(fileStream);
					return workbook;
				} else if (format.equals("xlsx")) {
					Workbook workbook = new XSSFWorkbook(fileStream);
					return workbook;
				} else {
					System.out.println("Enter xlx or xlsx format");
					return null;
				}
			}

			// Access the sheet
			public static Sheet accessSheet(Workbook workbook, String sheetNumber) {
				Sheet sheet = workbook.getSheet(sheetNumber);
				return sheet;
			}

			// Accessing the Row
			public static Row accessRow(Sheet sheet, int rowNumber) {
				Row row = sheet.getRow(rowNumber);
				return row;
			}

			// Access the Cell
			public static Cell accessCell(Row row, int cellNumber) {
				Cell cell = row.getCell(cellNumber);
				return cell;
			}

			// Retrive the data from cell
			public static String retriveData(Cell cell) {
				String cellValue = cell.getStringCellValue();
				return cellValue;
			}

			// Retrive a data from a Sheet
			public static String retriveDataFromSheet(Workbook workBook, String sheetNum, int rowNum, int cellNum) {
				Cell cell = workBook.getSheet(sheetNum).getRow(rowNum).getCell(cellNum);
				CellType cellType = cell.getCellType();
				switch (cellType) {
				case STRING:
					// if(cellType.equals("STRING")) {
					String stringCellValue = cell.getStringCellValue();
					return stringCellValue;
				case NUMERIC:
					// } else if(cellType.equals("NUMERIC")) {
					if (DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
						String format2 = format.format(dateCellValue);
						return format2;
					} else {
						double numericCellValue = cell.getNumericCellValue();
						long number = (long) numericCellValue;
						String string = Long.toString(number);
						return string;
					}
				case BOOLEAN:
					// } else if(cellType.equals("BOOLEAN")) {
					boolean booleanCellValue = cell.getBooleanCellValue();
					String string2 = Boolean.toString(booleanCellValue);
					return string2;
				// } else {
				default:
					return null;
				}
			}

			// Create a Sheet in Workbook
			public static Sheet createSheetInWorkbook(Workbook workBook, String newSheetNum) {
				Sheet sheet = workBook.createSheet(newSheetNum);
				return sheet;
			}

			// Create a row in Sheet
			public static Row createRowInSheet(Sheet sheet, int rowNum) {
				Row row = sheet.createRow(rowNum);
				return row;
			}

			// Create a cell in Row
			public static Cell createCellInRow(Row row, int cellNum) {
				Cell cell = row.createCell(cellNum);
				return cell;
			}

			// Pass Value into a Cell
			public static void passValueIntoCell(Cell cell, String value) {
				cell.setCellValue(value);
			}

			// Date And Time Print 
			public static void Date() {

				Date d = new Date();
				System.out.println(d);
			}
			
			// Implicitlywait 
			public static void implicitwaiting(long sec) {

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			
			public static void quiting() {
		        driver.quit();
			}
			
		}

		




