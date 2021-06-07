package com.example.swagger.controller;

import com.example.swagger.dto.UserReq;
import com.example.swagger.dto.UserRes;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

@Api(tags = "API를 제공하는 Controller")
@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "x", value = "x의 값", required = true, dataType = "int", paramType = "path"),
                    @ApiImplicitParam(name = "y", value = "y의 값", required = true, dataType = "int", paramType = "query"),
            }
    )
    @GetMapping("/plus/{x}")
    public int plus(
            @PathVariable int x,
            @RequestParam  int y
    ) {
        return x + y;
    }


    @ApiResponse(code = 502, message = "사용자의 나이가 10살 이하일 때")
    @ApiOperation(value = "사용자의 정보를 echo하는 메소드")
    @PostMapping("/user")
    public UserRes userRes(UserReq userReq) {
        return new UserRes(userReq.getName(), userReq.getAge());
    }
}
