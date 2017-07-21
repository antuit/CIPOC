import org.junit.Test
import junit.framework.TestCase
import org.junit.Assert._
import org.scalatest.FunSuite

class ConnectionTest extends FunSuite {

  test("Checking JDBC Connection Established or Not ?!!!") {
    assertFalse(cipoc.getSrcConnection());
  }

}
 
 

