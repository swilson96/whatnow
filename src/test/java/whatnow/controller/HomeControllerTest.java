package whatnow.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HomeControllerTest {

    private HomeController controller;

    @Before
    public void setUp() {
        controller = new HomeController();
    }

    @Test
    public void homeReturnsHomeView() {
        ModelAndView result = controller.helloWorld();

        Assert.assertNotNull(result);
        Assert.assertEquals("home", result.getViewName());
    }

}
