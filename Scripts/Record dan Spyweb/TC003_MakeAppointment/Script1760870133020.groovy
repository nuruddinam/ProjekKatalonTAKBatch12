import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Record dan Spyweb/TC002_Login_Spyweb'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Page_MakeAppointment/select_TokyoCURA_btn'), 'Hongkong CURA Healthcare Center', 
    true)

WebUI.click(findTestObject('Page_MakeAppointment/ApplyReadmission_radioBtn'))

WebUI.click(findTestObject('Object Repository/RecordPlay/Page_MakeAppointment/input_Medicaid_programs'))

WebUI.click(findTestObject('Page_MakeAppointment/VisitDate_input'))

WebUI.click(findTestObject('Page_MakeAppointment/td_20'))

WebUI.setText(findTestObject('Page_MakeAppointment/Comment_textArea'), 'Janjian Dokter')

WebUI.click(findTestObject('Page_MakeAppointment/Book Appointment_Btn'))

WebUI.waitForElementVisible(findTestObject('Page_AppointmentConfirmation/Pleasebeinformed_text'), 30)

WebUI.verifyElementVisible(findTestObject('Page_AppointmentConfirmation/Pleasebeinformed_text'))

