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

'User memilih Fasilitas yang diinginkan'
WebUI.selectOptionByValue(findTestObject('Page_MakeAppointment/select_Facility'), Facility, true)

//WebUI.check(findTestObject('Page_MakeAppointment/input_Readmission'))
'User melakukan check Hospital Readmission'
if (Readmission == true) {
    WebUI.check(findTestObject('Page_MakeAppointment/input_Readmission'))
} else {
    WebUI.uncheck(findTestObject('Page_MakeAppointment/input_Readmission'))
}

'User memilih Program Healthcare yang diinginkan'
//WebUI.check(findTestObject('Object Repository/RecordPlay/Page_MakeAppointment/input_Medicaid_programs'))

select_radio = Programs
switch (select_radio) {
	case 'Medicaid':
	WebUI.check(findTestObject('Page_MakeAppointment/input_Medicaid_programs'))
	break
	case 'Medicare':
	WebUI.check(findTestObject('Page_MakeAppointment/input_Medicare_programs'))
	break
	case 'None' :
	WebUI.check(findTestObject('Page_MakeAppointment/input_None_programs'))
	break
	default :
	WebUI.check(findTestObject('Page_MakeAppointment/input_None_programs'))
	break
}

'User memilih Tanggal Kunjungan'
WebUI.setText(findTestObject('Page_MakeAppointment/input_VisitDate'), VisitDate)

'User memasukkan Komentar'
WebUI.setText(findTestObject('Page_MakeAppointment/input_Comment'), Komentar)

'User mengklik Tombol Book Appointment'
WebUI.click(findTestObject('Page_MakeAppointment/Book Appointment_Btn'))

WebUI.waitForElementVisible(findTestObject('Page_AppointmentConfirmation/Pleasebeinformed_text'), 30)

WebUI.verifyElementVisible(findTestObject('Page_AppointmentConfirmation/Pleasebeinformed_text'))

WebUI.takeScreenshot(FailureHandling.CONTINUE_ON_FAILURE)

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_Facility'), Facility)

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_VisitDate'), VisitDate)

WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_Comment'), Komentar)

if (Readmission == true) {
    WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_Readmission'), 'Yes')
} else {
    WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_Readmission'), 'No', FailureHandling.OPTIONAL)
}

select_radio = Programs
switch (select_radio) {
	case 'Medicaid':
	WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_HealthcareProgram'), Programs)
	break
	case 'Medicare':
	WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_HealthcareProgram'), Programs)
	break
	case 'None' :
	WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_HealthcareProgram'), Programs)
	break
	default :
	WebUI.verifyElementText(findTestObject('Page_AppointmentConfirmation/lbl_HealthcareProgram'), 'None')
	break
}
