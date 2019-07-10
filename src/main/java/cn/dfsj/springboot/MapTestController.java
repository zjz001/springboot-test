package cn.dfsj.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/page")
public class MapTestController {

    @RequestMapping("map")
    public void demo(){
        Map<Long,Long> map = new HashMap<Long,Long>();
        long mapSize = 1000000000;
        long start = System.currentTimeMillis();
        for (long i = 0; i <mapSize ; i++) {
            map.put(i,i);
        }
        long end = System.currentTimeMillis();
        System.out.println("未初始化耗时"+(end-start));
    }

    @GetMapping("/test")
    public ModelAndView test(){
        ModelAndView hello = new ModelAndView();
        hello.setViewName("hello");
        return hello;
    }



    @GetMapping("/test1")
    public String test1(){
        return "hello";
    }
}
