package com.chrisjhkim.hellospring;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Scope("request")
public class RequestScopeData {

}
