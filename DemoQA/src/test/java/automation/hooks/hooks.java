package automation.hooks;

import org.junit.After;
import org.junit.Before;
import automation.utils.driverFactory;
public class hooks {
    @Before
    public void setUp(){
      driverFactory.getDriver();
    }

    @After
    public void teadDown(){
        driverFactory.quitDriver();
    }
}

