package com.Walker.Spring.Boot.rest;

import com.Walker.Spring.Boot.rest.model.JobPost;
import com.Walker.Spring.Boot.rest.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin(origins = "http://localhost:3000")
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("jobPosts")
    @ResponseBody // parsing the rest request and sedning the data
    public List<JobPost> getAllJob() {
      return jobService.getAllJobs();
    }
   @GetMapping("/jobPost/{postId}")
   @ResponseBody
    public JobPost getJobById(@PathVariable int postId) {
        return jobService.getJob(postId);
   }
   @PostMapping("/jobPost")
   @ResponseBody
    public void addJob(@RequestBody JobPost jobPost) {
        jobService.addJob(jobPost);
   }
  @PutMapping("jobPost")
  @ResponseBody
   public JobPost updateJob(@RequestBody JobPost jobPost) {
        jobService.updateJob(jobPost);
        return jobService.getJob(jobPost.getPostId());
   }
   @DeleteMapping("jobPost/{postId}")
   public JobPost deleteJob(@PathVariable int postId) {
        jobService.deleteJob(postId);
        return jobService.getJob(postId);
   }
}
