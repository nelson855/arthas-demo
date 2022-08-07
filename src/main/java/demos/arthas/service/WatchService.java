package demos.arthas.service;

import com.google.common.collect.Lists;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author nelson
 * @description
 * @date 2022-08-07 11:35 上午
 */
@Service
@Log4j2
public class WatchService {

    public void watch1(int num) {
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            log.error("watch 1 error", e);
        }
    }

    public void watch2(int num) {
        try {
            Thread.sleep(200);
        } catch (Exception e) {
            log.error("watch 2 error", e);
        }
    }

    public void watch3(int num) {
        throw new RuntimeException();
    }

    public List<Integer> watch4(int num) {
        try {
            if (num == 0) {
                Thread.sleep(200);
            }else {
                Thread.sleep(100);
            }
        } catch (Exception e) {
            log.error(e.getStackTrace());
        }
        return IntStream.range(0, 5).limit(5).map(i -> 5 - i).boxed().collect(Collectors.toList());
    }
}
