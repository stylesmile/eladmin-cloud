package com.stylesmile.console.modules.quartz.config;

import com.stylesmile.console.modules.quartz.domain.QuartzJob;
import com.stylesmile.console.modules.quartz.utils.QuartzManage;
import com.stylesmile.console.modules.quartz.repository.QuartzJobRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Stylesmile
 * @date 2019-01-07
 */
@Component
public class JobRunner implements ApplicationRunner {

    private final QuartzJobRepository quartzJobRepository;

    private final QuartzManage quartzManage;

    public JobRunner(QuartzJobRepository quartzJobRepository, QuartzManage quartzManage) {
        this.quartzJobRepository = quartzJobRepository;
        this.quartzManage = quartzManage;
    }

    /**
     * 项目启动时重新激活启用的定时任务
     * @param applicationArguments /
     */
    @Override
    public void run(ApplicationArguments applicationArguments){
        System.out.println("--------------------注入定时任务---------------------");
        List<QuartzJob> quartzJobs = quartzJobRepository.findByIsPauseIsFalse();
        quartzJobs.forEach(quartzManage::addJob);
        System.out.println("--------------------定时任务注入完成---------------------");
    }
}
