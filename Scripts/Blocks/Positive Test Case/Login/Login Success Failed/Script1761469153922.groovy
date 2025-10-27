import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint

// Ambil data dari binding
String username = Username

String password = Password

// Step 1: Open website
'Membuka Browser'
WebUI.openBrowser('')

'Sistem mengarahkan ke website'
WebUI.navigateToUrl(GlobalVariable.baseUrl)

'Sistem memperbesar browser'
WebUI.maximizeWindow()

// Step 2: Klik tombol "Make Appointment"
WebUI.click(findTestObject('Page_Home/makeAppoint_btn'))

// Step 3: Input username dan password (kondisi kosong di-handle)
if ((username != null) && (username != '')) {
    WebUI.setText(findTestObject('Page_Login/Username_textField'), username)
}

if ((password != null) && (password != '')) {
    WebUI.setText(findTestObject('Page_Login/Password_textField'), password)
}

// Step 4: Klik tombol Login
WebUI.click(findTestObject('Page_Login/Login_btn'))

// Step 5: Validasi Hasil
if ((((username == null) || (username.trim() == '')) || (password == null)) || (password.trim() == '')) {
    // Jika salah satu kosong → muncul validasi error
    WebUI.verifyElementPresent(findTestObject('Page_Login/LoginfailedPlease_text'), 5) // ✅ Ganti verifyElementText() dengan verifyElementVisible() (untuk cek elemen di halaman Appointment)
    // ✅ Perbaikan di sini: ubah jadi verifyElementText(TestObject, expectedText)
} else {
    boolean isSuccess = WebUI.verifyElementVisible(findTestObject('Page_MakeAppointment/input_Medicaid_programs'), FailureHandling.OPTIONAL)

    if (isSuccess) {
        println('✅ Login berhasil — Masuk ke halaman Appointment')
    } else {
        WebUI.verifyElementText(findTestObject('Page_Login/LoginfailedPlease_text'), 'Login failed! Please ensure the username and password are valid.', 
            FailureHandling.OPTIONAL)

        println('❌ Login gagal — Username atau Password salah')
    }
}

WebUI.takeScreenshot()

WebUI.delay(5)

// Step 6: Tutup browser
WebUI.closeBrowser()

