package com.stylesmile.console.modules.quartz.task;

import com.stylesmile.console.modules.monitor.service.VisitsService;
import org.springframework.stereotype.Component;

/**
 * @author Stylesmile
 * @date 2019-12-25
 */
@Component
public class VisitsTask {

    private final VisitsService visitsService;

    public VisitsTask(VisitsService visitsService) {
        this.visitsService = visitsService;
    }

    public void run(){
        visitsService.save();
    }
}
