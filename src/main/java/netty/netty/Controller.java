package netty.netty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @Date 2019/1/11
 * @Description
 */
@RestController
@Slf4j
public class Controller {

    @RequestMapping(value = "/homepage",method = RequestMethod.GET)
    public String login(){
        return  "hello word";
    }
}
