package com.rabbiter.em.controller;



import com.rabbiter.em.annotation.Authority;
import com.rabbiter.em.entity.AuthorityType;
import com.rabbiter.em.service.IncomeService;
import com.rabbiter.em.common.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Authority(AuthorityType.requireAuthority)
@RestController
@RequestMapping("/api/income")
public class IncomeController {

    @Resource
    private IncomeService incomeService;

    @GetMapping("/chart")
    public Result getChart(){
        return Result.success(incomeService.getChart());
    }
    @GetMapping("/week")
    public Result getWeekIncome(){
        return Result.success(incomeService.getWeekIncome());
    }

    @GetMapping("/month")
    public Result getMonthIncome(){
        return Result.success(incomeService.getMonthIncome());
    }
}
