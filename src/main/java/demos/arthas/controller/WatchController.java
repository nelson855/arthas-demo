package demos.arthas.controller;

import demos.arthas.controller.bean.WatchRequest;
import demos.arthas.controller.bean.WatchResponse;
import demos.arthas.service.WatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author nelson
 * @description
 * @date 2022-08-07 10:28 上午
 */
@Controller
@RequestMapping("/watch")
public class WatchController {
    @Autowired
    private WatchService watchService;

    private static final String NAME = "WATCH_CONTROLLER";

    @RequestMapping("/nums")
    @ResponseBody
    public List<Integer> nums(@RequestParam String str) {
        int num = Integer.parseInt(str);
        return IntStream.range(0, num).limit(5).map(i -> num - i).boxed().collect(Collectors.toList());
    }

    @RequestMapping(value = "/watch-1", method = RequestMethod.POST)
    @ResponseBody
    public WatchResponse watch1(@RequestBody WatchRequest watchrequest) {
        WatchResponse response = new WatchResponse();
        response.setId(watchrequest.getId());
        response.setValue(watchrequest.getName() + "_" + watchrequest.getCode());
        return response;
    }

    @RequestMapping(value = "/watch-2", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> watch2(@RequestParam int num) {
        if (num % 3 == 0) {
            watchService.watch1(num);
        } else if (num % 3 == 1) {
            watchService.watch1(num);
            watchService.watch2(num);
        } else {
            watchService.watch3(num);
        }
        return IntStream.range(0, num).limit(5).map(i -> num - i).boxed().collect(Collectors.toList());
    }

    @RequestMapping(value = "/watch-3", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> watch3() {
        return watchService.watch4(0);
    }

    @RequestMapping(value = "/watch-4", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> watch4() {
        return watchService.watch4(1);
    }
}
