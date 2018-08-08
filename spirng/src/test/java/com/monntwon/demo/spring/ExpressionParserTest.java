package com.monntwon.demo.spring;

import org.junit.Test;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;

/**
 * @author hanlimin
 * @Description: TODO
 * @email hanlimin@yuantutech.com
 * @date 2018/7/31
 */
public class ExpressionParserTest {

    @Test
    public void elTest(){
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("'Hello World'.concat('!')");
        System.err.println(expression.getValue());
    }

    public void elContextTest(){
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
    }
}
