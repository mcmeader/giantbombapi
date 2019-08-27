package com.example.giantbombapigroupproject

import android.content.Context
import com.example.giantbombapigroupproject.enum_singleton.UserData
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.io.File
import java.io.FileInputStream

@RunWith(JUnit4::class)
class TestLoginJSONFile {
    private val testFile = File(
        "C:\\Users\\mmeader\\AndroidStudioProjects\\Timefighter\\" +
                "GiantBombAPIGroupProject\\app\\src\\main\\assets\\loginJSONFile.json"
    )
    private val mockUser = "test"
    private val mockPassword = "1234"
    private val tokenKey = "c2b985fe9b4a44e99f36d2fdacdd440a"

    @Mock
    lateinit var contextMock:Context

    init {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun testFileExists() {
        assert(testFile.exists())
    }

    /*
    @Test
    fun testReadFile() {
        val mockUserData = UserData(FileInputStream(testFile),contextMock)
        val mockMainClass = Mockito.mock(JSONManager.FileHandler(mockUserData,"")::class.java)
        val a = FileInputStream(File("C:\\Users\\mmeader\\AndroidStudioProjects\\Timefighter\\GiantBombAPIGroupProject\\app\\src\\test\\resources\\mockJSONFile.txt"))
        //val loadMockJSONFile = javaClass.getResourceAsStream("mockJSONFile.txt")
        print(mockMainClass.readFile())
    }
*/

    @Test
    //TODO: Write a correct JSON format unit test
    fun testLoginFormatCorrect() {
        var fileText = ""
        val readFile = testFile.bufferedReader()
        readFile.forEachLine { fileText += it }
        assert(fileText.contains(",  {    \"username\": \"$mockUser\",    \"password\": \"$mockPassword\",    " +
                "\"tokenKey\": \"$tokenKey\"  }"))
    }
}
